package uppgift6;

import java.util.ArrayList;

/**
 * @author Anders Lundholm
 *
 */
public class Game {
	
	private GameListener gameListener;
	private Dealer dealer;
	
	public Game(GameListener gameListener){
		
		this.gameListener = gameListener;
		
		dealer = new Dealer(gameListener);
		
		gameListener.gameStart();
		dealDealerCards();
		dealPlayerCards();
		dealPlayerCards();
		
	}
	

	
	public void dealPlayerCards(){	
		dealer.dealCards(1);	
	}
	
	public void dealDealerCards(){	
		dealer.dealCards(0);	
	}
	
	public void dealerPlay(int dealerScore){

		System.out.println(dealerScore);
		if(dealerScore < 17){
			dealDealerCards();
		}
		
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
