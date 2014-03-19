package uppgift6;

import java.util.ArrayList;

/**
 * @author Anders Lundholm
 *
 */
public class Game {
	
	private GameListener gameListener;
	private Dealer dealer;
	private int dealerScore;
	private int playerScore;
	private boolean stay = false;
	
	public Game(GameListener gameListener){
		
		this.gameListener = gameListener;
		
		dealer = new Dealer(gameListener);
		
		gameListener.gameStart();
		
		dealDealerCards();
		
		dealPlayerCards();
		dealPlayerCards();
	}
	

	
	public void dealPlayerCards(){	
		ArrayList<Card> playerCards = dealer.getPlayerCards();
		
		dealer.dealCards(1);
		playerScore = checkScore(playerCards);
//		checkPlayerScore();
		gameListener.setLabel("Player has: " + playerScore);
	}
	
	public void dealDealerCards(){		
		dealer.dealCards(0);
	}
	
	public void dealerPlay() {
		stay = true;
		ArrayList<Card> dealerCards = dealer.getDealerCards();
		dealerScore = checkScore(dealerCards);
		dealDealerCards();
		
		
//		boolean ace = false;
//		for(Card c : dealerCards){
//			if(c.getRank() == 1 && dealerScore >= 6 && dealerScore <= 10){
//				dealerScore += 11;
//				ace = true;
//			} else if(c.getRank() == 1){
//				ace = true;
//			} else {
//				if(ace == true && dealerScore >= 6 && dealerScore <= 10){
//					dealerScore += c.getRank() +10;
//				} else {
//					dealerScore += c.getRank();
//				}
//			}
//		}
		
		if(dealerScore < 17){	
			dealerCards = dealer.getDealerCards();
			System.out.println("Dealer has: " + dealerScore);
			gameListener.setLabel("Dealer has: " + dealerScore);
			dealerPlay();
		} else if(dealerScore > 21){
			System.out.println("Dealer bust!");
			gameListener.setLabel("Dealer bust!");
		} else {
			if(dealerCards.size() == 2 && dealerScore == 21){
				System.out.println("Dealer has BlackJack!");
				gameListener.setLabel("Dealer has BlackJack!");
			} else {
			
				decideWinner();
			
			}
		}
	}	
	
	public void checkPlayerScore(){
		
//		ArrayList<Card> playerCards = dealer.getPlayerCards();
//		playerScore = checkScore(playerCards);
//		boolean ace = false;
//		for(Card c : playerCards){
//			
//			if(c.getRank() == 1){
//				ace = true;
//				
//				if(playerScore <= 10){
//					playerScore += 11;
//				} else {
//					playerScore += 1;
//					ace = false;
//				}
//			} else if(ace == true && playerScore > 21-c.getRank()) {
//				playerScore += c.getRank() - 10;
//				ace = false;
//			} else {
//				playerScore += c.getRank();
//			}
			
		
		
		
		
		
//			if(ace == true && playerScore >= 6 && playerScore <= 10){
//				
//			}
//			
//			if(c.getRank() == 1 && playerScore >= 6 && playerScore <= 10){
//				playerScore += 11;
//				ace = true;
//			} else if(c.getRank() == 1){
//				playerScore += c.getRank();
//				ace = true;
//			} else {
//				if(ace == true && playerScore >= 6 && playerScore <= 10){
//					playerScore += c.getRank() +10;
//				} else if(ace == true && c.getRank() == 10 && playerScore == 1){
//					playerScore += 10;
//					gameListener.setLabel("Players has BlackJack!");
//					stay = true;
//				}else {
//					playerScore += c.getRank();
//				}
//			}	
//		}
		
//		if(dealerScore > 21){
//			System.out.println("Dealer bust!");
//		} else {
//			if(playerCards.size() == 2 && playerScore == 21){
//				System.out.println("Player has BlackJack!");
//			}
//			System.out.println("Player has: " + playerScore);
//		}	
	}

	private int checkScore(ArrayList<Card> cards){
		
		int score = 0;
		boolean ace = false;
		for(Card c : cards){
			
			if(c.getRank() == 1){
				ace = true;
				
				if(score <= 10){
					score += 11;
				} else {
					score += 1;
					ace = false;
				}
			} else if(ace == true && score > 21-c.getRank()) {
				score += c.getRank() - 10;
				ace = false;
			} else {
				score += c.getRank();
			}
		}
		return score;
	}	
	
	private void decideWinner(){
		checkPlayerScore();
		System.out.println("Dealer has: " + dealerScore);
		System.out.println("Player has: " + playerScore);
		if(dealerScore > 21){
			System.out.println("Player wins!");
			gameListener.setLabel("Dealer has: " + dealerScore + ", Player has: " + playerScore + ", Player wins!");
		} else {
			if(playerScore > dealerScore){
				System.out.println("Player wins!");
				gameListener.setLabel("Dealer has: " + dealerScore + ", Player has: " + playerScore + ", Player wins!");
			} else {
				System.out.println("Dealer wins!");
				gameListener.setLabel("Dealer has: " + dealerScore + ", Player has: " + playerScore + ", Dealer wins!");
			}
		}
		
	}
	
	public boolean getStay(){ return stay; }
	
}
