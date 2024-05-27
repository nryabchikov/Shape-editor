package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Square;
import by.ryabchikov.lab1.util.strategy.SquareDrawingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SquareService {
    private final SquareDrawingStrategy squareDrawingStrategy;
    public String drawSquare(Square square) {
        MapOfFigures.mapOfFigures.put(MapOfFigures.index++, square);
        return squareDrawingStrategy.draw(square);
    }
}
