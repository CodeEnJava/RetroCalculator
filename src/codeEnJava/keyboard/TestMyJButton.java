package codeEnJava.keyboard;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class TestMyJButton {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("test de la classe MyJButton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);
		frame.setLayout(new FlowLayout(0, 50, 50));
		
		MyJButton button  = new MyJButton("0", 100,100);
		
		button.setMyBorder(20);
		button.setRadius(35);
		
		button.setBackgroundColor("#ff0000");
		button.setBackgroundHoveredColor("#00ff00");
		button.setBackgroundPressedColor("#0000ff");
		
		button.setBorderColor("#ffAA15");
		button.setBorderHoveredColor("#15ffAA");
		button.setBorderPressedColor("#30AAff");
		
		button.setTextColor("#000000");
		
		frame.add(button);
		
		frame.repaint();
		frame.setVisible(true);
		
		ProcessMyJButton process = new ProcessMyJButton(button, frame);
		Thread th = new Thread(process);
		
		th.start();
	}

}
