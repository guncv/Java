package deck;


import java.util.Arrays;

import card.base.Card;


public class Deck {
	// TODO: constructor
	private String name;
	private Card[] deckList;
	private int deckSize;

	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckList = deckList;
		setDeckSize(this.deckList.length);
	}

	//You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException{
		int count = 0;
		for (Card sameCard : this.deckList){
			if (sameCard == card){
				count++;
			}
		}
		if(count >= 4) 
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		//FILL CODE HERE
		//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
		//Must return new deckSize
		Card[] newDeck = Arrays.copyOf(this.deckList, this.deckList.length + 1);
		int k = 0 ;
		for (int i=0 ; i<deckList.length ; i++){
			newDeck[i] = this.deckList[k];
			k++;
		}
		newDeck[k] = card;
		
		this.setDeckSize(this.deckList.length + 1);
		this.deckList = newDeck;
		return newDeck.length;
	}
	

	//You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}		
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}

		//FILL CODE HERE
		//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size (Added slot is empty)
		//Once card is removed, other card down the list must rearrange to the empty slot
		//Must return card that was removed
		Card remove = this.deckList[slotNumber];
		Card[] newDeck = Arrays.copyOf(deckList,this.deckList.length - 1);
		this.setDeckSize(this.deckSize - 1);
		int k = 0 ;
		for (int i=0 ; i<newDeck.length ; i++){
			if (k != slotNumber){
				newDeck[i] = this.deckList[k];
			}
			else {
				k++;
				newDeck[i] = this.deckList[k];
			}
			k++;
		}
		
		this.setDeckSize(this.deckList.length - 1);
		this.deckList = newDeck;
		return remove;
		

	}
		
	//setter
	public void setDeckSize(int deckSize){
		this.deckSize = deckSize;
	}

	//getter
	public Card[] getDeckList(){
		return deckList;
	}

	public String getName(){
		return name;
	}
		
	public int getDeckSize(){
		return deckSize;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}

	/* GETTERS & SETTERS */

}
