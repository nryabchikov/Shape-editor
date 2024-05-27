package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Rhombus;
import by.ryabchikov.lab1.service.RhombusService;
import by.ryabchikov.lab1.util.data.DoubleIntPointData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RhombusController {
    private Rhombus rhombus;

    private final RhombusService rhombusService;

    @PostMapping("/buildRhombus")
    public String buildRhombus(@RequestBody DoubleIntPointData doubleIntPointData) {
        rhombus = new Rhombus(doubleIntPointData.getPoints()[0], doubleIntPointData.getWidth(),
                doubleIntPointData.getHeight());
        return "/drawRhombus";
    }

    @GetMapping("/drawRhombus")
    public String drawRhombus() {
        if (rhombus != null) {
            return rhombusService.drawRhombus(rhombus);
        }
        return "Click 1 time.";
    }
}
