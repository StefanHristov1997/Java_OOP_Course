package WorkingAbstraction_Exercise_01.JediGalaxy_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner.nextLine());
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] starSpace = new int[rows][columns];

        fillTheSpace(rows, columns, starSpace);

        String command = scanner.nextLine();

        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] ivoCoordinates = readArray(command);
            int[] evilCoordinates = readArray(scanner.nextLine());
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            starsLeftAfterEvil(evilRow, evilCol, starSpace);

            int ivoRow = ivoCoordinates[0];
            int ivoCol = ivoCoordinates[1];

            sum = collectedStars(ivoRow, ivoCol, starSpace);

            command = scanner.nextLine();
        }

        printResult(sum);


    }

    private static int[] readArray(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void fillTheSpace(int rows, int columns, int[][] starSpace) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                starSpace[row][col] = value++;
            }
        }
    }

    private static boolean checkIndex(int row, int[][] starSpace, int column) {
        return row >= 0 && row < starSpace.length && column >= 0 && column < starSpace[0].length;

    }

    private static void printResult(long sum) {
        System.out.println(sum);
    }

    private static void starsLeftAfterEvil(int evilRow, int evilCol, int[][] starSpace) {
        while (evilRow >= 0 && evilCol >= 0) {
            if(checkIndex(evilRow, starSpace, evilCol)){
                starSpace[evilRow] [evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long collectedStars(int ivoRow, int ivoCol, int[][] starSpace) {
        long sum = 0;
        while (ivoRow >= 0 && ivoCol < starSpace[1].length) {
            if (checkIndex(ivoRow, starSpace, ivoCol)) {
                sum += starSpace[ivoRow][ivoCol];
            }

            ivoCol++;
            ivoRow--;
        }
        return sum;
    }
}
