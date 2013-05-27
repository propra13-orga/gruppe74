/**
 * Autor: Timon G�nther
 * Letzte Aktualisierung: 21.05.2013
 */

package spiel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Figur extends JPanel{
	
/**
	 * 
	 */
	private static boolean isDead = false;
	public int xpos;
	public int ypos;
	
	
	public static boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public void setx(int x){
	xpos = x;
	}
	
	public void sety(int y){
		ypos = y;
	}
	
	public int getx(){
		return xpos;
	}
	public int gety(){
		return ypos;
	}
	}
