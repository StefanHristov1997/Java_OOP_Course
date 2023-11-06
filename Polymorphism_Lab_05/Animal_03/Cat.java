package Polymorphism_Lab_05.Animal_03;

import Polymorphism_Lab_05.Animal_03.Animal;

public class Cat extends Animal {
    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "MEEOW";
    }
}
