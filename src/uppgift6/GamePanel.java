package uppgift6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
	private JLabel dealerLabel;
	
	public GamePanel(){

		this.setLayout(new BorderLayout());
		
		this.setSize(9999, 500);

		dealerCardPanel = new CardPanel(dealerCards);
		dealerCardPanel.setSize(9999, 110);
		playerCardPanel = new CardPanel(playerCards);
		playerCardPanel.setSize(9999, 110);
		
		this.add(dealerCardPanel, BorderLayout.NORTH);
		
		this.add(playerCardPanel, BorderLayout.CENTER);
		
		dealerLabel = new JLabel();
		dealerLabel.setText("Here be text!");
		this.add(dealerLabel, BorderLayout.SOUTH);
		
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
		dealerLabel.removeAll();
		dealerLabel.validate();
		dealerLabel.repaint();
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

		this.add(playerCardPanel, BorderLayout.CENTER);

		this.repaint();
	}
	
	@Override
	public void dealDealerCard(Card card) {
		
		System.out.println(card.toString());
		dealerCards.add(card);
		
		CardPanel dealerCardPanel = new CardPanel(dealerCards);

		this.add(dealerCardPanel, BorderLayout.CENTER);
		
		
		
		dealerCardPanel.validate();

		this.repaint();

	}
	
	@Override
	public void setLabel(String text){
		dealerLabel.setText(text);
//		dealerLabel.validate();
//		dealerLabel.repaint();
//		dealerCardPanel.repaint();
//		playerCardPanel.repaint();
		this.repaint();
	}


	@Override
	public void gameOver() {

		
	}

}
