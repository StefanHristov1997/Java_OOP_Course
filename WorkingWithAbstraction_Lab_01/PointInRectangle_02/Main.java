package WorkingWithAbstraction_Lab_01.PointInRectangle_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coordinates  = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];

        Point rectangleBottomPoint = new Point(bottomLeftX,bottomLeftY);

        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point rectangleTopPoint = new Point(topRightX,topRightY);
        Rectangle rectangle = new Rectangle(rectangleBottomPoint,rectangleTopPoint);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int[] checkPoint = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point pointForCheck = new Point(checkPoint[0],checkPoint[1]);
            System.out.println(rectangle.contains(pointForCheck));
        }
    }
}
