package S_O_L_I_D_Principles_Exercise_06.products.Drink;

public class Coke extends BaseDrink {
    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }

}
