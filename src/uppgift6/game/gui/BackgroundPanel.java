package uppgift6.game.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Panel that sets the background image.
 * Constructor takes the passed ImageIcon
 * and draws it on this panel. 
 * 
 * @author Anders Lundholm
 *
 */
public class BackgroundPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	
	/**
	 * Sets the passed ImageIcon as background.
	 * 
	 * @param image the ImageIcon to be set as background.
	 */
	public BackgroundPanel(ImageIcon image){
		this.setLayout(new BorderLayout());
		backgroundImage = image.getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		if(backgroundImage != null){
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		} else {
			System.out.println("No background image found!");
		}
	}
	
}
