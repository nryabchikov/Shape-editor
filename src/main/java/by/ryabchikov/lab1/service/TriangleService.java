package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.figure.polygons.Triangle;
import by.ryabchikov.lab1.util.strategy.TriangleDrawingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TriangleService {
    private final TriangleDrawingStrategy triangleDrawingStrategy;
    public String drawTriangle(Triangle triangle) {
        MapOfFigures.mapOfFigures.put(MapOfFigures.index++, triangle);
        return triangleDrawingStrategy.draw(triangle);
    }
}
