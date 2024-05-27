package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rhombus;
import by.ryabchikov.lab1.util.strategy.RhombusDrawingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RhombusService {
    private final RhombusDrawingStrategy rhombusDrawingStrategy;
    public String drawRhombus(Rhombus rhombus) {
        MapOfFigures.mapOfFigures.put(MapOfFigures.index++, rhombus);
        return rhombusDrawingStrategy.draw(rhombus);
    }
}
