package spiel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Feld extends JLabel{
	
	public boolean level1 = false, wand = false;
	
	public Feld(ImageIcon imageIcon) {
		super(imageIcon);
	}

}
