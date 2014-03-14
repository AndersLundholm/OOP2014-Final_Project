package uppgift6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Anders Lundholm
 *
 */
public class GamePanel extends JPanel implements GameListener {

	private static final long serialVersionUID = 1L;
	private Deck deck;
	private CardPanel cardPanel;
	private Game game;
	private ArrayList<Card> cards;
	private JPanel playerCardPanel;
	private JPanel dealerCardPanel;
	private int playerScore;
	private boolean gameOver = false;
	
	public GamePanel(){

		this.setLayout(new BorderLayout());
		
		this.setSize(9999, 200);
//		this.setBackground(Color.black);
		playerScore = 0;
		dealerCardPanel = new JPanel();
		dealerCardPanel.setSize(9999, 110);
		playerCardPanel = new JPanel();
		
//		playerCardPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(dealerCardPanel, BorderLayout.NORTH);
		this.add(playerCardPanel, BorderLayout.CENTER);
		
		gameStart();

		
	}

	@Override
	public void gameStart() {

		System.out.println("Game started!");
		cards = new ArrayList<Card>();
		playerCardPanel.removeAll();
		playerCardPanel.validate();
		playerCardPanel.repaint();

		
	}
	
	@Override
	public void playerBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealCard(Card card) {
		
		System.out.println(card.toString());
		cards.add(card);
		
		CardPanel cardPanel = new CardPanel(cards);
		
		playerCardPanel.add(cardPanel, BorderLayout.SOUTH);

		playerCardPanel.repaint();

		playerCardPanel.setSize(1000, 500);
		
//		playerScore = game.checkScore(cards);
		playerScore = 0;
		for(Card c : cards){
			playerScore += c.getRank();
			
			if(playerScore == 21){
				System.out.println("You Win!");
				gameOver();
			}
		}

		
		System.out.println(playerScore);
	}
	


	@Override
	public void gameOver() {
		gameOver = true;
//		gameStart();
		
	}
	
	public void stay(){
		System.out.println("You stayed at: " + playerScore);
	}
	
	public int getPlayerScore(){
		return playerScore;
	}


	




}
