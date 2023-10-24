package WorkingWithAbstraction_Lab_01;

import java.util.Scanner;

public class RhombusOfStars_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sizeOfRhombus = Integer.parseInt(scanner.nextLine());


        printTopHalf(sizeOfRhombus);
        printBottomHalf(sizeOfRhombus);


    }
    private static void printBottomHalf(int sizeOfRhombus) {
        for (int starCount = sizeOfRhombus - 1; starCount > 0 ; starCount--) {
            printStarRow(sizeOfRhombus, starCount);
        }
    }

    private static void printTopHalf(int sizeOfRhombus) {
        for (int starCount = 1; starCount <= sizeOfRhombus; starCount++) {
            printStarRow(sizeOfRhombus, starCount);
        }
    }

    private static void printStarRow(int sizeOfRhombus, int starCount) {
        for (int i = 0; i < sizeOfRhombus - starCount; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < starCount - 1; i++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }
}
