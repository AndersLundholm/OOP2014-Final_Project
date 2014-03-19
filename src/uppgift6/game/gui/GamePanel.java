package uppgift6.game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uppgift6.game.Card;
import uppgift6.game.GameListener;

/**
 * @author Anders Lundholm
 *
 */
public class GamePanel extends JPanel implements GameListener {

	private static final long serialVersionUID = 1L;
	private ArrayList<Card> playerCards = new ArrayList<Card>();
	private ArrayList<Card> dealerCards = new ArrayList<Card>();
	private JPanel playerCardPanel;
	private JPanel dealerCardPanel;
	private JLabel statusLabel;
	private Font statusFont;
	private JPanel tablePanel;
	
	public GamePanel(){

		this.setLayout(new BorderLayout());
		
		this.setSize(9999, 500);
		this.setBackground(new Color(0,0,0,0));
	
		gameStart();
		
	}

	@Override
	public void gameStart() {

		System.out.println("Game started!");
		playerCards = new ArrayList<Card>();
		dealerCards = new ArrayList<Card>();
		
		this.removeAll();
		this.validate();
		this.repaint();
		
		dealerCardPanel = new JPanel();
		dealerCardPanel.setBackground(new Color(0,0,0,0));
	
		playerCardPanel = new JPanel();
		playerCardPanel.setBackground(new Color(0,0,0,0));

		statusFont = new Font("SansSerif", Font.BOLD, 16);
		statusLabel = new JLabel();
		statusLabel.setText("Here be text! This should get updated.");
		statusLabel.setFont(statusFont);
		statusLabel.setForeground(Color.white);
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(2,1));
		tablePanel.setBackground(new Color(0,0,0,0));
		
		tablePanel.add(dealerCardPanel);
		tablePanel.add(playerCardPanel);
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(statusLabel, BorderLayout.SOUTH);
	}
	
	@Override
	public void playerBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealPlayerCard(Card card) {
		
		System.out.println(card.toString());
		playerCards.add(card);

		playerCardPanel.add(new DrawableCard(card));
		
		tablePanel.add(dealerCardPanel);
		tablePanel.add(playerCardPanel);		
	}
	
	@Override
	public void dealDealerCard(Card card) {
		
		System.out.println(card.toString());
		dealerCards.add(card);

		dealerCardPanel.add(new DrawableCard(card));
		
		tablePanel.add(dealerCardPanel);
		tablePanel.add(playerCardPanel);
	}
	
	@Override
	public void setLabel(String text){
		statusLabel.setText(text);
	}


	@Override
	public void gameOver() {

		
	}

}
