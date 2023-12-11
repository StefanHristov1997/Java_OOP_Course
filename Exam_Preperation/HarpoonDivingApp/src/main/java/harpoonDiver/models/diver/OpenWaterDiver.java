package harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver {
    private final static double OXYGEN = 30;
    public OpenWaterDiver(String name) {
        super(name, OXYGEN);
    }
}
