package S_O_L_I_D_Principles_Exercise_06.calculators;

import S_O_L_I_D_Principles_Exercise_06.products.Drink.Drink;
import S_O_L_I_D_Principles_Exercise_06.products.Food.Food;
import S_O_L_I_D_Principles_Exercise_06.products.Product;

import java.util.List;

public class QuantityCalculatorImpl implements Calculator {
    @Override
    public double sum(List<Product> products) {
        double sum = 0;

            for (Product product : products) {
                if (product instanceof Food) {
                    sum += ((Food) product).getKilograms();
                }else if (product instanceof Drink){
                    sum += ((Drink) product).getLitters() * ((Drink) product).getDensity();
                }
            }

            return sum;
        }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
