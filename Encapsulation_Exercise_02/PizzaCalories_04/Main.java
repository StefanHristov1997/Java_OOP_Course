package PizzaCalories_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        Pizza pizza = new Pizza(pizzaData[1],Integer.parseInt(pizzaData[2]));

        String[] doughData = scanner.nextLine().split("\\s+");
        Dough dough = new Dough(doughData[1],doughData[2],Double.parseDouble(doughData[3]));

        pizza.setDought(dough);

        String topping = scanner.nextLine();

        while (!topping.equals("END")){
            String[] toppingData = topping.split("\\s+");
            Topping topping1 = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));
            pizza.addTopping(topping1);
            topping = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(),pizza.getOverallCalories());
    }
}
