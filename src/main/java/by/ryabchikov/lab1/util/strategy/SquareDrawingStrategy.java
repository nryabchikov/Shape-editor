package by.ryabchikov.lab1.util.strategy;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Square;
import org.springframework.stereotype.Component;

@Component
public class SquareDrawingStrategy implements DrawingStrategy {

    @Override
    public String draw(Shape shape) {
        Square square = (Square) shape;
        return "<svg height=\"700\" width=\"700\">" +
                "<rect x=\"" + square.getStartPoint().getX() + "\" y=\"" + square.getStartPoint().getY() +
                "\" width=\"" + square.getWidth() + "\" height=\"" + square.getHeight() +
                "\" style=\"fill:" + square.getColor() + ";stroke:purple;stroke-width:1\" />" + "</svg>";
    }

    @Override
    public String drawWithoutSVG(Shape shape, int index) {
        Square square = (Square) shape;
        return "<rect id=\"figure-" + index + "\" x=\"" + square.getStartPoint().getX() + "\" y=\"" +
                square.getStartPoint().getY() + "\" width=\"" + square.getWidth() + "\" height=\"" + square.getHeight() +
                "\" style=\"fill:" + square.getColor() + ";stroke:purple;stroke-width:1\" />";
    }
}
