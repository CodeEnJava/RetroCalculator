package codeEnJava.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFontLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String root ="/Users/steph.barois.dev/Desktop";
		
		Font font1 = FontLoader.getInstance(root).getFont();
		Font font2 = FontLoader.getInstance(root).getFont();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		JLabel label1 = new JLabel("0123456789 / * - + .");
		JLabel label2 = new JLabel("0123456789 / * - + .");
		
		label1.setFont(font1);
		label2.setFont(font2);
		
		
		label1.setOpaque(true);
		label2.setOpaque(true);
		
		label1.setBackground(Color.BLACK);
		label2.setBackground(Color.BLACK);
		
		label1.setForeground(Color.GREEN);
		label2.setForeground(Color.RED);
		
		panel.add(label1,BorderLayout.NORTH);
		panel.add(label2,BorderLayout.SOUTH);
		
		JFrame frame = new JFrame("Test de la classe FONTLOADER");
		
		frame.add(panel);
		
		frame.setMaximumSize(new Dimension(600,200));
		frame.setMinimumSize(new Dimension(600,200));
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
