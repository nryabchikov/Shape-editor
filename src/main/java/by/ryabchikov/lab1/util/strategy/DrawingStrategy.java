package by.ryabchikov.lab1.util.strategy;

import by.ryabchikov.lab1.model.Shape;

public interface DrawingStrategy {
    String draw(Shape shape);
    String drawWithoutSVG(Shape shape, int index);
}
