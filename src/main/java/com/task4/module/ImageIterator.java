package com.task4.module;

import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;

public class ImageIterator implements Iterator {
    private int current = 0;
    private String folderPath;

    public ImageIterator(String folderPath) {
        this.folderPath = folderPath;
    }

    private Image getImage(int index) {
        try {
            String filename = Paths.get(folderPath, index + ".png").toUri().toString();
            return new Image(filename);
        } catch (Exception e) {
            current = 1;
            return getImage(1); // Возвращаем первое изображение в случае ошибки
        }
    }

    @Override
    public boolean hasNext(int i) {
        return getImage(current + i) != null;
    }

    @Override
    public Object next() {
        current++;
        return getImage(current);
    }

    @Override
    public Object preview() {
        if (current > 1) {
            current--;
        }
        return getImage(current);
    }
}
