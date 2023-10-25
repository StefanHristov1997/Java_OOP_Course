package WorkingAbstraction_Exercise_01.CardsWithPower_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Card card = new Card(CardSuits.valueOf(cardSuit),CardRanks.valueOf(cardRank));

        System.out.println(card);
    }
}
