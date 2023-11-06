package Polymorphism_Lab_05.Animal_03;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String explainSelf(){
        return String.format("I am %s and my favourite food is %s", getName(), getFavouriteFood());
    }

    public static class Dog extends Animal {
        protected Dog(String name, String favouriteFood) {
            super(name, favouriteFood);
        }
        @Override
        public String explainSelf() {
            return super.explainSelf() + System.lineSeparator() + "DJAAF";
        }
    }
}
