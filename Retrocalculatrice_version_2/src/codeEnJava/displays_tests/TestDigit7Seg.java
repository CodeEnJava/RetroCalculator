package codeEnJava.displays_tests;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import codeEnJava.displays.Digit7Seg;
import codeEnJava.displays.Process7segments;

public class TestDigit7Seg {

	public static void main(String[] args) {
		String root ="/Users/steph.barois.dev/Desktop";
		
		Digit7Seg digit_1 = new Digit7Seg(root, 200);
		Digit7Seg digit_2 = new Digit7Seg(root, 200);
		
		digit_1.setValue("0.");
		digit_2.setValue("7.");
		
		Digit7Seg[] tabDigit = new Digit7Seg[2];
		tabDigit[0] = digit_1;
		tabDigit[1] = digit_2;
	
		//digit.setBackgroundColor("#AAAAAA");
		//digit.setColorSegment("#FF0000");
		
		JPanel panel = new JPanel(new GridLayout(1,2,2,2));
		
		panel.add(tabDigit[0].getDigit());
		panel.add(tabDigit[1].getDigit());
		
		
		JFrame frame = new JFrame("test digit 7 segments");
		frame.setUndecorated(true);
		frame.add(panel);
		
		frame.setSize(new Dimension(tabDigit[0].getDim().width*2,(int) (tabDigit[0].getDim().height*1.1f)));
		
		frame.setLocation(1300,300);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Process7segments process = new Process7segments(frame, tabDigit);
		
		Thread thread_process = new Thread(process);
		
		thread_process.start();
	}

}
