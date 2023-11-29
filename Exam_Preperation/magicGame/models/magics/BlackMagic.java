package magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int currentAmountOfBullets = getBulletsCount();

        if (currentAmountOfBullets < 10) {
            currentAmountOfBullets = 0;
        } else {
            currentAmountOfBullets -= 10;
            setBulletsCount(currentAmountOfBullets);
        }

        return currentAmountOfBullets;
    }
}
