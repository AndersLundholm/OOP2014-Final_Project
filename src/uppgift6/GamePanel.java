package uppgift6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
//	private TablePanel tablePanel;
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
		statusLabel.setForeground(Color.black);
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(2,1));
//		tablePanel.setLayout(new BorderLayout());
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

		
//		CardPanel playerCardPanel = new CardPanel(playerCards);

		playerCardPanel.add(new DrawableCard(card));
		
		tablePanel.add(dealerCardPanel);
		tablePanel.add(playerCardPanel);
		
//		this.add(playerCardPanel, BorderLayout.CENTER);
		
//		this.validate();
//
//		this.repaint();
		
		
	}
	
	@Override
	public void dealDealerCard(Card card) {
		
		System.out.println(card.toString());
		dealerCards.add(card);
		
//		CardPanel dealerCardPanel = new CardPanel(dealerCards);

		dealerCardPanel.add(new DrawableCard(card));
		
		tablePanel.add(dealerCardPanel);
		tablePanel.add(playerCardPanel);
//		this.add(dealerCardPanel, BorderLayout.CENTER);
		
//		dealerCardPanel.validate();
//		this.validate();
//		this.repaint();

	}
	
	@Override
	public void setLabel(String text){
		statusLabel.setText(text);
//		dealerLabel.validate();
//		dealerLabel.repaint();
//		dealerCardPanel.repaint();
//		playerCardPanel.repaint();
//		this.validate();
		this.repaint();
	}


	@Override
	public void gameOver() {

		
	}

}
