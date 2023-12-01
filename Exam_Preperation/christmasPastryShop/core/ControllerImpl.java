package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    private double completedBills;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.completedBills = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy == null) {
            if (type.equals("Gingerbread")) {
                delicacy = new Gingerbread(name, price);
            } else if (type.equals("Stolen")) {
                delicacy = new Stolen(name, price);
            }
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);

        if (cocktail == null) {
            if (type.equals("Hibernation")) {
                cocktail = new Hibernation(name, size, brand);
            } else if (type.equals("MulledWine")) {
                cocktail = new MulledWine(name, size, brand);
            }
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        if(booth == null){
            if (type.equals("OpenBooth")) {
                booth = new OpenBooth(boothNumber, capacity);
            } else if (type.equals("PrivateBooth")) {
                booth = new PrivateBooth(boothNumber, capacity);
            }
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
        }

        boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        List<Booth> freeBooths = boothRepository.getAll()
                .stream().filter(booth -> !booth.isReserved() && booth.getCapacity() >= numberOfPeople)
                .collect(Collectors.toList());

        if (freeBooths.isEmpty()) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        Booth freeBooth = freeBooths.get(0);
        freeBooth.reserve(numberOfPeople);
        return String.format(OutputMessages.BOOTH_RESERVED, freeBooth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        double price = booth.getPrice();
        double finalBill = bill + price;
        completedBills += finalBill;
        String result = String.format(OutputMessages.BILL, boothNumber, finalBill);
        booth.clear();

        return result;
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, completedBills);
    }
}
