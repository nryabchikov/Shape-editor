package by.ryabchikov.lab1.util.factory;

import by.ryabchikov.lab1.util.strategy.DrawingStrategy;
import by.ryabchikov.lab1.util.strategy.RhombusDrawingStrategy;

public class RhombusDrawingStrategyFactory extends DrawingStrategyFactory {
    @Override
    public DrawingStrategy createDrawingStrategy() {
        return new RhombusDrawingStrategy();
    }
}
