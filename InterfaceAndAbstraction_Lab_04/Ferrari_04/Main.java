package InterfaceAndAbstraction_Lab_04.Ferrari_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String driverName = scanner.nextLine();

        Ferrari ferrari = new Ferrari(driverName);

        System.out.println(ferrari);
    }
}
