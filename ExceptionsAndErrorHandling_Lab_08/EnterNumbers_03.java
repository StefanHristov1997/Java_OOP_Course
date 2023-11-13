package ExceptionsAndErrorHandling_Lab_08;

import java.util.*;

public class EnterNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] result = readNumber(1, 100, scanner);
        System.out.println(Arrays.toString(result).replaceAll("[\\[\\]]", ""));

    }

    public static int[] readNumber(int start, int end, Scanner scanner){
        int validNumber = 0;

        int[] validNumbers = new int[10];
        int previousNumber = 1;

        while (validNumber < 10){
            String input = scanner.nextLine();
            try {
                int currentNumber = Integer.parseInt(input);
                if(currentNumber > start && currentNumber < end) {
                    if(currentNumber > previousNumber){
                        validNumbers[validNumber] = currentNumber;
                        validNumber++;
                        previousNumber = currentNumber;
                    }
                }else{
                    System.out.printf("Your number is not in range %d - 100!\n", previousNumber);
                }
            }catch (IllegalArgumentException exception){
                System.out.println("Invalid Number!");
            }
        }

        return validNumbers;
    }
}
