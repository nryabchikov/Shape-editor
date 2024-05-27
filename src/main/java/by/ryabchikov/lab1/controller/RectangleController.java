package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rectangle;
import by.ryabchikov.lab1.service.RectangleService;
import by.ryabchikov.lab1.util.data.DoubleIntPointData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RectangleController {
    private Rectangle rectangle;

    private final RectangleService rectangleService;

    @PostMapping("/buildRectangle")
    public String buildRectangle(@RequestBody DoubleIntPointData doubleIntPointData) {
        rectangle = new Rectangle(doubleIntPointData.getPoints()[0], doubleIntPointData.getWidth(),
                doubleIntPointData.getHeight());
        return "/drawRectangle";
    }

    @GetMapping("/drawRectangle")
    public String drawRectangle() {
        if (rectangle != null) {
            return rectangleService.drawRectangle(rectangle);
        }
        return "Click 1 time.";
    }
}
