package WorkingWithAbstraction_Lab_01.PointInRectangle_02;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public boolean contains(Point point){
        boolean isContainsX = point.getX() >= getBottomLeft().getX() &&
                point.getX() <= getTopRight().getX();

        boolean isContainsY = point.getY() >= getBottomLeft().getY()
                && point.getY() <= getTopRight().getY();

        return isContainsX && isContainsY;
    }
}
