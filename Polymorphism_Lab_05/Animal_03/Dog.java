package Polymorphism_Lab_05.Animal_03;

public class Dog extends Animal{
    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "DJAF";
    }
}
