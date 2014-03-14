package uppgift6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Anders Lundholm
 *
 */
public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private BackgroundPanel backgroundPanel;
//	private CardPanel cardPanel;
	private GamePanel gamePanel;
	private ImageIcon image;
	private Game game = null;
	
	
	public MainFrame(){
		this.setLayout(new BorderLayout());
		image = new ImageIcon("img/background.jpg");
		backgroundPanel = new BackgroundPanel(image);
		
		gamePanel = new GamePanel();
		
		
//		this.setContentPane(backgroundPanel);
//		cardPanel = new CardPanel();
//		this.add(backgroundPanel);
//		backgroundPanel.add(cardPanel);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setSize(9999, 50);
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(startNewGame);
		
		JButton hitButton = new JButton("Hit");
		hitButton.addActionListener(hit);
		
		JButton stayButton = new JButton("Stay");
		stayButton.addActionListener(stay);
		
		buttonPanel.add(newGameButton);
		buttonPanel.add(hitButton);
		buttonPanel.add(stayButton);
		
		
		this.add(gamePanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setTitle("Black Jack!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
//		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private ActionListener startNewGame = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			game = new Game(gamePanel);
		}
	};
	
	private ActionListener hit = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(game != null && gamePanel.getPlayerScore() < 21){
				game.dealPlayerCards();
			} 			
		}
	};
	
	private ActionListener stay = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(gamePanel != null){
				gamePanel.stay();
				game.dealDealerCards();
			} 			
		}
	};


}
