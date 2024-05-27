package by.ryabchikov.lab1.model.figure;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape {
    private Point centerPoint;
    private int radius;
}
