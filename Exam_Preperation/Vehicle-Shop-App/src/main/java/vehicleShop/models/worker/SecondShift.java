package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    private final static int STRENGTH = 70;

    public SecondShift(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void working() {
        int currentStrength = getStrength();
        currentStrength -= 15;
        if (currentStrength < 0) {
            currentStrength = 0;
        }
        setStrength(currentStrength);
    }
}
