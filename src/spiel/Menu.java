package spiel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menu extends JFrame implements ActionListener{
	private JButton schliessen;
	private JButton settings;
	private JButton info;
	private JButton ende;
	
	public static void main(String[] args){
		menu menu = new menu("MENU");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(400, 400);
		
		menu.setLayout(null);
		menu.setVisible(true);
	}
	public menu(String title){
		super(title);
		schliessen = new JButton("Spiel starten");
		schliessen.setBounds(120, 40, 160, 40);
		schliessen.addActionListener(this);
		add(schliessen);
		
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
		if(e.getSource() == schliessen){
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
		JFrame start = new JFrame();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setSize(800, 600);
		start.setVisible(true);
		start.add(new Start());
	}
	public static void config(){
		
	}
}
