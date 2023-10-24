package WorkingWithAbstraction_Lab_01.HotelReservation_04;

public enum DiscountType {
    None(0),
    SecondVisit(10),
    VIP(20);

    private double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
