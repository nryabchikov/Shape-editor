package by.ryabchikov.lab1;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {
    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

//    private Class<?> starControllerClass;
//    private Object starControllerInstance;
//
//    public void loadFactory(String pluginName) {
//        try {
//            URL pluginUrl = getClass().getClassLoader().getResource("plugin/" + pluginName);
//            if (pluginUrl == null) {
//                System.err.println("Плагин с именем " + pluginName + " не найден");
//                return;
//            }
//
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{pluginUrl});
//
//            Class<?> starClass = classLoader.loadClass("by.ryabchikov.lab1.model.figure.Star");
//            Class<?> starDrawingStrategyClass =
//                    classLoader.loadClass("by.ryabchikov.lab1.util.strategy.StarDrawingStrategy");
//            Class<?> starDrawingStrategyFactory =
//                    classLoader.loadClass("by.ryabchikov.lab1.util.factory.StarDrawingStrategyFactory");
//
//            Object starDrawingStrategyInstance = starDrawingStrategyClass.newInstance();
//
//            Class<?> starServiceClass = classLoader.loadClass("by.ryabchikov.lab1.service.StarService");
//
//            Constructor<?> starServiceConstructor = starServiceClass.getConstructor(starDrawingStrategyClass);
//            Object starServiceInstance = starServiceConstructor.newInstance(starDrawingStrategyInstance);
//
//
//            starControllerClass = classLoader.loadClass("by.ryabchikov.lab1.controller.StarController");
//
//
//            Constructor<?> starControllerConstructor = starControllerClass.getConstructor(starServiceClass);
//            starControllerInstance = starControllerConstructor.newInstance(starServiceInstance);
//
//            DrawingStrategyFactory.addDrawingStrategyFactory((Class<? extends Shape>) starClass,
//                    (DrawingStrategyFactory) starDrawingStrategyFactory.newInstance());
//
//            classLoader.close();
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
