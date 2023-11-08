package S_O_L_I_D_Principles_Exercise_06.products.Food;

public abstract class BaseFood implements Food {

    private final double grams;

    private final double caloriesPer100Grams;

    public BaseFood(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * grams;
    }

    @Override
    public double getKilograms() {
        return grams / 1000;
    }
}
