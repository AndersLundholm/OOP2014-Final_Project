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
	void dealCard(Card card);
	void gameOver();
}
