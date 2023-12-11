package harpoonDiver.models.diver;

public class WreckDiver extends BaseDiver {
    private final static double OXYGEN = 150;
    public WreckDiver(String name) {
        super(name, OXYGEN);
    }
}
