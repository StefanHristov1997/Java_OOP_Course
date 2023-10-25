package WorkingAbstraction_Exercise_01.CardsWithPower_03;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int powerSuit;

    CardSuits(int powerSuit) {
        this.powerSuit = powerSuit;
    }

    public int getPowerSuit(){
        return this.powerSuit;
    }
}
