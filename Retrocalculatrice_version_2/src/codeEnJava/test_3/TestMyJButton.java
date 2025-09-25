package codeEnJava.test_3;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import codeEnJava.keyboard.Grid2D;
import codeEnJava.keyboard.MyJButton;
import codeEnJava.keyboard.ProcessMyJButton;

public class TestMyJButton {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("test de la classe MyJButton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLayout(new FlowLayout(0, 50, 50));
		
		MyJButton button1  = new MyJButton("+",100,100);
		
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
		
		button2.setMyBorder(10);
		button2.setRadius(60);
		
		button2.setBackgroundColor("#ff0000");
		button2.setBackgroundHoveredColor("#00ff00");
		button2.setBackgroundPressedColor("#0000ff");
		
		button2.setBorderColor("#ffAA15");
		button2.setBorderHoveredColor("#15ffAA");
		button2.setBorderPressedColor("#30AAff");
		
		button2.setTextColor("#000000");
		
		
		Grid2D grid2d = new Grid2D(10, 5, 100, 100);
		
		grid2d.put(button1, 0, 1);
		grid2d.put(button2, 4, 2,3,2);
		
		frame.add(grid2d.getGrid2D());
		
		frame.repaint();
		frame.setVisible(true);
	}

}
