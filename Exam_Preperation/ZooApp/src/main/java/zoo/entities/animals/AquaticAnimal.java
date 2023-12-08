package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    private final static double KG = 2.50;
    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eat() {
        double currentKG = getKg();
        currentKG += 7.50;
        setKg(currentKG);
    }
}
