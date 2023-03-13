package logic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		if (list.contains(card)) {
			return true;
		}
		return false;

	}

	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		if (list.contains(deck)) {
			return true;
		}
		return false;

	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck deck : deckList) {
			for (CardCounter card : deck.getCardsInDeck()) {
				if (card.getCard().equals(cardToTest)) {
					return true;
				}
			}
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) {

		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		try {
			Scanner inFile = new Scanner(fileToRead);
			while (inFile.hasNextLine()) {
				String[] check = inFile.nextLine().split(",");
				UnitCard nextCard = new UnitCard(check[0], Integer.parseInt(check[1]), Integer.parseInt(check[2]),
						Integer.parseInt(check[3]), check[4]);
				cardsFromFile.add(nextCard);
			}
			inFile.close();
			return cardsFromFile;
		} catch (FileNotFoundException e) {
			return null;
		}

	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {

		for (int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if (verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if (i < cardList.size() - 1)
					System.out.println("-----");
			}
		}
	}

	public static void printDeck(UnitDeck ud) {

		if (ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		} else {
			for (CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}

		System.out.println("Total Cards: " + ud.cardCount());
	}

	public static void printDeckList(ArrayList<UnitDeck> deckList) {

		for (int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if (i < deckList.size() - 1)
				System.out.println("-----");
		}
	}
}
