package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.util.PluginLoader;
import by.ryabchikov.lab1.util.data.ThirdIntPointData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class PluginController {

    private final PluginLoader pluginLoader;

    @PostMapping("/buildStar")
    public String buildStar(@RequestBody ThirdIntPointData thirdIntPointData) throws Exception {
        pluginLoader.loadPlugin("updated_star.jar");
        return pluginLoader.invokeControllerMethods(thirdIntPointData, "buildStar");
    }

    @GetMapping("/drawStar")
    public String drawStar() throws Exception {
        return pluginLoader.invokeControllerMethods(null, "drawStar");
    }
}

