package by.ryabchikov.lab1.controller;

import by.ryabchikov.lab1.model.MapOfFigures;
import by.ryabchikov.lab1.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class FigureController {
    private boolean isStarPluginLoaded;
    public static boolean isArchivePluginLoaded;
    private static boolean isFriendPluginLoaded;
    @DeleteMapping("/deleteFigure/{figureIndex}")
    public ResponseEntity<String> deleteFigure(@PathVariable int figureIndex) {
        MapOfFigures.mapOfFigures.remove(figureIndex);
        return ResponseEntity.ok("Figure with index " + figureIndex + " deleted successfully");
    }

    @PostMapping("/figure/{id}/color")
    public ResponseEntity<String> changeFigureColor(@PathVariable int id, @RequestParam String color) {
        MapOfFigures.mapOfFigures.get(id).setColor(color);
        return ResponseEntity.ok().body("Color updated successfully");
    }
    @GetMapping("/shapes")
    public List<String> getShapes() throws IOException {
        ClassScanner scanner = new ClassScanner();
        List<String> classNames = scanner.getClassNames();
        Collections.sort(classNames);
        if (isStarPluginLoaded) {
            List<String> list = JarScanner.getClassNamesFromJarFile(new File("src/main/resources/plugin/updated_star.jar"));
            classNames.addAll(list);
        }
        return classNames;
    }
    @PostMapping("/upload-plugin")
    public String uploadPlugin(@RequestParam("filePath") String filePath) {
        try {
            PluginLoader pluginLoader = new PluginLoader();
            pluginLoader.loadPlugin(filePath);
            isStarPluginLoaded = true;
            return "Плагин успешно загружен";
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка загрузки плагина";
        }
    }

    @PostMapping("/uploadPlugin")
    public String uploadPlugin5() {
        try {
            isArchivePluginLoaded = true;
            return "Плагин успешно загружен";
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка загрузки плагина";
        }
    }

    @PostMapping("/uploadFriendPlugin")
    public String uploadFriendPlugin() {
        try {
            isFriendPluginLoaded = true;
            return "Плагин друга загружен.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка загрузки плагина друга.";
        }
    }
}
