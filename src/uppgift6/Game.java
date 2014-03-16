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
	private int dealerScore;
	private int playerScore;
	
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
		checkPlayerScore();
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
			} else {
			
				decideWinner();
			
			}
			
		}
		
		
		
	}	
	
	public void checkPlayerScore(){
		
		ArrayList<Card> playerCards = dealer.getPlayerCards();
		playerScore = 0;
		boolean ace = false;
		for(Card c : playerCards){
			if(c.getRank() == 1 && dealerScore >= 6 && dealerScore <= 10){
				playerScore += 11;
				ace = true;
			} else {
				if(ace == true && dealerScore >= 6 && dealerScore <= 10){
					playerScore += c.getRank() +10;
				} else {
					playerScore += c.getRank();
				}
			}	
		}
		
		if(dealerScore > 21){
			System.out.println("Dealer bust!");
		} else {
			if(playerCards.size() == 2 && dealerScore == 21){
				System.out.println("Player has BlackJack!");
			}
			System.out.println("Player has: " + playerScore);
		}	
	}
	
	public void decideWinner(){
		checkPlayerScore();
		System.out.println("Dealer has: " + dealerScore);
		System.out.println("Player has: " + playerScore);
		if(dealerScore > 21){
			System.out.println("Player wins!");
		} else {
			if(playerScore > dealerScore){
				System.out.println("Player wins!");
			} else {
				System.out.println("Dealer wins!");
			}
		}
		
	}
	
	

}
