package by.ryabchikov.lab1.service;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.util.FigureDrawer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FigureService {
    private final FigureDrawer figureDrawer;

    public String drawAll() {
        return figureDrawer.drawAll(MapOfFigures.mapOfFigures);
    }
}
