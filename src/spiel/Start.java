

package spiel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Start extends JPanel{

	Image img;
	
	public Start(){
		setFocusable(true);
		ImageIcon u = new ImageIcon("./src/textures/boden.gif");
		img = u.getImage();
		figur f = new figur();   
	}
	public int x = 1;
	public int y = 1;
	private ImageIcon h = new ImageIcon("./src/textures/hinten.gif");
	private ImageIcon v = new ImageIcon("./src/textures/vorne.gif");
	private ImageIcon r = new ImageIcon("./src/textures/rechts.gif");
	private ImageIcon l = new ImageIcon("./src/textures/links.gif");
	private Image imgh=h.getImage();
	private Image imgv=v.getImage();
	private Image imgr=r.getImage();
	private Image imgl=l.getImage();
	
	public void keyPressed(KeyEvent e)
	{
		 if (		figur.isDead()==false &&
			        e.getKeyCode() == KeyEvent.VK_UP ||
			        e.getKeyCode() == KeyEvent.VK_DOWN ||
			        e.getKeyCode() == KeyEvent.VK_LEFT ||
			        e.getKeyCode() == KeyEvent.VK_RIGHT)
			        {
			            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			               
			                x--;
			                //paintv();
			            }
			            else if (e.getKeyCode() == KeyEvent.VK_UP){
			                x++;
			                //painth();
			            }
			            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			                y--;
			                //paintl();
			            }
			            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			               y++;
			               //paintr();
			            }
			        }
	}
	
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	
	public void painth(Graphics g){
		super.paintComponent(g);
		int w = imgh.getWidth(this);
		int h = imgh.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgh,w,h,x,y,this);

		}}
	public void paintr(Graphics g){
		super.paintComponent(g);
		int w = imgr.getWidth(this);
		int h = imgr.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgr,w,h,x,y,this);

		}}
	public void paintl(Graphics g){
		super.paintComponent(g);
		int w = imgl.getWidth(this);
		int h = imgl.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgl,w,h,x,y,this);

		}}

	public void paint(Graphics g){
		super.paintComponent(g);
		int w = img.getWidth(this);
		int h = img.getHeight(this);
		if (w > 0 && h > 0){
			for(int x = 0;x < getWidth();x += w){
				for(int y = 0;y <getHeight(); y += h){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(img,x,y,w,h,this);
					f2.drawImage(imgr,0,0,this);
				}
			}
		/**	if (e.getKeyCode == KeyEvent.VK_UP)
			{
				
			}**/
		}
	}
	public void draw(Graphics g)
	{
		super.paintComponent(g);
		int w = imgr.getWidth(this);
		int h = imgr.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgr,w,h,this);
	}}
}
