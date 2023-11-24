package robotService.entities.robot;

public class MaleRobot extends BaseRobot {

    private final static int KILOGRAMS = 9;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 3);
    }
}
