package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.figure.Circle;
import by.ryabchikov.lab1.service.CircleService;
import by.ryabchikov.lab1.util.data.IntPointData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CircleController {
    private Circle circle;

    private final CircleService circleService;

    @PostMapping("/buildCircle")
    public String buildCircle(@RequestBody IntPointData intPointData) {
        circle = new Circle(intPointData.getPoints()[0], intPointData.getSide());
        return "/drawCircle";
    }

    @GetMapping("/drawCircle")
    public String drawCircle() {
        if (circle != null) {
            return circleService.drawCircle(circle);
        }
        return "Click 1 time";
    }
}
