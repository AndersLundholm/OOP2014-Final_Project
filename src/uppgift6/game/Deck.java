package uppgift6.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is a collection of 52 card card objects.
 * 
 * @author Anders Lundholm
 *
 */
public class Deck {
	
	private ArrayList<Card> deck;
	
	/**
	 * Creates a deck of 52 cards.
	 */
	public Deck(){
		deck = new ArrayList<Card>();
		
		for(int i = 0; i < 52; i++){
			deck.add(new Card(i));
		}
	}
	
	/**
	 * Draws a random card from the deck and removes it from the deck.
	 * @return a random card.
	 */
	public Card drawCard(){
		Random random = new Random();
		int index = random.nextInt(deck.size());
		Card topCard = deck.get(index);
		deck.remove(index);
		
		return topCard;
	}
	
	/**
	 * @return and ArrayList with the card objects.
	 */
	public ArrayList<Card> getDeck(){ 
		return deck;
	}
	
	/**
	 * @return the current size of the deck.
	 */
	public int getSize(){
		return deck.size();
	}
}
