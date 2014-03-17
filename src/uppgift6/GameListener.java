package uppgift6;

/**
 * Listener of basic game events.
 * @author Anders Lundholm
 *
 */
public interface GameListener {
	void gameStart();
	void playerBet(int bet);
	void dealPlayerCard(Card card);
	void dealDealerCard(Card card);
	void setLabel(String text);
	void gameOver();
}
