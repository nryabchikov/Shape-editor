package by.ryabchikov.lab1.friend_plugin;

import by.ryabchikov.lab1.model.Shape;

public class FigureToShapeAdapter extends Shape {
    private final Figure figure;

    public FigureToShapeAdapter(Figure figure) {
        this.figure = figure;
    }
}
