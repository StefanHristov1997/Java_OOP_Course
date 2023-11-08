package S_O_L_I_D_Principles_Exercise_06.printer;

import S_O_L_I_D_Principles_Exercise_06.calculators.Calculator;
import S_O_L_I_D_Principles_Exercise_06.products.Product;

import java.util.List;

public class PrinterCalories {
    private Calculator calculator;
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
