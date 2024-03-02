package by.ryabchikov.lab1.figure.polygon.quadrangle;

import by.ryabchikov.lab1.model.Point;
import by.ryabchikov.lab1.figure.polygon.Polygon;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Quadrangle extends Polygon {
    protected Point startPoint;
    protected int width;
    protected int height;
    public Quadrangle(Point startPoint, int width, int height) {
        super();
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
    }
}
