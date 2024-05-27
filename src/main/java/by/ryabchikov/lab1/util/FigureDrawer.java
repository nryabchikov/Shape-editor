package by.ryabchikov.lab1.util;

import by.ryabchikov.lab1.model.Shape;
import by.ryabchikov.lab1.util.factory.DrawingStrategyFactory;
import by.ryabchikov.lab1.util.strategy.DrawingStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class FigureDrawer {
    public String drawAll(Map<Integer, Shape> figures) {
        StringBuilder svgBuilder = new StringBuilder();
        svgBuilder.append("<svg height=\"700\" width=\"700\">");
        for (Map.Entry<Integer, Shape> entry : figures.entrySet()) {
            Integer key = entry.getKey();
            Shape shape = entry.getValue();
            DrawingStrategyFactory factory = DrawingStrategyFactory.getDrawingStrategyFactory(shape);
            DrawingStrategy strategy = factory.createDrawingStrategy();
            svgBuilder.append(strategy.drawWithoutSVG(shape, key));
        }
        svgBuilder.append("</svg>");
        return svgBuilder.toString();
    }
}