package by.ryabchikov.lab1.figure;

import by.ryabchikov.lab1.Drawable;
import by.ryabchikov.lab1.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Line implements Drawable {
    private Point startPoint;
    private Point endPoint;

    @Override
    public String draw() {
        return "<svg height=\"700\" width=\"700\">" +
                "<line x1=\"" + startPoint.getX() + "\" y1=\"" + startPoint.getY() + "\" x2=\"" + endPoint.getX() +
                "\" y2=\"" + endPoint.getY() + "\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />" +
                "</svg>";
    }
}
