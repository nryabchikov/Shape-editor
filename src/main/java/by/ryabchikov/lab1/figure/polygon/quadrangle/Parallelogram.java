package by.ryabchikov.lab1.figure.polygon.quadrangle;

import by.ryabchikov.lab1.model.Point;

public class Parallelogram extends Quadrangle {
    protected double angle;
    public Parallelogram(Point startPoint, int width, int height, double angle) {
        super(startPoint, width, height);
        this.angle = angle;
    }

    protected Point[] getPoints() {
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

    @Override
    public String draw() {
        Point[] points = getPoints();
        return "<svg height=\"700\" width=\"700\">" +
                "<polygon points=\"" + points[0].getX() + "," + points[0].getY() + " " + points[1].getX() + "," +
                points[1].getY() + " " + points[2].getX() + "," + points[2].getY() + " " + points[3].getX() + "," +
                points[3].getY() + "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />" + "</svg>";
    }
}
