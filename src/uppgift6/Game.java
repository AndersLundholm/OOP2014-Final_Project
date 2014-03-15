package uppgift6;

import java.util.ArrayList;

/**
 * @author Anders Lundholm
 *
 */
public class Game {
	
	private GameListener gameListener;
	private Dealer dealer;
	private DealerPlay dealerPlay;
	
	public Game(GameListener gameListener){
		
		this.gameListener = gameListener;
		
		dealer = new Dealer(gameListener);
		
		gameListener.gameStart();
		dealDealerCards();
//		dealer.dealCards(0);
		dealPlayerCards();
		dealPlayerCards();
		
	}
	

	
	public void dealPlayerCards(){	
		dealer.dealCards(1);	
	}
	
	public void dealDealerCards(){	
		
		dealer.dealCards(0);
			
		
		
	}
	
	public void dealerPlay(){

		ArrayList<Card> dealerCards = dealer.getDealerCards();
		int dealerScore = 0;
		
		for(Card c : dealerCards){
			dealerScore += c.getRank();
			
			
//			else{
//				System.out.println("Dealer stays!");
//			}
		}
		
		if(dealerScore < 17){
			dealDealerCards();
			dealerCards = dealer.getDealerCards();
		}
		System.out.println("Dealer has: " + dealerScore);
		
	}
	
//	public void stay(){
//		System.out.println("You stayed at:" + gameListener.);
//	}
	
	public int checkScore(ArrayList<Card> cards){
		int score = 0;
		for(Card card : cards){
			score += card.getRank();
		}
		return score;
	}
	
	

}
