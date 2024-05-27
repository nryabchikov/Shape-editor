package by.ryabchikov.lab1.util.strategy;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rectangle;
import org.springframework.stereotype.Component;

@Component
public class RectangleDrawingStrategy implements DrawingStrategy {

    @Override
    public String draw(Shape shape) {
        Rectangle rectangle = (Rectangle) shape;
        return "<svg height=\"700\" width=\"700\">" +
                "<rect x=\"" + rectangle.getStartPoint().getX() + "\" y=\"" + rectangle.getStartPoint().getY() +
                "\" width=\"" + rectangle.getWidth() + "\" height=\"" + rectangle.getHeight() +
                "\" style=\"fill:" + rectangle.getColor() + ";stroke:purple;stroke-width:1\" />" + "</svg>";
    }

    @Override
    public String drawWithoutSVG(Shape shape, int index) {
        Rectangle rectangle = (Rectangle) shape;
        return "<rect id=\"figure-" + index + "\" x=\"" + rectangle.getStartPoint().getX() + "\" y=\"" +
                rectangle.getStartPoint().getY() +
                "\" width=\"" + rectangle.getWidth() + "\" height=\"" + rectangle.getHeight() +
                "\" style=\"fill:" + rectangle.getColor() + ";stroke:purple;stroke-width:1\" />";
    }
}
