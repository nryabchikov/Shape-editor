package by.ryabchikov.lab1.model.figure.polygons;

import by.ryabchikov.lab1.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle extends PolygonAbstract {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
}
