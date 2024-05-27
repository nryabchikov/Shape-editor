package by.ryabchikov.lab1.util.factory;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.figure.Circle;
import by.ryabchikov.lab1.model.figure.polygons.Triangle;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Parallelogram;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rectangle;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rhombus;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Square;
import by.ryabchikov.lab1.util.strategy.DrawingStrategy;

import java.util.HashMap;
import java.util.Map;

public abstract class DrawingStrategyFactory {
    private static final Map<Class<? extends Shape>, DrawingStrategyFactory> factories = new HashMap<>();

    static {
        factories.put(Circle.class, new CircleDrawingStrategyFactory());
        factories.put(Triangle.class, new TriangleDrawingStrategyFactory());
        factories.put(Square.class, new SquareDrawingStrategyFactory());
        factories.put(Rectangle.class, new RectangleDrawingStrategyFactory());
        factories.put(Rhombus.class, new RhombusDrawingStrategyFactory());
        factories.put(Parallelogram.class, new ParallelogramDrawingStrategyFactory());
    }

    public static DrawingStrategyFactory getDrawingStrategyFactory(Shape shape) {
        return factories.get(shape.getClass());
    }

    //для добавления фабрик динамически
    public static void addDrawingStrategyFactory(Class<? extends Shape> shapeClass, DrawingStrategyFactory factory) {
        factories.put(shapeClass, factory);
    }

    public abstract DrawingStrategy createDrawingStrategy();
}

