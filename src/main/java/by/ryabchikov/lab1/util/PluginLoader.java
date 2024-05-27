package by.ryabchikov.lab1.util;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.util.data.ThirdIntPointData;

import by.ryabchikov.lab1.util.factory.DrawingStrategyFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

@Component
public class PluginLoader extends ClassLoader {
    private Class<?> starControllerClass;
    private Object starControllerInstance;

    public void loadPlugin(String pluginName) {
        try {
            URL pluginUrl = getClass().getClassLoader().getResource("plugin/" + pluginName);
            if (pluginUrl == null) {
                System.err.println("Плагин с именем " + pluginName + " не найден");
                return;
            }

            URLClassLoader classLoader = new URLClassLoader(new URL[]{pluginUrl});

            Class<?> starClass = classLoader.loadClass("by.ryabchikov.lab1.model.figure.Star");
            Class<?> starDrawingStrategyClass =
                    classLoader.loadClass("by.ryabchikov.lab1.util.strategy.StarDrawingStrategy");
            Class<?> starDrawingStrategyFactory =
                    classLoader.loadClass("by.ryabchikov.lab1.util.factory.StarDrawingStrategyFactory");

            Object starDrawingStrategyInstance = starDrawingStrategyClass.newInstance();
            Class<?> starServiceClass = classLoader.loadClass("by.ryabchikov.lab1.service.StarService");
            Constructor<?> starServiceConstructor = starServiceClass.getConstructor(starDrawingStrategyClass);
            Object starServiceInstance = starServiceConstructor.newInstance(starDrawingStrategyInstance);
            starControllerClass = classLoader.loadClass("by.ryabchikov.lab1.controller.StarController");
            Constructor<?> starControllerConstructor = starControllerClass.getConstructor(starServiceClass);
            starControllerInstance = starControllerConstructor.newInstance(starServiceInstance);

            DrawingStrategyFactory.addDrawingStrategyFactory((Class<? extends Shape>) starClass,
                    (DrawingStrategyFactory) starDrawingStrategyFactory.newInstance());

            classLoader.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Ошибка при загрузке плагина " + pluginName + ": " + e.getMessage());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String invokeControllerMethods(ThirdIntPointData thirdIntPointData, String methodName) throws Exception {
        Method[] methods = starControllerClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostMapping.class) && methodName.equals("buildStar")) {
                if (method.getName().equals("buildStar")) {
                    return (String) method.invoke(starControllerInstance, thirdIntPointData);
                }
            } else if (method.isAnnotationPresent(GetMapping.class) && methodName.equals("drawStar")) {
                if (method.getName().equals("drawStar")) {
                    return (String) method.invoke(starControllerInstance);
                }
            }
        }
        return "";
    }

    public void loadArchivePlugin(String pluginName) {
        try {
            URL pluginUrl = getClass().getClassLoader().getResource("plugin/" + pluginName);
            if (pluginUrl == null) {
                System.err.println("Плагин с именем " + pluginName + " не найден");
                return;
            }
            URLClassLoader classLoader = new URLClassLoader(new URL[]{pluginUrl});
            Class<?> fileArchiveClass = classLoader.loadClass("by.ryabchikov.lab1.util.FileArchiver");
            classLoader.close();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }

    }


//старая версия для jar в пакете /plugin
//    public void loadPlugin(String pluginName) {
//        try {
//            URL pluginUrl = getClass().getClassLoader().getResource("plugin/" + pluginName);
//            if (pluginUrl == null) {
//                System.err.println("Плагин с именем " + pluginName + " не найден");
//                return;
//            }
//
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{pluginUrl});
//
//            Class<?> starClass = classLoader.loadClass("by.ryabchikov.lab1.plugin.Star");
//            Class<?> starDrawingStrategyClass =
//                    classLoader.loadClass("by.ryabchikov.lab1.plugin.StarDrawingStrategy");
//            Class<?> starDrawingStrategyFactory =
//                    classLoader.loadClass("by.ryabchikov.lab1.plugin.StarDrawingStrategyFactory");
//
//            Object starDrawingStrategyInstance = starDrawingStrategyClass.newInstance();
//
//            Class<?> starServiceClass = classLoader.loadClass("by.ryabchikov.lab1.plugin.StarService");
//
//            Constructor<?> starServiceConstructor = starServiceClass.getConstructor(starDrawingStrategyClass);
//            Object starServiceInstance = starServiceConstructor.newInstance(starDrawingStrategyInstance);
//
//
//            starControllerClass = classLoader.loadClass("by.ryabchikov.lab1.plugin.StarController");
//
//
//            Constructor<?> starControllerConstructor = starControllerClass.getConstructor(starServiceClass);
//            starControllerInstance = starControllerConstructor.newInstance(starServiceInstance);
//
//            DrawingStrategyFactory.addDrawingStrategyFactory((Class<? extends Shape>) starClass,
//                    (DrawingStrategyFactory) starDrawingStrategyFactory.newInstance());
//
//            classLoader.close();
//
//            System.out.println("Плагин " + pluginName + " успешно загружен и добавлен в систему.");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при загрузке плагина " + pluginName + ": " + e.getMessage());
//        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}



