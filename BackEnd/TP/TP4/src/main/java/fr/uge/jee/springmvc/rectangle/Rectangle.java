package fr.uge.jee.springmvc.rectangle;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Rectangle {
    @NotNull
    @Min(0)
    private int height;
    @NotNull
    @Min(0)
    private int width;

    public int area() {
        return height * width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
