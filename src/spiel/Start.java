package spiel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Start extends JPanel{
	
	Image img;
	
	/*public Start(){
		setFocusable(true);
		//ImageIcon u = new ImageIcon("./src/textures/boden.gif");
		//img = u.getImage();
		Figur f = new Figur();
	}*/
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0));
	public static Feld[][] feld = new Feld[11][11];
	public void neuesLevel(String level){
		String datei = "";
		FileReader r = null;
		try {
			r = new FileReader(level);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		BufferedReader b = new BufferedReader(r);
		String rows[] = new String [11];
		for(int i = 0; i <= 10; i++){
			try {
				rows[i] = b.readLine();
				datei = datei + rows[i];
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		try {
			r.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		char[] ch = datei.toCharArray();
		int x = 0, y = -1;
		for(int i = 0; i <= 120; i++){
			y++;
			if (y == 11){
				x++;
				y = 0;
			}
			switch(ch[i]){
			case '0':
				feld[x][y] = new Feld(new ImageIcon("./src/textures/wand.gif"));
				Blockattribut.wand(x, y);
				panel.add(feld[x][y]);
				break;
			case '1':
				feld[x][y] = new Feld(new ImageIcon("./src/textures/boden.gif"));
				Blockattribut.boden(x, y);
				panel.add(feld[x][y]);
				break;
			case '2':
				feld[x][y] = new Feld(new ImageIcon("./src/textures/levelgate.gif"));
				Blockattribut.level1(x, y);
				panel.add(feld[x][y]);
				break;
			}
		}
		frame.add(panel); // fuege das JPanel in das JFrame (panel -> frame)
		frame.setTitle("FIND-U-DRESS"); // setzte Fenstertitel
		frame.setSize(550, 550); // setzte Fenstergroesse
		frame.setLocationRelativeTo(null); // zentriere das Fenster
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setze den Exit Button (X) auf "EXIT_ON_CLOSE" um das Programm ordentlich zu beenden
		frame.setResizable(false); // ausschalten vom maximieren des Fensters
		frame.setVisible(true); // zeige das Fenster an
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
		 if (		Figur.isDead()==false &&
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
	
	//Grafik Hoch
	public void painth(Graphics g){
		super.paintComponent(g);
		int w = imgh.getWidth(this);
		int h = imgh.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgh,w,h,x,y,this);

		}}
	//Grafik Rechts
	public void paintr(Graphics g){
		super.paintComponent(g);
		int w = imgr.getWidth(this);
		int h = imgr.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgr,w,h,x,y,this);

		}}
	//Grafik Links
	public void paintl(Graphics g){
		super.paintComponent(g);
		int w = imgl.getWidth(this);
		int h = imgl.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgl,w,h,x,y,this);

		}}
	//Boden
	/*public void paint(Graphics g){
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
				
			}
		}
	}*/
	//Grafik Vorne
	public void paintv(Graphics g)
	{
		super.paintComponent(g);
		int w = imgv.getWidth(this);
		int h = imgv.getHeight(this);
		if (w > 0 && h > 0){
					Graphics2D f2 = (Graphics2D)g;
					f2.drawImage(imgv,w,h,this);
	}}
}