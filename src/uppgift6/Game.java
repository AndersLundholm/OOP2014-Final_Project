package uppgift6;

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
		
		
	}
	

	
	public void dealCards(){
		
		dealer.dealCards();
		
	}
	
	

}
