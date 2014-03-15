package uppgift6;

import java.util.ArrayList;

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
	public int getPlayerScore();
	void gameOver();
}
