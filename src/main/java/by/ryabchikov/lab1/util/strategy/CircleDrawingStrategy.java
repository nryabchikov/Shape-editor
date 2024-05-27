package by.ryabchikov.lab1.util.strategy;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.figure.Circle;
import org.springframework.stereotype.Component;

@Component
public class CircleDrawingStrategy implements DrawingStrategy {
    @Override
    public String draw(Shape shape) {
        Circle circle= (Circle) shape;
        return "<svg height=\"700\" width=\"700\">" +
                "<circle cx=\"" + circle.getCenterPoint().getX() + "\" cy=\"" + circle.getCenterPoint().getY() +
                "\" r=\"" + circle.getRadius() +
                "\" style=\"fill:" + circle.getColor() + ";stroke:purple;stroke-width:1\" />" + "</svg>";
    }
    @Override
    public String drawWithoutSVG(Shape shape, int index) {
        Circle circle = (Circle) shape;
        return "<circle id=\"figure-" + index + "\" cx=\"" + circle.getCenterPoint().getX() + "\" cy=\"" +
                circle.getCenterPoint().getY() + "\" r=\"" + circle.getRadius() +
                "\" style=\"fill:" + circle.getColor() + ";stroke:purple;stroke-width:1\" />";
    }
}
