package by.ryabchikov.lab1.model.figure;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineNotAbstract extends Shape {
    private Point startPoint;
    private Point endPoint;
}
