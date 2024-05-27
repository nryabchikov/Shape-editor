package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.service.FigureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class DrawAllFiguresController {

    private FigureService figureService;

    @GetMapping("/draw")
    public String drawAllFigures(Model model) {
        String svgString = figureService.drawAll();
        model.addAttribute("svgString", svgString);
        return "drawFigures";
    }
}
