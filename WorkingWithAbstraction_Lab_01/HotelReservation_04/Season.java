package WorkingWithAbstraction_Lab_01.HotelReservation_04;

public enum Season {
    Autumn(1),
    Spring(2),
    Summer(4),
    Winter(3);
    private int multiplier ;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
