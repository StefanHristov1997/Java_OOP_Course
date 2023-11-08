package S_O_L_I_D_Principles_Exercise_06.products.Drink;

public abstract class BaseDrink implements Drink {

    private final double milliliters;
    private final double caloriesPer100Grams;
    private final double density;

    public BaseDrink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }

    public double getDensity(){
        return this.density;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * (milliliters * density);
    }

    @Override
    public double getLitters() {
        return milliliters / 1000;
    }
}
