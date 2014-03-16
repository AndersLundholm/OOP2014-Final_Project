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
	private int dealerScore = 0;
	
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
	
	public void dealerPlay() {
		
		
		ArrayList<Card> dealerCards = dealer.getDealerCards();
		dealerScore = 0;
		dealDealerCards();
		boolean ace = false;
		for(Card c : dealerCards){
			if(c.getRank() == 1 && dealerScore >= 6 && dealerScore <= 10){
				dealerScore += 11;
				ace = true;
			} else {
				if(ace == true && dealerScore >= 6 && dealerScore <= 10){
					dealerScore += c.getRank() +10;
				} else {
					dealerScore += c.getRank();
				}
			}
			
		}
		
		if(dealerScore < 17){
			
			dealerCards = dealer.getDealerCards();
			System.out.println("Dealer has: " + dealerScore);
//			gameListener.setLabel("Dealer has: " + dealerScore);
			dealerPlay();
		} else if(dealerScore > 21){
			System.out.println("Dealer bust!");
		} else {
			if(dealerCards.size() == 2 && dealerScore == 21){
				System.out.println("Dealer has BlackJack!");
			}
			System.out.println("Dealer has: " + dealerScore);
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
