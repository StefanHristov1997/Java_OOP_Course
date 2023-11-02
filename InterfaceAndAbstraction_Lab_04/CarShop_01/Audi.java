package InterfaceAndAbstraction_Lab_04.CarShop_01;

public class Audi extends CarImpl implements Rentable {

    private Integer MinRentDay;
    private Double PricePerDay;
    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer MinRentDay, Double PricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.MinRentDay = MinRentDay;
        this.PricePerDay = PricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.MinRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.PricePerDay;
    }

    @Override
    public String toString() {
        return String.format("Minimum rental period of %d days. Price per day %f", this.MinRentDay, this.PricePerDay);
    }
}
