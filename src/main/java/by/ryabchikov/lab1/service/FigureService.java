package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.Drawable;
import by.ryabchikov.lab1.figure.Circle;
import by.ryabchikov.lab1.figure.Line;
import by.ryabchikov.lab1.figure.polygon.Triangle;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Parallelogram;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Rectangle;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Rhombus;
import by.ryabchikov.lab1.figure.polygon.quadrangle.Square;
import by.ryabchikov.lab1.model.ListOfFigures;
import by.ryabchikov.lab1.model.Point;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FigureService {
    public String drawLine() {
        Point startPoint = new Point(50, 50);
        Point endPoint = new Point(200, 200);
        Drawable line = new Line(startPoint, endPoint);
        return line.draw();
    }

    public String drawTriangle() {
        Point firstPoint = new Point(400, 400);
        Point secondPoint = new Point(130, 130);
        Point thirdPoint = new Point(200, 500);
        Drawable triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        return triangle.draw();
    }

    public String drawSquare() {
        Point startPoint = new Point(400, 400);
        Drawable square = new Square(startPoint, 50);
        return square.draw();
    }

    public String drawRectangle() {
        Point startPoint = new Point(400, 400);
        Drawable rectangle = new Rectangle(startPoint, 50, 70);
        return rectangle.draw();
    }

    public String drawCircle() {
        Point centerPoint = new Point(400, 400);
        Drawable circle = new Circle(centerPoint, 50);
        return circle.draw();
    }

    public String drawParallelogram() {
        Point startPoint = new Point(400, 400);
        Drawable parallelogram = new Parallelogram(startPoint, 50, 60, 50);
        return parallelogram.draw();
    }

    public String drawRhombus() {
        Point startPoint = new Point(400, 400);
        Drawable rhombus = new Rhombus(startPoint, 50, 50);
        return rhombus.draw();
    }

    public String draw() {
        ListOfFigures listOfFigures = new ListOfFigures();
        listOfFigures.addFigures();
        StringBuilder svg = new StringBuilder("<svg height=\"700\" width=\"700\">");
        for (Drawable figure: listOfFigures.getList()) {
            svg.append(figure.draw());
        }
        svg.append("</svg>");
        return svg.toString();
    }
}
