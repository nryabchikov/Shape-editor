package by.ryabchikov.lab1.figure.polygon.quadrangle;

import by.ryabchikov.lab1.model.Point;

public class Rhombus extends Parallelogram {
    public Rhombus(Point startPoint, int side, double angle) {
        super(startPoint, side, side, angle);
    }

    @Override
    protected Point[] getPoints() {
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

    @Override
    public String draw() {
        Point[] points = getPoints();
        return "<svg height=\"700\" width=\"700\">" +
                "<polygon points=\"" + points[0].getX() + "," + points[0].getY() + " " + points[1].getX() + "," +
                points[1].getY() + " " + points[2].getX() + "," + points[2].getY() + " " + points[3].getX() + "," +
                points[3].getY() + "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />" + "</svg>";
    }
}
