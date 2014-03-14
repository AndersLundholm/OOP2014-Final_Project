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
//		this.setLayout(new GridLayout(2, 1, 10, 10));
		image = new ImageIcon("img/background.jpg");
		backgroundPanel = new BackgroundPanel(image);
		
		gamePanel = new GamePanel();
		
		
//		this.setContentPane(backgroundPanel);
//		cardPanel = new CardPanel();
//		this.add(backgroundPanel);
//		backgroundPanel.add(cardPanel);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(startNewGame);
		
		
		JButton drawCardsButton = new JButton("Take Card");
		drawCardsButton.addActionListener(drawCards);
		
		
		buttonPanel.add(drawCardsButton);
		buttonPanel.add(newGameButton);
		
		this.add(buttonPanel, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);

		this.setTitle("Black Jack!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
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
	
	private ActionListener drawCards = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			if(game != null){
				game.dealCards();
			} else {
				game = new Game(gamePanel);
				game.dealCards();
			}
			
		}
	};


}
