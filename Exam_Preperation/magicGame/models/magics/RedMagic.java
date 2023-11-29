package magicGame.models.magics;

public class RedMagic extends MagicImpl {
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int currentAmount = getBulletsCount();

        if (currentAmount < 1) {
            currentAmount = 0;
        } else {
            currentAmount -= 1;
            setBulletsCount(currentAmount);
        }
        return currentAmount;
    }
}
