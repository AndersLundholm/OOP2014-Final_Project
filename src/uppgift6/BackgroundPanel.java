package uppgift6;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Anders Lundholm
 *
 */
public class BackgroundPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	
	public BackgroundPanel(ImageIcon image){
		this.setLayout(new BorderLayout());
		backgroundImage = image.getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g){
//		super.paintComponent(g);
		if(backgroundImage != null){
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		} else {
			System.out.println("No background image found!");
		}
	}
	
}
