package Polymorphism_Lab_05.Shape_02;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.setArea(calculateArea());
        this.setPerimeter(calculatePerimeter());
    }

    public final Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
