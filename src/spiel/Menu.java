package spiel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	private JButton starten;
	private JButton settings;
	private JButton info;
	private JButton ende;
	//public static Start Start;
	static boolean level1 = false;
	
	public static void main(String[] args){
		Menu menu = new Menu("MENU");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(400, 400);
		
		menu.setLayout(null);
		menu.setVisible(true);
	}
	public Menu(String title){
		super(title);
		starten = new JButton("Spiel starten");
		starten.setBounds(120, 40, 160, 40);
		starten.addActionListener(this);
		add(starten);
		
		settings = new JButton("Einstellung");
		settings.setBounds(120, 120, 160, 40);
		settings.addActionListener(this);
		add(settings);
		
		info = new JButton("Info");
		info.setBounds(120, 200, 160, 40);
		info.addActionListener(this);
		add(info);
		
		ende = new JButton("Ende");
		ende.setBounds(120, 280, 160, 40);
		ende.addActionListener(this);
		add(ende);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == starten){
			start();
		}
		if(e.getSource() == info){
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "Programmiert von Timon & Musab !", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
		if(e.getSource() == settings){
			config();
		}
		if(e.getSource() == ende){
			System.exit(0);
		}
	}
	public static void start(){
		//JFrame start = new JFrame();
		//start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//start.setSize(550, 550);
		//start.setVisible(true);
		level1 = true;
		Start start1 = new Start();
		start1.neuesLevel("./src/level/level1.txt");
	}
	public static void config(){
		
	}
}
