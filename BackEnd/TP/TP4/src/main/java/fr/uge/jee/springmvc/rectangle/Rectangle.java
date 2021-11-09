package fr.uge.jee.springmvc.rectangle;

public class Rectangle {
    private int height;
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
