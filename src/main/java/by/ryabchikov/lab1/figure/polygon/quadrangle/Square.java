package by.ryabchikov.lab1.figure.polygon.quadrangle;

import by.ryabchikov.lab1.model.Point;

public class Square extends Rectangle {
    public Square(Point startPoint, int side) {
        super(startPoint, side, side);
    }

    @Override
    public String draw() {
        return "<svg height=\"700\" width=\"700\">" +
                "<rect x=\"" + startPoint.getX() + "\" y=\"" + startPoint.getY() + "\" width=\"" + width +
                "\" height=\"" + height + "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />" + "</svg>";
    }
}
