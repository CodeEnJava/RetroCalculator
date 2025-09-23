package codeEnJava.keyboard_tests;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import codeEnJava.keyboard.MyJButton;
import codeEnJava.keyboard.ProcessMyJButton;

public class TestMyJButton {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("test de la classe MyJButton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLayout(new FlowLayout(0, 50, 50));
		
		MyJButton button1  = new MyJButton("+");
		
		MyJButton button2  = new MyJButton("0", 200,200);
		
		button1.setMyBorder(10);
		button1.setRadius(15);
		
		button1.setBackgroundColor("#ff0000");
		button1.setBackgroundHoveredColor("#00ff00");
		button1.setBackgroundPressedColor("#0000ff");
		
		button1.setBorderColor("#ffAA15");
		button1.setBorderHoveredColor("#15ffAA");
		button1.setBorderPressedColor("#30AAff");
		
		button1.setTextColor("#000000");
		
		button2.setMyBorder(20);
		button2.setRadius(60);
		
		button2.setBackgroundColor("#ff0000");
		button2.setBackgroundHoveredColor("#00ff00");
		button2.setBackgroundPressedColor("#0000ff");
		
		button2.setBorderColor("#ffAA15");
		button2.setBorderHoveredColor("#15ffAA");
		button2.setBorderPressedColor("#30AAff");
		
		button2.setTextColor("#000000");
		
		frame.add(button1);
		frame.add(button2);
		
		frame.repaint();
		frame.setVisible(true);
		
		ProcessMyJButton process = new ProcessMyJButton(button1, frame);
		Thread th = new Thread(process);
		
		th.start();
	}

}
