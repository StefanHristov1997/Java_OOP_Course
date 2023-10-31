package PizzaCalories_04;

public class Topping {
//-	toppingType: String
//-	weight: double
//+ 	Topping (String, double)
//-	setToppingType (String): void
//-	setWeight (double): void
//+	calculateCalories (): double

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                this.toppingType = toppingType;
                break;
            case "Veggies":
                this.toppingType = toppingType;
                break;
            case "Cheese":
                this.toppingType = toppingType;
                break;
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                String message = String.format("Cannot place %s on top of your pizza.", toppingType);
                throw new IllegalArgumentException(message);
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            String message = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double caloriesOfTopping = 0;
        switch (toppingType) {
            case "Meat":
                caloriesOfTopping = (2 * this.weight) * 1.2;
                break;
            case "Veggies":
                caloriesOfTopping = (2 * this.weight) * 0.8;
                break;
            case "Cheese":
                caloriesOfTopping = (2 * this.weight) * 1.1;
                break;
            case "Sauce":
                caloriesOfTopping = (2 * this.weight) * 0.9;
                break;
        }
        return caloriesOfTopping;
    }
}