package uppgift6.game;

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
	private boolean gameOver = false;
	
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
		gameListener.setLabel("You have: " + playerScore);
		
		if(playerScore > 21){
			System.out.println("You busted! You Loose!");
			gameListener.setLabel("You busted! You Loose!");
			gameOver = true;
		} else if(playerCards.size() == 2 && playerScore == 21){
				System.out.println("You got BlackJack! You Win!");
				gameListener.setLabel("You got BlackJack! You Win!");
				gameOver = true;
		}
	}
	
	public void dealDealerCards(){		
		dealer.dealCards(0);
	}
	
	public void dealerPlay() {
		stay = true;
		ArrayList<Card> dealerCards = dealer.getDealerCards();
		dealerScore = checkScore(dealerCards);
		
		if(dealerScore < 17){
			System.out.println("Dealer has: " + dealerScore);
			gameListener.setLabel("Dealer has: " + dealerScore);
			dealDealerCards();
			dealerPlay();
		} else if(dealerScore > 21){
			System.out.println("Dealer bust! You Win!");
			gameListener.setLabel("Dealer bust! You Win!");
			gameOver = true;
		} else {
			if(dealerCards.size() == 2 && dealerScore == 21){
				System.out.println("Dealer has BlackJack! You Loose!");
				gameListener.setLabel("Dealer has BlackJack! You Loose!");
				gameOver = true;
			} else {
				decideWinner();
				gameOver = true;
			}
		}
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
		System.out.println("Dealer has: " + dealerScore);
		System.out.println("You have: " + playerScore);
		
		if(playerScore > dealerScore){
			System.out.println("Player wins!");
			gameListener.setLabel("Dealer has: " + dealerScore + ", You have: " + playerScore + ", You Win!");
		} else {
			System.out.println("Dealer wins!");
			gameListener.setLabel("Dealer has: " + dealerScore + ", You have: " + playerScore + ", You Loose!");
		}
	}
	
	public boolean getStay(){ return stay; }
	public boolean getGameOver(){ return gameOver; }
	
	
}
