package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.figure.polygons.quadrangles.Parallelogram;
import by.ryabchikov.lab1.service.ParallelogramService;
import by.ryabchikov.lab1.util.data.ThirdIntPointData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParallelogramController {
    private Parallelogram parallelogram;

    private final ParallelogramService parallelogramService;

    @PostMapping("/buildParallelogram")
    public String buildParallelogram(@RequestBody ThirdIntPointData thirdIntPointData) {
        parallelogram = new Parallelogram(thirdIntPointData.getPoints()[0], thirdIntPointData.getWidth(),
                thirdIntPointData.getHeight(), thirdIntPointData.getAngle());
        return "/drawParallelogram";
    }

    @GetMapping("/drawParallelogram")
    public String drawParallelogram() {
        if (parallelogram != null) {
            return parallelogramService.drawParallelogram(parallelogram);
        }
        return "Click 1 time.";
    }
}
