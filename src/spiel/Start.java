package spiel;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Start extends JPanel implements KeyListener{
	
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
	private Figur f = new Figur();
	
	
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
			case '3':
				feld[x][y] = new Feld(new ImageIcon("./src/textures/rechts.gif"));
				f.setx(x);
				f.sety(y);
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
		frame.setFocusable(true);
		frame.addKeyListener(this);
	}
	
	

	
	public void keyPressed(KeyEvent e)
	{			
	
		 if (		Figur.isDead()== false &&
			        e.getKeyCode() == KeyEvent.VK_UP ||
			        e.getKeyCode() == KeyEvent.VK_DOWN ||
			        e.getKeyCode() == KeyEvent.VK_LEFT ||
			        e.getKeyCode() == KeyEvent.VK_RIGHT)
			        {
				int xpos = f.getx();
				 int ypos = f.gety();
			            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			            	if (feld[xpos--][ypos].wand = false)
			            	{
			            	feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/boden.gif"));
							Blockattribut.boden(xpos, ypos);
							panel.add(feld[xpos][ypos]);
			                xpos--;
			                f.setx(xpos);
			                feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/vorne.gif"));
							panel.add(feld[xpos][ypos]);
							System.out.println("Die Position der Figur ist: " + f.getx() + "/" + f.gety());
			            	}
			            }
			            else if (e.getKeyCode() == KeyEvent.VK_UP){
			            	if (feld[xpos++][ypos].wand = false)
			            	{
			            	feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/boden.gif"));
							Blockattribut.boden(xpos, ypos);
							panel.add(feld[xpos][ypos]);
			                xpos++;
			                f.setx(xpos);
			                feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/hinten.gif"));
							panel.add(feld[xpos][ypos]);
							System.out.println("Die Position der Figur ist: " + f.getx() + "/" + f.gety());
			            	}
			            }
			            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			            	if (feld[xpos][ypos--].wand = false)
			            	{
			            	feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/boden.gif"));
							Blockattribut.boden(xpos, ypos);
							panel.add(feld[xpos][ypos]);
			                ypos--;
			                f.sety(ypos);
			                feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/links.gif"));
							panel.add(feld[xpos][ypos]);
							System.out.println("Die Position der Figur ist: " + f.getx() + "/" + f.gety());
			            	}
			            }
			            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			            	if (feld[xpos][ypos++].wand = false)
			            	{
			            	feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/boden.gif"));
							Blockattribut.boden(xpos, ypos);
							panel.add(feld[xpos][ypos]);
			                ypos++;
			                f.sety(ypos);
			                feld[xpos][ypos] = new Feld(new ImageIcon("./src/textures/rechts.gif"));
							panel.add(feld[xpos][ypos]);
							System.out.println("Die Position der Figur ist: " + f.getx() + "/" + f.gety());
			            	}
			            }
			        }
		}
	
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
}