package by.ryabchikov.lab1.util.factory;

import by.ryabchikov.lab1.util.strategy.DrawingStrategy;
import by.ryabchikov.lab1.util.strategy.RectangleDrawingStrategy;

public class RectangleDrawingStrategyFactory extends DrawingStrategyFactory {
    @Override
    public DrawingStrategy createDrawingStrategy() {
        return new RectangleDrawingStrategy();
    }
}
