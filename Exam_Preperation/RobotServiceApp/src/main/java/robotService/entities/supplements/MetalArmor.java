package robotService.entities.supplements;

public class MetalArmor extends BaseSupplement {
    private final static int HARDNESS = 5;
    private final static double PRICE = 15;
    public MetalArmor() {
        super(HARDNESS, PRICE);
    }
}
