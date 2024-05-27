package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Square;
import by.ryabchikov.lab1.service.SquareService;
import by.ryabchikov.lab1.util.data.IntPointData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SquareController {
    private Square square;

    private final SquareService squareService;

    @PostMapping("/buildSquare")
    public String buildSquare(@RequestBody IntPointData intPointData) {
        square = new Square(intPointData.getPoints()[0], intPointData.getSide());
        return "/drawSquare";
    }

    @GetMapping("/drawSquare")
    public String drawSquare() {
        if (square != null) {
            return squareService.drawSquare(square);
        }
        return "Click 1 time.";
    }
}
