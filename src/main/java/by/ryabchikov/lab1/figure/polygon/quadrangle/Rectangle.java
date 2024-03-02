package by.ryabchikov.lab1.figure.polygon.quadrangle;

import by.ryabchikov.lab1.model.Point;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Rectangle extends Quadrangle {

    public Rectangle(Point startPoint, int width, int height) {
        super(startPoint, width, height);
    }

    @Override
    public String draw() {
        return "<svg height=\"700\" width=\"700\">" +
                "<rect x=\"" + startPoint.getX() + "\" y=\"" + startPoint.getY() + "\" width=\"" + width +
                "\" height=\"" + height + "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />" + "</svg>";
    }
}
