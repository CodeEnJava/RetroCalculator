package codeEnJava.test_1;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import codeEnJava.displays.Display;

public class TestKey {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test communication Key  -> display");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,600);
		frame.setLayout(null);
		
		int nb = 10;
		int height = 150;
		//int widthDigit = 50;
		
		Display display = new Display(nb,height);
		display.setValue("0.9999999");
		
		JPanel displayPanel = new JPanel();
		
		displayPanel.setSize(display.getWidth(), height);
		displayPanel.setMaximumSize(new Dimension(display.getWidth(), height));
		displayPanel.setMinimumSize(new Dimension(display.getWidth(), height));
		
		displayPanel.add(display.get());
		
		// créer le btn +
		KeyExample btnAdd = new KeyExample(200, 200, "+", display);
		btnAdd.getKey().setMyBorder(5);
		btnAdd.getKey().setRadius(25);
		
		btnAdd.getKey().setBackgroundColor("#FF00FF");
		btnAdd.getKey().setBackgroundHoveredColor("#7F007F");
		btnAdd.getKey().setBackgroundPressedColor("#DD7FDD");
		btnAdd.getKey().setTextColor("#483F8A");
		
		
		// créer le btn -
		KeyExample btnSub = new KeyExample(200, 200, "-", display);
		btnSub.getKey().setMyBorder(5);
		btnSub.getKey().setRadius(25);
		
		btnSub.getKey().setBackgroundColor("#FF00FF");
		btnSub.getKey().setBackgroundHoveredColor("#7F007F");
		btnSub.getKey().setBackgroundPressedColor("#DD7FDD");
		btnSub.getKey().setTextColor("#483F8A");
		
		// créer le btn Clear
		KeyExample btnClear = new KeyExample(150, 150, "C", display);
		btnClear.getKey().setMyBorder(20);
		btnClear.getKey().setRadius(150);
		
		btnClear.getKey().setBackgroundColor("#FF0000");
		btnClear.getKey().setBackgroundHoveredColor("#00FF00");
		btnClear.getKey().setBackgroundPressedColor("#0000FF");
		btnClear.getKey().setTextColor("#000000");
		
		frame.add(displayPanel);
		frame.add(btnAdd.getKey());
		frame.add(btnSub.getKey());
		frame.add(btnClear.getKey());
		
		displayPanel.setBounds(10,50,display.getWidth()+50,150); //800?
		btnAdd.getKey().setBounds(60,230,200,200);
		btnSub.getKey().setBounds(560,230,200,200);
		btnClear.getKey().setBounds(display.getWidth()+90,50,150,150);
		
		
		frame.setVisible(true);
	}

}
