package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.PluginClassLoader;
import by.ryabchikov.lab1.controller.FigureController;
import by.ryabchikov.lab1.friend_plugin.ReversePluginAdapter;
import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.Shape;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import by.ryabchikov.lab1.util.factory.DrawingStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SerializationService {
    private final String binaryFile = "shapes.bin";
    private final String xmlFile = "shapes.xml";
    private final String archivePLuginPath = "src/main/resources/plugin/archive.jar";

    public void serializeToBinary(Map<Integer, Shape> mapOfFigures) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(binaryFile))) {
            outputStream.writeObject(mapOfFigures);
        }
    }

    public Map<Integer, Shape> deserializeFromBinary() throws IOException, ClassNotFoundException {
        PluginClassLoader classLoader =
                new PluginClassLoader(new URL[]{new File("src/main/resources/plugin/updated_star.jar").toURI().toURL()});
        classLoader.loadClass("by.ryabchikov.lab1.model.figure.Star");
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(binaryFile)) {
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws ClassNotFoundException {
                return classLoader.loadClass(desc.getName());
            }
        }) {
            loadDrawingStrategyFactories(classLoader);
            return (Map<Integer, Shape>) inputStream.readObject();
        }
    }

    public void serializeToXml(Map<Integer, Shape> map) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(xmlFile)))) {
            encoder.writeObject(map);
        }
    }

    public Map<Integer, Shape> deserializeFromXml() throws IOException {
        PluginClassLoader classLoader =
                new PluginClassLoader(new URL[]{new File("src/main/resources/plugin/updated_star.jar").toURI().toURL()});
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(xmlFile)), null,
                null, classLoader)) {
            loadDrawingStrategyFactories(classLoader);
            return (Map<Integer, Shape>) decoder.readObject();
        }
    }

    private void loadDrawingStrategyFactories(URLClassLoader classLoader) {
        try {
            Class<? extends Shape> starClass = (Class<? extends Shape>) classLoader.loadClass("by.ryabchikov.lab1.model.figure.Star");
            Class<?> drawingStrategyFactoryClass = classLoader.loadClass("by.ryabchikov.lab1.util.factory.StarDrawingStrategyFactory");
            DrawingStrategyFactory.addDrawingStrategyFactory(starClass, (DrawingStrategyFactory) drawingStrategyFactoryClass.newInstance());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            System.err.println("Ошибка при загрузке фабрик: " + e.getMessage());
        }
    }

    public void zipFile(String filename, String archiveName) throws IOException {
        PluginClassLoader classLoader = new PluginClassLoader(new URL[]{new File(archivePLuginPath).toURI().toURL()});
        try {
            Class<?> fileArchiverClass = classLoader.loadClass("by.ryabchikov.lab1.util.FileArchiver");
            Object fileArchiverInstance = fileArchiverClass.newInstance();
            Method zipMethod = fileArchiverClass.getDeclaredMethod("zip", String.class, String.class);
            zipMethod.invoke(fileArchiverInstance, filename, archiveName);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error zipping file: " + e.getMessage());
        }
    }

    public void unzipFile(String archiveName) throws IOException {
        PluginClassLoader classLoader = new PluginClassLoader(new URL[]{new File(archivePLuginPath).toURI().toURL()});
        try {
            Class<?> fileArchiverClass = classLoader.loadClass("by.ryabchikov.lab1.util.FileArchiver");
            Object fileArchiverInstance = fileArchiverClass.newInstance();
            Method unzipMethod = fileArchiverClass.getDeclaredMethod("unzip", String.class);
            unzipMethod.invoke(fileArchiverInstance, archiveName);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error unzipping file: " + e.getMessage());
        }
    }
}

