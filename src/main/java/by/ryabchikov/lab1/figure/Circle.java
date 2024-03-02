package by.ryabchikov.lab1.figure;

import by.ryabchikov.lab1.Drawable;
import by.ryabchikov.lab1.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle implements Drawable {
    private Point centerPoint;
    private int radius;

    @Override
    public String draw() {
        return "<svg height=\"700\" width=\"700\">" +
                "<circle cx=\"" + centerPoint.getX() + "\" cy=\"" + centerPoint.getY() + "\" r=\"" + radius +
                "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />" + "</svg>";
    }
}
