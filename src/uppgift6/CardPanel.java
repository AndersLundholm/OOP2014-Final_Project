package uppgift6;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author Anders Lundholm
 *
 */
public class CardPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public CardPanel(ArrayList<Card> cards){		
		this.setSize(9999, 110);
		this.cards = cards;
//		this.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	@Override
	public void paint(Graphics g){
//		super.paint(g);
//		this.setBackground(Color.blue);

		if(cards.size() > 0){
			y1 = 0;
			y2 = cards.get(0).getImage().getHeight(null);
			x1 = 200;
			x2 = 200 + cards.get(0).getImage().getWidth(null);
	
			for(Card card : cards){
				if(card.getImage() != null){
					g.drawImage(card.getImage(), x1, y1, x2, y2, 0, 0, 
							card.getImageWidth(), card.getImageHeight(), null);
					x1 += card.getImageWidth() + 10;  
					x2 += card.getImageWidth() + 10;		
				} else { 
					System.out.println("No image found!");
				}
			}		
		}
	}
}
