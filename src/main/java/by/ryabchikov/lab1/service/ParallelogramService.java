package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Parallelogram;
import by.ryabchikov.lab1.util.strategy.ParallelogramDrawingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParallelogramService {
    private final ParallelogramDrawingStrategy parallelogramDrawingStrategy;
    public String drawParallelogram(Parallelogram parallelogram) {
        MapOfFigures.mapOfFigures.put(MapOfFigures.index++, parallelogram);
        return parallelogramDrawingStrategy.draw(parallelogram);
    }
}
