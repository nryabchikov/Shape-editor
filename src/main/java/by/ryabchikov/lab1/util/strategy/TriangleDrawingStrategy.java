package by.ryabchikov.lab1.util.strategy;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.figure.polygons.Triangle;
import org.springframework.stereotype.Component;

@Component
public class TriangleDrawingStrategy implements DrawingStrategy {

    @Override
    public String draw(Shape shape) {
        Triangle triangle = (Triangle) shape;
        return "<svg height=\"700\" width=\"700\">" +
                "<polygon points=\"" + triangle.getFirstPoint().getX() + "," + triangle.getFirstPoint().getY() + " " +
                triangle.getSecondPoint().getX() + "," + triangle.getSecondPoint().getY() + " " +
                triangle.getThirdPoint().getX() + "," + triangle.getThirdPoint().getY() +
                "\" style=\"fill:" + triangle.getColor() + ";stroke:purple;stroke-width:1\" />" + "</svg>";
    }
    @Override
    public String drawWithoutSVG(Shape shape, int index) {
        Triangle triangle = (Triangle) shape;
        return "<polygon id=\"figure-" + index + "\" points=\"" + triangle.getFirstPoint().getX() + "," +
                triangle.getFirstPoint().getY() + " " + triangle.getSecondPoint().getX() + "," +
                triangle.getSecondPoint().getY() + " " + triangle.getThirdPoint().getX() + "," +
                triangle.getThirdPoint().getY() +
                "\" style=\"fill:" + triangle.getColor() + ";stroke:purple;stroke-width:1\" />";
    }
}
