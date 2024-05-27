package by.ryabchikov.lab1.friend_plugin;//package by.ryabchikov.lab1.friend_plugin;
//
//import by.ryabchikov.lab1.model.Shape;
//
//public class ReversePluginAdapter {
//    private final ReverseAll reverseAllPlugin;
//
//    public ReversePluginAdapter(ReverseAll reverseAllPlugin) {
//        this.reverseAllPlugin = reverseAllPlugin;
//    }
//
//    public Shape preSerialize(Shape shape) {
//        ShapeToFigureAdapter figureAdapter = new ShapeToFigureAdapter(shape);
//        Figure result = reverseAllPlugin.preSerPlugin(figureAdapter);
//        return new FigureToShapeAdapter(result);
//    }
//
//    public String postSerialize(String serializedData) {
//        return reverseAllPlugin.postSerPlugin(serializedData);
//    }
//
//    public String preDeserialize(String serializedData) {
//        return reverseAllPlugin.preDesPlugin(serializedData);
//    }
//
//    public Shape postDeserialize(Shape shape) {
//        ShapeToFigureAdapter figureAdapter = new ShapeToFigureAdapter(shape);
//        Figure result = reverseAllPlugin.postDesPlugin(figureAdapter);
//        return new FigureToShapeAdapter(result);
//    }
//}
//

import by.ryabchikov.lab1.model.Shape;

import java.lang.reflect.Method;

public class ReversePluginAdapter {
    private final Object reverseAllPlugin; // Тип ReverseAll неизвестен, поэтому используем Object

    public ReversePluginAdapter(Object reverseAllPlugin) {
        this.reverseAllPlugin = reverseAllPlugin;
    }

    public Shape preSerialize(Shape shape) {
        try {
            // Получаем метод preSerPlugin
            Method preSerPluginMethod = reverseAllPlugin.getClass().getMethod("preSerPlugin", Object.class);

            // Вызываем метод preSerPlugin и передаем ему аргумент shape
            Object result = preSerPluginMethod.invoke(reverseAllPlugin, shape);

            // Преобразуем результат в Shape и возвращаем его
            return (Shape) result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String postSerialize(String serializedData) {
        try {
            // Получаем метод postSerPlugin
            Method postSerPluginMethod = reverseAllPlugin.getClass().getMethod("postSerPlugin", String.class);

            // Вызываем метод postSerPlugin и передаем ему аргумент serializedData
            Object result = postSerPluginMethod.invoke(reverseAllPlugin, serializedData);

            // Преобразуем результат в строку и возвращаем ее
            return (String) result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String preDeserialize(String serializedData) {
        try {
            // Получаем метод preDesPlugin
            Method preDesPluginMethod = reverseAllPlugin.getClass().getMethod("preDesPlugin", String.class);

            // Вызываем метод preDesPlugin и передаем ему аргумент serializedData
            Object result = preDesPluginMethod.invoke(reverseAllPlugin, serializedData);

            // Преобразуем результат в строку и возвращаем ее
            return (String) result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Shape postDeserialize(Shape shape) {
        try {
            // Получаем метод postDesPlugin
            Method postDesPluginMethod = reverseAllPlugin.getClass().getMethod("postDesPlugin", Object.class);

            // Вызываем метод postDesPlugin и передаем ему аргумент shape
            Object result = postDesPluginMethod.invoke(reverseAllPlugin, shape);

            // Преобразуем результат в Shape и возвращаем его
            return (Shape) result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

