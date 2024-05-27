package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.service.SerializationService;
import by.ryabchikov.lab1.friend_plugin.ReversePluginAdapter;
import by.ryabchikov.lab1.util.FigureDrawer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@AllArgsConstructor
@RestController
public class SerializationController {

    private SerializationService serializationService;
    private FigureDrawer figureDrawer;

    @PostMapping("/serialize/binary")
    public ResponseEntity<String> serializeToBinary() {
        try {
            serializationService.serializeToBinary(MapOfFigures.mapOfFigures);
            if (FigureController.isArchivePluginLoaded) {
                serializationService.zipFile("shapes.bin", "bin.zip");
            }
            return ResponseEntity.ok("Serialization successful");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/deserialize/binary")
    public ResponseEntity<String> deserializeFromBinary() {
        try {
            if (FigureController.isArchivePluginLoaded) {
                serializationService.unzipFile("bin.zip");
            }
            Map<Integer, Shape> mapOfFigures = serializationService.deserializeFromBinary();
            return ResponseEntity.ok(figureDrawer.drawAll(mapOfFigures));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/serialize/xml")
    public ResponseEntity<String> serializeToXml() {
        try {
            serializationService.serializeToXml(MapOfFigures.mapOfFigures);
            if (FigureController.isArchivePluginLoaded) {
                serializationService.zipFile("shapes.xml", "xml.zip");
            }

            if (FigureController.isArchivePluginLoaded) {
                Class<?> reverseAllClass = Class.forName("by.ryabchikov.lab1.friend_plugin.ReverseAll");
                Constructor<?> constructor = reverseAllClass.getDeclaredConstructor();
                Object reverseAllPlugin = constructor.newInstance();
                ReversePluginAdapter adapter = new ReversePluginAdapter(reverseAllPlugin);
                for (Shape shape : MapOfFigures.mapOfFigures.values()) {
                    String serializedData = adapter.postSerialize(shape.toString());
                    System.out.println("Reversed data: " + serializedData);
                    String deserializedData = adapter.preDeserialize(serializedData);
                    System.out.println("Unreversed data: " + deserializedData);
                }
            }

            return ResponseEntity.ok("Serialization successful");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/deserialize/xml")
    public ResponseEntity<String> deserializeFromXml() {
        try {
            if (FigureController.isArchivePluginLoaded) {
                serializationService.unzipFile("xml.zip");
            }
            Map<Integer, Shape> mapOfFigures = serializationService.deserializeFromXml();
            System.out.println(mapOfFigures);

            return ResponseEntity.ok(figureDrawer.drawAll(mapOfFigures));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


}
