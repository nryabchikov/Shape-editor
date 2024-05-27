package by.ryabchikov.lab1.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Component
public class JarScanner {

    public static List<String> getClassNamesFromJarFile(File jarFile) throws IOException {
        List<String> classNames = new ArrayList<>();
        try (JarFile file = new JarFile(jarFile)) {
            for (JarEntry entry : Collections.list(file.entries())) {
                if (!entry.isDirectory() && entry.getName().endsWith(".class") && entry.getName().contains("/model/figure")) {
                    String className = entry.getName().replace('/', '.');
                    className = className.substring(0, className.length() - ".class".length());
                    classNames.add(getClassName(className));
                }
            }
        }
        return classNames;
    }

    private static String getClassName(String className) {
        int lastDotIndex = className.lastIndexOf('.');
        return (lastDotIndex != -1) ? className.substring(lastDotIndex + 1) : className;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getClassNamesFromJarFile(new File("src/main/resources/plugin/updated_star.jar"));
        for (String elem: list) {
            System.out.println(elem);
        }

    }
}

