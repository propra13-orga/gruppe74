package spiel;

import java.awt.*;
import javax.swing.*;

public class Start extends JPanel{

	Image img;
	
	public Start(){
		setFocusable(true);
		ImageIcon u = new ImageIcon("./src/textures/boden.gif");
		img = u.getImage();
	}

	public void paint(Graphics g){
		super.paintComponent(g);
		int w = img.getWidth(this);
		int h = img.getHeight(this);
		if (w > 0 && h > 0){
			for(int x = 0;x < getWidth();x += w){
				for(int y = 0;y <getHeight(); y += h){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(img,x,y,w,h,this);
				}
			}
		}
	}
}
