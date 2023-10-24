package WorkingWithAbstraction_Lab_01.HotelReservation_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] information = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(information[0]);
        int numberOfDays = Integer.parseInt(information[1]);
        Season season = Season.valueOf(information[2]);
        DiscountType discount = DiscountType.valueOf(information[3]);

        PriceCalculator priceCalculator = new PriceCalculator();

        double price = priceCalculator.priceCalculator(pricePerDay,numberOfDays,season,discount);

        System.out.printf("%.2f", price);
    }
}
