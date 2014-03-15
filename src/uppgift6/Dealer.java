
package uppgift6;

import java.util.ArrayList;

/**
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
}
