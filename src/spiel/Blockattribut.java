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
	public static void figurv(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/vorne.gif"));
		Start.feld[xloc][yloc].wand = false;
	}
	public static void figurh(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/hinten.gif"));
		Start.feld[xloc][yloc].wand = false;
	}
	public static void figurr(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/rechts.gif"));
		Start.feld[xloc][yloc].wand = false;
	}
	public static void figurl(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon("./src/textures/links.gif"));
		Start.feld[xloc][yloc].wand = false;
	}
	public static void stacheln(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon(".src/textures/stachelngif.gif"));
		Start.feld[xloc][yloc].wand = false;
		Start.feld[xloc][yloc].stacheln = true;
	}
	public static void ausgang(int xloc, int yloc){
		Start.feld[xloc][yloc].setIcon(new ImageIcon(".src/textures/ausgang.gif"));
		Start.feld[xloc][yloc].wand = false;
		Start.feld[xloc][yloc].ausgang = true;
	}
}
