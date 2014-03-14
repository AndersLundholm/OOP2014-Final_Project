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
	private JPanel testPanel;
	private int row = 1;
	
	public GamePanel(){

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.setSize(500, 700);
		this.setBackground(Color.black);
		testPanel = new JPanel();
		
		testPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		
		this.add(testPanel);
		
		gameStart();

		
	}

	@Override
	public void gameStart() {

		System.out.println("Game started!");
		cards = new ArrayList<Card>();
		testPanel.removeAll();
		testPanel.validate();
		testPanel.repaint();
		
	}
	
	@Override
	public void playerBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealCard(Card card) {
		
		System.out.println(card.toString());
		cards.add(card);
		
		CardPanel cardPanel = new CardPanel(cards, row);
		testPanel.add(cardPanel, BorderLayout.SOUTH);

		testPanel.repaint();

		testPanel.setSize(1000, 500);
		row++;
	}
	


	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}


	




}
