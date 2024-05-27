package by.ryabchikov.lab1.friend_plugin;

import by.ryabchikov.lab1.model.Shape;

public class ShapeToFigureAdapter extends Figure {
    private final Shape shape;

    public ShapeToFigureAdapter(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void setPoints(MyPoint dot, int w, int h) {

    }

    @Override
    public boolean pointInFigure(int x, int y) {
        return false;
    }
}
