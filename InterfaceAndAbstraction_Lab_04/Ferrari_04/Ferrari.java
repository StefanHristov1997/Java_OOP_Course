package InterfaceAndAbstraction_Lab_04.Ferrari_04;

public class Ferrari implements Car {
    private String driverName;
    private final static String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",MODEL,brakes(),gas(),this.driverName);
    }
}
