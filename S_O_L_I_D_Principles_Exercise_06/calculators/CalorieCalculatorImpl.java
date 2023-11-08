package S_O_L_I_D_Principles_Exercise_06.calculators;

import S_O_L_I_D_Principles_Exercise_06.products.Product;

import java.util.List;

public class CalorieCalculatorImpl implements Calculator {
    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getCalories();
        }
        return sum;
    }
    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
