package by.ryabchikov.lab1.util.strategy;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.Point;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Parallelogram;
import org.springframework.stereotype.Component;

@Component
public class ParallelogramDrawingStrategy implements DrawingStrategy {

    @Override
    public String draw(Shape shape) {
        Parallelogram parallelogram = (Parallelogram) shape;
        Point[] points = parallelogram.getPoints();
        return "<svg height=\"700\" width=\"700\">" +
                "<polygon points=\"" + points[0].getX() + "," + points[0].getY() + " " + points[1].getX() + "," +
                points[1].getY() + " " + points[2].getX() + "," + points[2].getY() + " " + points[3].getX() + "," +
                points[3].getY() + "\" style=\"fill:" + parallelogram.getColor() + ";stroke:purple;stroke-width:1\" />"
                + "</svg>";
    }

    @Override
    public String drawWithoutSVG(Shape shape, int index) {
        Parallelogram parallelogram = (Parallelogram) shape;
        Point[] points = parallelogram.getPoints();
        return "<polygon id=\"figure-" + index + "\" points=\"" + points[0].getX() + "," + points[0].getY() + " " +
                points[1].getX() + "," + points[1].getY() + " " + points[2].getX() + "," + points[2].getY() + " " +
                points[3].getX() + "," + points[3].getY() + "\" style=\"fill:" + parallelogram.getColor() +
                ";stroke:purple;stroke-width:1\" />";
    }
}
