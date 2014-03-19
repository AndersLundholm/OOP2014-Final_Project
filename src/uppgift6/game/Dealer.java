
package uppgift6.game;

import java.util.ArrayList;

/**
 * This class creates an instance of Deck and then
 * removes random cards from that deck and passes them
 * to the GameListener interface. 
 * 
 * @author Anders Lundholm
 *
 */
public class Dealer {
	
	private Deck deck;
	private GameListener gameListener;
	private ArrayList<Card> dealerCards = new ArrayList<Card>();
	private ArrayList<Card> playerCards = new ArrayList<Card>();
	private Card card;
	
	public Dealer(GameListener gameListener){
		this.gameListener = gameListener;
		deck = new Deck();
	}
	
	/**
	 * Passes a random card to the GameListener interface.
	 * 
	 * @param dealTo 1 to deal card to player and
	 * any other integer to deal card to the dealer
	 */
	public void dealCards(int dealTo){	
		if(deck.getSize() > 0){
			card = deck.drawCard();
			
			if(dealTo == 1){
				playerCards.add(card);
				gameListener.dealPlayerCard(card);
			} else {
				dealerCards.add(card);
				gameListener.dealDealerCard(card);
			}
		} else {
			System.out.println("No more cards!");
		}
	}
	
	public ArrayList<Card> getDealerCards(){
		return dealerCards;
	}
	
	public ArrayList<Card> getPlayerCards(){
		return playerCards;
	}
}
