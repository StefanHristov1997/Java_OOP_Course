package S_O_L_I_D_Principles_Exercise_06.products.Food;

public class Chips extends BaseFood {

    public static final double CALORIES_PER_100_GRAMS = 529.0;
    public Chips(double grams) {
        super(grams, CALORIES_PER_100_GRAMS);
    }
}
