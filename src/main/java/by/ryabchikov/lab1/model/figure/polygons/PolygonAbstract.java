package by.ryabchikov.lab1.model.figure.polygons;

import by.ryabchikov.lab1.model.Shape;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PolygonAbstract extends Shape {
    protected int numOfSides;
}
