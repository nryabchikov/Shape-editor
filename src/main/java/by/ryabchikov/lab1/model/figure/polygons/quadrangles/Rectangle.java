package by.ryabchikov.lab1.model.figure.polygons.quadrangles;

import by.ryabchikov.lab1.model.Point;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Rectangle extends QuadrangleAbstract {

    public Rectangle(Point startPoint, int width, int height) {
        super(startPoint, width, height);
    }
}
