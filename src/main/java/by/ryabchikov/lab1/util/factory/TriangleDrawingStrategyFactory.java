package by.ryabchikov.lab1.util.factory;

import by.ryabchikov.lab1.util.strategy.DrawingStrategy;
import by.ryabchikov.lab1.util.strategy.TriangleDrawingStrategy;

public class TriangleDrawingStrategyFactory extends DrawingStrategyFactory {
    @Override
    public DrawingStrategy createDrawingStrategy() {
        return new TriangleDrawingStrategy();
    }
}
