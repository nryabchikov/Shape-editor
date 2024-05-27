package by.ryabchikov.lab1.util.factory;

import by.ryabchikov.lab1.util.strategy.DrawingStrategy;
import by.ryabchikov.lab1.util.strategy.SquareDrawingStrategy;

public class SquareDrawingStrategyFactory extends DrawingStrategyFactory {
    @Override
    public DrawingStrategy createDrawingStrategy() {
        return new SquareDrawingStrategy();
    }
}
