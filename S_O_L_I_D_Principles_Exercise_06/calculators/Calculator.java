package S_O_L_I_D_Principles_Exercise_06.calculators;

import S_O_L_I_D_Principles_Exercise_06.products.Product;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);
    double average(List<Product> products);

}
