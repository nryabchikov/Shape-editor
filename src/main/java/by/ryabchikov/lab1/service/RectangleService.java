package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rectangle;
import by.ryabchikov.lab1.util.strategy.RectangleDrawingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RectangleService {
    private final RectangleDrawingStrategy rectangleDrawingStrategy;
    public String drawRectangle(Rectangle rectangle) {
        MapOfFigures.mapOfFigures.put(MapOfFigures.index++, rectangle);
        return rectangleDrawingStrategy.draw(rectangle);
    }
}
