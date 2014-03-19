package uppgift6.game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	private JPanel playerPanel;
	private JPanel dealerPanel;
	private JPanel playerCardPanel;
	private JPanel dealerCardPanel;
	private JPanel dealerLabelPanel;
	private JPanel playerLabelPanel;
	private JLabel playerLabel;
	private JLabel dealerLabel;
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
		
		statusFont = new Font("SansSerif", Font.BOLD, 16);
		
		playerLabel = new JLabel("Player");
		playerLabel.setFont(statusFont);
		playerLabel.setForeground(Color.white);
			
		dealerLabel = new JLabel("Dealer");
		dealerLabel.setFont(statusFont);
		dealerLabel.setForeground(Color.white);
		
		dealerLabelPanel = new JPanel(new FlowLayout());
		dealerLabelPanel.setBackground(new Color(0,0,0,0));
		dealerLabelPanel.add(dealerLabel);
		
		playerLabelPanel = new JPanel(new FlowLayout());
		playerLabelPanel.setBackground(new Color(0,0,0,0));
		playerLabelPanel.add(playerLabel);
		
		playerPanel = new JPanel(new BorderLayout());
		playerPanel.setBackground(new Color(0,0,0,0));
		
		dealerPanel = new JPanel(new BorderLayout());
		dealerPanel.setBackground(new Color(0,0,0,0));
	
		playerPanel = new JPanel(new BorderLayout());
		playerPanel.setBackground(new Color(0,0,0,0));
		
		dealerCardPanel = new JPanel();
		dealerCardPanel.setBackground(new Color(0,0,0,0));
	
		playerCardPanel = new JPanel();
		playerCardPanel.setBackground(new Color(0,0,0,0));

		
		statusLabel = new JLabel();
		statusLabel.setText("Welcome to BlackJack! Hit the Deal button to start playing.");
		statusLabel.setFont(statusFont);
		statusLabel.setForeground(Color.white);
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(2,1));
		tablePanel.setBackground(new Color(0,0,0,0));
		
		dealerPanel.add(dealerCardPanel, BorderLayout.NORTH);
		dealerPanel.add(dealerLabelPanel, BorderLayout.CENTER);
		
		playerPanel.add(playerCardPanel, BorderLayout.NORTH);
		playerPanel.add(playerLabelPanel, BorderLayout.CENTER);
		
		tablePanel.add(dealerPanel);
		tablePanel.add(playerPanel);
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
		
		
//		tablePanel.add(dealerPanel);
//		tablePanel.add(playerPanel);		
	}
	
	@Override
	public void dealDealerCard(Card card) {
		
		System.out.println(card.toString());
		dealerCards.add(card);

		dealerCardPanel.add(new DrawableCard(card));
		
		
//		tablePanel.add(dealerPanel);
//		tablePanel.add(playerPanel);
	}
	
	@Override
	public void setLabel(String text){
		statusLabel.setText(text);
	}


	@Override
	public void gameOver() {

		
	}

}