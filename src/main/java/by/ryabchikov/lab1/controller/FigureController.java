package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.Drawable;
import by.ryabchikov.lab1.figure.Line;
import by.ryabchikov.lab1.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import by.ryabchikov.lab1.service.FigureService;

@RestController
public class FigureController {

    private final FigureService figureService;

    @Autowired
    public FigureController(FigureService figureService) {
        this.figureService = figureService;
    }

    @GetMapping("/drawLine")
    public String drawLine() {
        Point startPoint = new Point(50, 50);
        Point endPoint = new Point(200, 200);
        Drawable line = new Line(startPoint, endPoint);
        return line.draw();
    }

    @GetMapping("/drawTriangle")
    public String drawTriangle() {
        return figureService.drawTriangle();
    }

    @GetMapping("/drawSquare")
    public String drawSquare() {
        return figureService.drawSquare();
    }

    @GetMapping("/drawRectangle")
    public String drawRectangle() {
        return figureService.drawRectangle();
    }

    @GetMapping("/drawCircle")
    public String drawCircle() {
        return figureService.drawCircle();
    }

    @GetMapping("/drawParallelogram")
    public String drawParallelogram() {
        return figureService.drawParallelogram();
    }

    @GetMapping("/drawRhombus")
    public String drawRhombus() {
        return figureService.drawRhombus();
    }

    @GetMapping("/draw")
    public String draw() {
        return figureService.draw();
    }
}
