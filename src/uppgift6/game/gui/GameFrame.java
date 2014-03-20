package uppgift6.game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uppgift6.game.Game;

/**
 * This frame is the main window.
 * Added to this frame is the GamePanel,
 * which contains the graphics for the game, 
 * and the ButtonPanel, which contains the buttons.
 *  
 * @author Anders Lundholm
 *
 */
public class GameFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private BackgroundPanel backgroundPanel;
	private GamePanel gamePanel;
	private ImageIcon image;
	private Game game;
	
	public GameFrame(){
		this.setLayout(new BorderLayout());
		image = new ImageIcon(getClass().getResource("/img/background.jpg"));
		backgroundPanel = new BackgroundPanel(image);
		
		gamePanel = new GamePanel();
			
		this.setContentPane(backgroundPanel);
			
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setSize(9999, 50);
		buttonPanel.setBackground(new Color(0,0,0,0));
		
		JButton newGameButton = new JButton("Deal");
		newGameButton.addActionListener(deal);
		
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
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Creates a new Game and passes the gamePanel object
	 * and then repaints the backgroundPanel to clear 
	 * old paintings.
	 */
	private ActionListener deal = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){	
			game = new Game(gamePanel);
			backgroundPanel.repaint();
		}
	};
	
	/**
	 * Checks if a Game object is created and that the 
	 * game is not stopped or that the player has selected
	 * to stay. Then deals a card to the player and then 
	 * repaints the backgroundPanel to clear old paintings.
	 */
	private ActionListener hit = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(game != null && game.getStay() == false && 
					game.getGameOver() == false){	
				game.dealPlayerCards();
				backgroundPanel.repaint();
			} 			
		}
	};
	
	/**
	 * Checks if a Game object is created and that the 
	 * game is not stopped or that the player has selected
	 * to stay. Then deals all the cards to the dealer and then 
	 * repaints the backgroundPanel to clear old paintings.
	 */
	private ActionListener stay = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(game != null && game.getStay() == false && 
					game.getGameOver() == false){	
				game.dealerPlay();
				backgroundPanel.repaint();
			} 			
		}
	};
}
