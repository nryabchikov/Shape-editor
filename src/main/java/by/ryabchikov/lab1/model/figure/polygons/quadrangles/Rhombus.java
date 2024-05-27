package by.ryabchikov.lab1.model.figure.polygons.quadrangles;

import by.ryabchikov.lab1.model.Point;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Rhombus extends Parallelogram {
    public Rhombus(Point startPoint, int side, double angle) {
        super(startPoint, side, side, angle);
    }

    @Override
    public Point[] getPoints() {
        Point[] points = new Point[4];
        double radianAngle = Math.toRadians(angle);
        Point secondPoint = new Point((int)(startPoint.getX() + width * Math.cos(radianAngle)),
                (int)(startPoint.getY() + width * Math.sin(radianAngle)));
        Point thirdPoint = new Point((int)(secondPoint.getX() + width * Math.cos(radianAngle)),
                (int)(secondPoint.getY() - width * Math.sin(radianAngle)));
        Point fourthPoint = new Point((int)(thirdPoint.getX() - width * Math.cos(radianAngle)),
                (int)(thirdPoint.getY() - width * Math.sin(radianAngle)));
        points[0] = startPoint;
        points[3] = secondPoint;
        points[2] = thirdPoint;
        points[1] = fourthPoint;
        return points;
    }
}
