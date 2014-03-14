package uppgift6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Anders Lundholm
 *
 */
public class CardPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> cards = new ArrayList<Card>();
//	private Card card;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int row;

	public CardPanel(ArrayList<Card> cards, int row){
		
		this.setSize(1000, 500);
//		this.card = card;
		this.row = row;
		this.cards = cards;


		
//		x1 = 0;
//		x2 = cards.get(0).getImage().getWidth(null);
		
		
//		cards.add(card);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		y1 = 0;
		y2 = cards.get(0).getImage().getHeight(null);
		x1 = 0;
		x2 = cards.get(0).getImage().getWidth(null);

		for(Card card : cards){

					if(card.getImage() != null){
						
							g.drawImage(card.getImage(), x1, y1, x2, y2, 0, 0, card.getImage().getWidth(null), card.getImage().getHeight(null), null);
							x1 += card.getImage().getWidth(null) + 10;  
							x2 += card.getImage().getWidth(null) + 10;
							
						
					
					} else { 
						System.out.println("No image found!");
					}

			

			
		}
		
//		x1 -= (cards.get(0).getImage().getWidth(null)+10);
//		x2 -= (cards.get(0).getImage().getWidth(null)+10);
		
//		x1 -= (cards.get(0).getImage().getWidth(null)+10*cards.size()+1);
//		x2 -= (cards.get(0).getImage().getWidth(null)+10);
//		y1 -= 30;
//		y2 -= 30;
		
		
	}

}
