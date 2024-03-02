package by.ryabchikov.lab1.figure.polygon;

import by.ryabchikov.lab1.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle extends Polygon {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    @Override
    public String draw() {
        return "<svg height=\"700\" width=\"700\">" +
                "<polygon points=\"" + firstPoint.getX() + "," + firstPoint.getY() + " " + secondPoint.getX() + "," +
                secondPoint.getY() + " " + thirdPoint.getX() + "," + thirdPoint.getY() +
                "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />" + "</svg>";
    }

}
