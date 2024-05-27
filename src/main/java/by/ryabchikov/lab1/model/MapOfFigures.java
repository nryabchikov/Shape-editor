package by.ryabchikov.lab1.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@XmlRootElement
public class MapOfFigures {
    public static int index = 0;
    public static Map<Integer, Shape> mapOfFigures = new HashMap<>();
    //public static List<Shape> list = new ArrayList<>();

//    public void addFigures() {
//        list.add(new Circle(new Point(70, 70), 50, new Color(123, 123, 133)));
//        list.add(new Triangle(new Point(120, 120), new Point(150, 250), new Point(200, 150)));
//        list.add(new Parallelogram(new Point(350, 120), 120, 140, 50));
//        list.add(new Rectangle(new Point(300, 300), 100, 200));
//        list.add(new Rhombus(new Point(500, 500), 70, 30));
//        list.add(new Square(new Point(600, 600), 80));
}
