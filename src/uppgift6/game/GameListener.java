package uppgift6.game;

/**
 * Listener interface of basic game events.
 * 
 * @author Anders Lundholm
 *
 */
public interface GameListener {
	void gameStart();
	void dealPlayerCard(Card card);
	void dealDealerCard(Card card);
	void setStatus(String text);
}
