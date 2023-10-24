package WorkingWithAbstraction_Lab_01.HotelReservation_04;

public class PriceCalculator {
    public double priceCalculator(double pricePerDay, int numberOFDays, Season season, DiscountType discount){
        double price = pricePerDay * numberOFDays;
        price *= season.getMultiplier();
        price *= (100 - discount.getDiscount()) / 100;
        return price;
    }
}
