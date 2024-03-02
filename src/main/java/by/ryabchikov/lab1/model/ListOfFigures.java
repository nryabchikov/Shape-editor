package by.ryabchikov.lab1.model;

import by.ryabchikov.lab1.Drawable;
import by.ryabchikov.lab1.figure.Circle;
import by.ryabchikov.lab1.figure.polygon.Triangle;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Parallelogram;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Rectangle;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Rhombus;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Square;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class ListOfFigures {
    List<Drawable> list = new ArrayList<>();

    public void addFigures() {
        list.add(new Circle(new Point(70, 70), 50));
        list.add(new Triangle(new Point(120, 120), new Point(150, 250), new Point(200, 150)));
        list.add(new Parallelogram(new Point(350, 120), 120, 140, 50));
        list.add(new Rectangle(new Point(300, 300), 100, 200));
        list.add(new Rhombus(new Point(500, 500), 70, 30));
        list.add(new Square(new Point(600, 600), 80));
    }
}
