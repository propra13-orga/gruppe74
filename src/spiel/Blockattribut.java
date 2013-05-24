package spiel;

import javax.swing.ImageIcon;

public class Blockattribut {
	public static void boden(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/boden.gif"));
		Start.feld[xloc][yloc].wand = false;
	}
	public static void wand(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/wand.gif"));
		Start.feld[xloc][yloc].wand = true;
	}
	public static void level1(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/levelgate.gif"));
		Start.feld[xloc][yloc].wand = true;
		Start.feld[xloc][yloc].level1 = true;
	}
}
