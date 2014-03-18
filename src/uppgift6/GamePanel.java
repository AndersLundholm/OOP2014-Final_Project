package uppgift6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
	private TablePanel tablePanel;
	
	public GamePanel(){

		this.setLayout(new BorderLayout());
		
		this.setSize(9999, 500);
		this.setBackground(new Color(0,0,0,0));
		
		tablePanel = new TablePanel();
		
		
		dealerCardPanel = new CardPanel(dealerCards);
		dealerCardPanel.setSize(9999, 110);
		
		playerCardPanel = new CardPanel(playerCards);
		playerCardPanel.setSize(9999, 110);
		
		statusFont = new Font("SansSerif", Font.PLAIN, 16);
		statusLabel = new JLabel();
		statusLabel.setText("Here be text! This should get updated.");
		statusLabel.setFont(statusFont);
		statusLabel.setForeground(Color.black);
		
		tablePanel.add(dealerCardPanel, FlowLayout.LEFT);
		tablePanel.add(playerCardPanel, FlowLayout.LEFT);
		this.add(tablePanel, BorderLayout.CENTER);
//		this.add(dealerCardPanel, BorderLayout.NORTH);
//		this.add(playerCardPanel, BorderLayout.CENTER);
		this.add(statusLabel, BorderLayout.SOUTH);
		
		gameStart();
		
	}

	@Override
	public void gameStart() {

		System.out.println("Game started!");
		playerCards = new ArrayList<Card>();
		dealerCards = new ArrayList<Card>();
			
		dealerCardPanel.removeAll();
		dealerCardPanel.validate();
		dealerCardPanel.repaint();
		playerCardPanel.removeAll();
		playerCardPanel.validate();
		playerCardPanel.repaint();
		statusLabel.removeAll();
		statusLabel.validate();
		statusLabel.repaint();
//		this.removeAll();
//		this.validate();
//		this.repaint();
	}
	
	@Override
	public void playerBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealPlayerCard(Card card) {
		
		System.out.println(card.toString());
		playerCards.add(card);

		
		CardPanel playerCardPanel = new CardPanel(playerCards);

		playerCardPanel.add(new DrawableCard(card));
		
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
		
		CardPanel dealerCardPanel = new CardPanel(dealerCards);

		playerCardPanel.add(new DrawableCard(card));
		
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
