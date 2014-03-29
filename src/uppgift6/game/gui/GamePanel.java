package uppgift6.game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uppgift6.game.Card;
import uppgift6.game.GameListener;

/**
 * This panel contains all panels and labels for the 
 * graphics for the game. It is updated by implementing
 * the GameListener interface.  
 * 
 * @author Anders Lundholm
 *
 */
public class GamePanel extends JPanel implements GameListener {

	private static final long serialVersionUID = 1L;
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
		this.setBackground(new Color(0,0,0,0));
	
		gameStart();
	}

	/**
	 * Starts with removing everything in the panel and then
	 * validate and repaints it to clear old paintings.
	 * The panel structure is: tablePanel is the outer panel
	 * which is added to the GamePanel (this), and contains
	 * all other panels and also the statusLabel which gets updated
	 * with game information. In tablePanel is the dealerPanel 
	 * and the playerPanel added. Inside these panels
	 * are one cardPanel for each panel (playerCardPanel and 
	 * dealerCardPanel) and also a panel for each that contains
	 * a label that prints out the names ("Dealer" and Player).
	 */
	@Override
	public void gameStart() {	
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
		
		playerLabelPanel = new JPanel(new FlowLayout());
		playerLabelPanel.setBackground(new Color(0,0,0,0));
		
		
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
	
	/**
	 * Adds a graphical card, to the players card panel,
	 * from the Card object passed. Also adds the player
	 * label (the String "Player") below the card.
	 */
	@Override
	public void dealPlayerCard(Card card) {
		playerCardPanel.add(new DrawableCard(card));	
		playerLabelPanel.add(playerLabel);
	}
	
	/**
	 * Adds a graphical card, to the dealers card panel,
	 * from the Card object passed. Also adds the dealer
	 * label (the String "Dealer") below the card.
	 */
	@Override
	public void dealDealerCard(Card card) {
		dealerCardPanel.add(new DrawableCard(card));	
		dealerLabelPanel.add(dealerLabel);
	}
	
	/**
	 * Updates the status label with the String passed.
	 */
	@Override
	public void setStatus(String text){
		statusLabel.setText(text);
	}
}
