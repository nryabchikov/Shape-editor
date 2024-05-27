package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.Point;
import by.ryabchikov.lab1.model.figure.polygons.Triangle;
import by.ryabchikov.lab1.service.TriangleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TriangleController {
    private Triangle triangle;

    private final TriangleService triangleService;

    @PostMapping("/buildTriangle")
    public String buildTriangle(@RequestBody Point[] points) {
        triangle = new Triangle(points[0], points[1], points[2]);
        return "/drawTriangle";
    }

    @GetMapping("/drawTriangle")
    public String drawTriangle() {
        if (triangle != null) {
            return triangleService.drawTriangle(triangle);
        }
        return "Click 3 times.";
    }
}
