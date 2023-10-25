package WorkingAbstraction_Exercise_01.CardsWithPower_03;

public class Card {
    private CardSuits cardSuits;
    private CardRanks cardRanks;

    private  int cardPower;

    public Card(CardSuits cardSuits, CardRanks cardRanks) {
        this.cardSuits = cardSuits;
        this.cardRanks = cardRanks;
        this.cardPower = this.cardSuits.getPowerSuit() + this.cardRanks.getRankPower();
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public int getCardPower() {
        return cardPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", cardRanks.name(),cardSuits.name() ,getCardPower());
    }
}
