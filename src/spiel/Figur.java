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
	private static final long serialVersionUID = 1L;
	private static boolean isDead = false;
	public static boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	}
