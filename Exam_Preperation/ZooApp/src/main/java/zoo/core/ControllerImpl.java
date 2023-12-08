package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        areas.add(area);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        Area givenArea = areas.stream().filter(area -> area.getName().equals(areaName)).findFirst().get();
        givenArea.addFood(food);
        foodRepository.remove(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        Area area = areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().get();

        if (animal.getClass().getSimpleName().equals("TerrestrialAnimal") && area.getClass().getSimpleName().equals("LandArea")) {
            area.addAnimal(animal);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else if (animal.getClass().getSimpleName().equals("AquaticAnimal") && area.getClass().getSimpleName().equals("WaterArea")) {
            area.addAnimal(animal);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else {
            return ConstantMessages.AREA_NOT_SUITABLE;
        }

    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.stream().filter(a-> a.getName().equals(areaName)).findFirst().get();
        area.feed();
        int feedAnimals = area.getAnimals().size();
        return String.format(ConstantMessages.ANIMALS_FED,feedAnimals);
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.stream().filter(a-> a.getName().equals(areaName)).findFirst().get();
        double sumKilograms = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

        return String.format(ConstantMessages.KILOGRAMS_AREA,areaName, sumKilograms);
    }

    @Override
    public String getStatistics() {
        return areas.stream().map(Area::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
