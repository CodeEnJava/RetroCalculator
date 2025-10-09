package codeEnJava.test_4;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import codeEnJava.keyboard.KeyBoard;

public class TestKeyBoard {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test KeyBoard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(0, 50, 50));
		frame.setSize(350,300);
		
		KeyBoard keyboard = new KeyBoard(null);
		frame.add(keyboard.getGrid2D());
		
		frame.setVisible(true);
	}

}
