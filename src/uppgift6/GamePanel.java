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
	private ArrayList<Card> playerCards;
	private ArrayList<Card> dealerCards;
	private JPanel playerCardPanel;
	private JPanel dealerCardPanel;
	private int playerScore;
//	private int dealerScore;
	private boolean gameOver = false;
	private JLabel dealerLabel;
	
	public GamePanel(){

		this.setLayout(new GridLayout(3, 1, 10, 10));
		
		
		
		
		
//		this.setSize(9999, 500);
//		this.setBackground(Color.black);
		playerScore = 0;
		dealerCardPanel = new JPanel();
		dealerCardPanel.setSize(9999, 110);
//		dealerCardPanel.add(cardPanel);
		playerCardPanel = new JPanel();
		playerCardPanel.setSize(9999, 110);
		
//		playerCardPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(dealerCardPanel, BorderLayout.NORTH);
		
		this.add(playerCardPanel, BorderLayout.CENTER);
		
		dealerLabel = new JLabel();
		dealerLabel.setText("HelloooooO!!!");
		this.add(dealerLabel, BorderLayout.SOUTH);
//		this.add(cardPanel, BorderLayout.CENTER);
		
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
		
	}
	
	@Override
	public void playerBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealPlayerCard(Card card) {
		
		System.out.println(card.toString());
		playerCards.add(card);
		
		CardPanel cardPanel = new CardPanel(playerCards);
		
		
		
		playerCardPanel.add(cardPanel, BorderLayout.SOUTH);

		playerCardPanel.repaint();

//		playerScore = 0;
//		for(Card c : playerCards){
//			playerScore += c.getRank();
//			
//			if(playerScore == 21){
//				System.out.println("You Win!");
//				gameOver();
//			}
//		}
//
//		System.out.println(playerScore);
	}
	
	@Override
	public void dealDealerCard(Card card) {
		
		System.out.println(card.toString());
		dealerCards.add(card);
		
		CardPanel cardPanel = new CardPanel(dealerCards);
		

		dealerCardPanel.add(cardPanel, BorderLayout.CENTER);

		
//		dealerCardPanel.validate();
		dealerCardPanel.repaint();

	}
	
	@Override
	public void setLabel(String text){
		dealerLabel.setText(text);
		dealerLabel.validate();
		dealerLabel.repaint();
		dealerCardPanel.repaint();
		playerCardPanel.repaint();

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
