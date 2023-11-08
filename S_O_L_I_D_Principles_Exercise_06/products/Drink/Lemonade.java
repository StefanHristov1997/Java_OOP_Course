package S_O_L_I_D_Principles_Exercise_06.products.Drink;

public class Lemonade extends BaseDrink {
    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }

}
