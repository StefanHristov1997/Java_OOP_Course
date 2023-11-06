package Polymorphism_Lab_05.Animal_03;

import Polymorphism_Lab_05.Animal_03.Animal;
import Polymorphism_Lab_05.Animal_03.Cat;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Animal.Dog("Rocky", "Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
