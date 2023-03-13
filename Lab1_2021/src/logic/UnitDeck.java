package logic;
import java.util.ArrayList;

public class UnitDeck {

	private String deckName;
	private ArrayList<CardCounter> cardsInDeck = new ArrayList<>();

	public int cardCount() {
		int sum = 0;
		for (int i = 0; i < cardsInDeck.size(); i++) {
			sum += cardsInDeck.get(i).getCount();
		}
		return sum;
	}

	public void removeCard(UnitCard toRemove, int count) {
		if (count > 0) {
			for (int i = 0; i < this.getCardsInDeck().size(); i++) {
				if (this.getCardsInDeck().get(i).getCard().equals(toRemove)) {
					if (this.getCardsInDeck().get(i).getCount() > count) {
						this.getCardsInDeck().get(i).setCount(this.getCardsInDeck().get(i).getCount() - count);
					} else {
						cardsInDeck.remove(i);
					}
				}
			}

		}
	}

	public boolean existsInDeck(UnitCard card) {
		for (CardCounter cards : this.getCardsInDeck()) {
			if (cards.getCard() == card) {
				if (cards.getCount() >= 1) {
					return true;
				}
			}
		}
		return false;
	}

	public void addCard(UnitCard newCard, int count) {
		int x = 0;
		if (count > 0) {
			for (CardCounter m : this.cardsInDeck) {
				if (m.getCard() == newCard) {
					int i = m.getCount();
					m.setCount(i + count);
					x++;
				}
			}
			if (x == 0) {
				cardsInDeck.add(new CardCounter(newCard, count));
			}
		}
	}

	public UnitDeck(String deckName) {
		setDeckName(deckName);
	}

	public boolean equals(UnitDeck other) {
		UnitDeck otherDeck = (UnitDeck) other;
		if (this.getDeckName() == otherDeck.getDeckName()) {
			return true;
		}
		return false;
	}

	// setter
	public void setDeckName(String deckName) {
		if (deckName.isBlank()) {
			this.deckName = "Untitled Deck";
		} else {
			this.deckName = deckName;
		}
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	// getter
	public String getDeckName() {
		return deckName;
	}

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}
}