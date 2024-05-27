package by.ryabchikov.lab1.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Component
public class ClassScanner {
    private final String packageName = "by.ryabchikov.lab1.model.figure";

    public List<String> getClassNames() throws IOException {
        List<String> classNames = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            classNames.addAll(findClasses(resource.getPath(), packageName));
        }
        return classNames;
    }

    private List<String> findClasses(String path, String packageName) {
        List<String> classNames = new ArrayList<>();
        File directory = new File(path);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        classNames.addAll(findClasses(file.getAbsolutePath(), packageName + "." + file.getName()));
                    } else if (file.getName().endsWith(".class")) {
                        String className = file.getName().replace(".class", "");
                        if (!isAbstractClass(className)) {
                            classNames.add(className);
                        }
                    }
                }
            }
        }
        return classNames;
    }

    public boolean isAbstractClass(String className) {
        if (className.endsWith("Abstract")) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) throws IOException {
        ClassScanner scanner = new ClassScanner();
        List<String> classNames = scanner.getClassNames();
        Collections.sort(classNames);
        for (String className : classNames) {
            System.out.println(className);
        }
    }
}
