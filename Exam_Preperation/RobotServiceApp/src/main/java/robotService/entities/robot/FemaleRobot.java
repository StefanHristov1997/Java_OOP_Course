package robotService.entities.robot;

public class FemaleRobot extends BaseRobot {

    private final static int KILOGRAMS = 7;

    public FemaleRobot(String name, String kind,double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }
}
