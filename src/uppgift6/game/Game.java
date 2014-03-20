package uppgift6.game;

import java.util.ArrayList;

/**
 * This class is handling the logic of the game.
 * It updates the graphics by calling the GameListener interface.
 * 
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
	
	/**
	 * Creates a Dealer object and starts the game
	 * via the GameListener. Then deals one card to the dealer and
	 * two cards to the player.
	 * @param gameListener the GameListener object
	 */
	public Game(GameListener gameListener){
		
		this.gameListener = gameListener;
		
		dealer = new Dealer(gameListener);
		
		gameListener.gameStart();
		
		dealDealerCards();
		
		dealPlayerCards();
		dealPlayerCards();
	}
	
	/**
	 * Deals a card to the player and updates the players total score
	 * and passes the score to the GameListener. Also checks if the 
	 * score is above 21 and if so ends the game, or if the player
	 * gets a BlackJack in which case the player wins.
	 */
	public void dealPlayerCards(){	
		ArrayList<Card> playerCards = dealer.getPlayerCards();
		dealer.dealCards(1);
		playerScore = checkScore(playerCards);
		gameListener.setStatus("You have: " + playerScore);
		
		if(playerScore > 21){
			gameListener.setStatus("You busted! You Loose!");
			gameOver = true;
		} else if(playerCards.size() == 2 && playerScore == 21){
				gameListener.setStatus("You got BlackJack! You Win!");
				gameOver = true;
		}
	}
	
	/**
	 * Deals a card to the dealer.
	 */
	public void dealDealerCards(){		
		dealer.dealCards(0);
	}
	
	/**
	 * Deals a cards to the dealer as long as the dealers score
	 * is below 16 or if it goes above 21.
	 */
	public void dealerPlay() {
		stay = true;
		ArrayList<Card> dealerCards = dealer.getDealerCards();
		dealerScore = checkScore(dealerCards);
		
		if(dealerScore < 17){
			gameListener.setStatus("Dealer has: " + dealerScore);
			dealDealerCards();
			dealerPlay();
		} else if(dealerScore > 21){
			gameListener.setStatus("Dealer bust! You Win!");
			gameOver = true;
		} else {
			if(dealerCards.size() == 2 && dealerScore == 21){
				gameListener.setStatus("Dealer has BlackJack! You Loose!");
				gameOver = true;
			} else {
				decideWinner();
				gameOver = true;
			}
		}
	}
	/**
	 * Returns false as unless the stay button has been clicked
	 * at which time the dealerPlay() method is run.
	 */
	public boolean getStay(){ 
		return stay; 
	} 
	
	/**
	 *  Returns false as unless the player or dealer is 
	 *  busted or a winner has been decided.
	 */
	public boolean getGameOver(){ 
		return gameOver;
	}

	/**
	 * Calculates the total score of the passed list of cards.
	 * Counts Ace as one or 11 depending on the total score 
	 * of the other cards.
	 * @param cards the list of cards to calculate the score from.
	 * @return the total score.
	 */
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
	
	/**
	 * Compares the dealers total score with the players
	 * total score and decides the winner and then
	 * updates the GameListener. 
	 */
	private void decideWinner(){
		
		if(playerScore > dealerScore){
			gameListener.setStatus("Dealer has: " + dealerScore + 
					", You have: " + playerScore + ", You Win!");
		} else {
			gameListener.setStatus("Dealer has: " + dealerScore + 
					", You have: " + playerScore + ", You Loose!");
		}
	}
}
