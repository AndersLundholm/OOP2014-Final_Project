
package uppgift6;

import java.util.ArrayList;

/**
 * @author Anders Lundholm
 *
 */
public class Dealer {
	
	private Deck deck;
	private GameListener gameListener;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Dealer(GameListener gameListener){
		this.gameListener = gameListener;
		deck = new Deck();
	}
	
	public void dealCards(){	
		if(deck.getSize() > 0){
			Card card = deck.drawCard();
			cards.add(card);
			gameListener.dealCard(card);
		} else {
			System.out.println("No more cards!");
		}
	}
}
