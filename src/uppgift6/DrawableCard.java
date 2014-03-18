package uppgift6;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Anders Lundholm
 *
 */
public class DrawableCard extends JLabel{
	
	DrawableCard(Card card){
		
		ImageIcon cardIcon = new ImageIcon("img/cards/" + (card.getIndex() + 1) + ".png");
		this.setIcon(cardIcon);
	}

}
