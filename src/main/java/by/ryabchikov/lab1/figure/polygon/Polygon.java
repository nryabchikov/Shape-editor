package by.ryabchikov.lab1.figure.polygon;

import by.ryabchikov.lab1.Drawable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Polygon implements Drawable {
    protected int numOfSides;
}
