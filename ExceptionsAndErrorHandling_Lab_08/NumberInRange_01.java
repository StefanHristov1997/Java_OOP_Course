package ExceptionsAndErrorHandling_Lab_08;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int minimalNumber = range[0];
        int maximumNumber = range[1];

        System.out.printf("Range: [%d...%d]\n", minimalNumber, maximumNumber);
        int result = checkNumber(minimalNumber,maximumNumber,scanner);


        System.out.println("Valid number: " + result);
    }

    public static int checkNumber(int startRange, int endRange, Scanner scanner) {
        while (true){
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if(number >= startRange && number <= endRange){
                    return number;
                }
            } catch (IllegalArgumentException exception){

            }
            System.out.println("Invalid number: " + input);
        }

    }

}
