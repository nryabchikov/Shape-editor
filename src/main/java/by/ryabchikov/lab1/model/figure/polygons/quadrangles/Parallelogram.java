package by.ryabchikov.lab1.model.figure.polygons.quadrangles;

import by.ryabchikov.lab1.model.Point;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Parallelogram extends QuadrangleAbstract {
    protected double angle;
    public Parallelogram(Point startPoint, int width, int height, double angle) {
        super(startPoint, width, height);
        this.angle = angle;
    }

    public Point[] getPoints() {
        Point[] points = new Point[4];
        double radianAngle = Math.toRadians(angle);
        Point secondPoint = new Point(startPoint.getX() + width, startPoint.getY());
        Point thirdPoint = new Point((int)(startPoint.getX() + height * Math.sin(radianAngle)),
                (int)(startPoint.getY() + height * Math.cos(radianAngle)));
        Point fourthPoint = new Point((int)(secondPoint.getX() + height * Math.sin(radianAngle)),
                (int)(secondPoint.getY() + height * Math.cos(radianAngle)));
        points[0] = startPoint;
        points[3] = secondPoint;
        points[1] = thirdPoint;
        points[2] = fourthPoint;
        return points;
    }
}
