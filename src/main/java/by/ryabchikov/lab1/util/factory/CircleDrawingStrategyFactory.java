package by.ryabchikov.lab1.util.factory;

import by.ryabchikov.lab1.util.strategy.CircleDrawingStrategy;
import by.ryabchikov.lab1.util.strategy.DrawingStrategy;

public class CircleDrawingStrategyFactory extends DrawingStrategyFactory {
    @Override
    public DrawingStrategy createDrawingStrategy() {
        return new CircleDrawingStrategy();
    }
}
