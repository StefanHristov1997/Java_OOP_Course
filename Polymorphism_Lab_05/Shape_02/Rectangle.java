package Polymorphism_Lab_05.Shape_02;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        setPerimeter(calculatePerimeter());
        setArea(calculateArea());
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return this.height * 2 + this.width * 2;
    }

    @Override
    public Double calculateArea() {
        return width * height;
    }
}
