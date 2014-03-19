package uppgift6.game.gui;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import uppgift6.game.Card;

/**
 * JLabel that sets an image icon, to itself, 
 * of the passed card object. 
 * 
 * @author Anders Lundholm
 *
 */
public class DrawableCard extends JLabel{

	private static final long serialVersionUID = 1L;

	DrawableCard(Card card){		
		ImageIcon cardIcon = new ImageIcon("img/cards/" + (card.getIndex() + 1) + ".png");
		this.setIcon(cardIcon);
	}

}
