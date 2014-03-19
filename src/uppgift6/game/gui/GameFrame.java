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
		image = new ImageIcon("img/background.jpg");
		backgroundPanel = new BackgroundPanel(image);
		
		gamePanel = new GamePanel();
			
		this.setContentPane(backgroundPanel);
			
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setSize(9999, 50);
		buttonPanel.setBackground(new Color(0,0,0,0));
		
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
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private ActionListener startNewGame = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			backgroundPanel.repaint();
			game = new Game(gamePanel);
		}
	};
	
	private ActionListener hit = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(game != null && game.getStay() == false){
				backgroundPanel.repaint();
				game.dealPlayerCards();
			} 			
		}
	};
	
	private ActionListener stay = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(game != null && game.getStay() == false){
				backgroundPanel.repaint();
				game.dealerPlay();
			} 			
		}
	};
}
