package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.figure.Circle;
import by.ryabchikov.lab1.util.FigureDrawer;
import by.ryabchikov.lab1.util.factory.DrawingStrategyFactory;
import by.ryabchikov.lab1.util.strategy.CircleDrawingStrategy;
import by.ryabchikov.lab1.util.strategy.DrawingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CircleService {
    private final CircleDrawingStrategy circleDrawingStrategy;
    public String drawCircle(Circle circle) {
        MapOfFigures.mapOfFigures.put(MapOfFigures.index++, circle);
        return circleDrawingStrategy.draw(circle);
    }
}
