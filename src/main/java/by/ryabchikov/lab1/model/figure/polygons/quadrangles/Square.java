package by.ryabchikov.lab1.model.figure.polygons.quadrangles;

import by.ryabchikov.lab1.model.Point;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Square extends Rectangle {
    public Square(Point startPoint, int side) {
        super(startPoint, side, side);
    }
}
