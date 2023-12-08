package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(foods);
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() == capacity) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Animals: ");
        if (animals.isEmpty()) {
            sb.append("none");
            sb.append(System.lineSeparator());
        } else {
            int index = 0;
            for (Animal animal : animals) {
                if(index < animals.size() - 1){
                    sb.append(animal.getName()).append(" ");
                    index++;
                }else {
                    sb.append(animal.getName());
                }
            }
            sb.append(System.lineSeparator());
        }

        sb.append(String.format("Foods: %d", foods.size())).append(System.lineSeparator());
        sb.append(String.format("Calories: %d", sumCalories()));


        return sb.toString();
    }
}
