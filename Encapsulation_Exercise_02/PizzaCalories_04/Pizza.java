package PizzaCalories_04;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dought;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setToppings(int toppings) {
        if(toppings < 0 || toppings > 10){
            throw  new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
    public void setDought(Dough dought) {
        this.dought = dought;
    }

    public void addTopping (Topping topping){
        toppings.add(topping);
    }

    public double getOverallCalories (){
        double caloriesFromTopping = 0;
        for (Topping topping : toppings) {
            caloriesFromTopping += topping.calculateCalories();
        }
        return caloriesFromTopping + this.dought.calculateCalories();
    }

    public String getName() {
        return name;
    }

}
