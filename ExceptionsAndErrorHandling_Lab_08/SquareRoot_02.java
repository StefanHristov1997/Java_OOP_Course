package ExceptionsAndErrorHandling_Lab_08;

import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try{
            int numberOfInput = Integer.parseInt(input);
            if(numberOfInput > 0) {
                System.out.printf("%.2f\n", Math.sqrt(numberOfInput));
            }else{
                System.out.println("Invalid");
            }
        }catch (IllegalArgumentException exception){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }


    }
}
