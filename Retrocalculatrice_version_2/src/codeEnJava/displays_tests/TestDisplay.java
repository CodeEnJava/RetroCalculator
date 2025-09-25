package codeEnJava.displays_tests;

import java.awt.Dimension;

import javax.swing.JFrame;

import codeEnJava.displays.Display;
import codeEnJava.displays.ProcessDisplay;

public class TestDisplay {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int nb = 15;
		int height = 50;
		int widthDigit = 35;// cette valeur est fonction de la taille, mettre en place un modèle
		// pour une hauteur de 50  widthDigit = 35
		
		
		Display display = new Display(nb,height);
		
		JFrame frame = new JFrame("test display");
		
		frame.setUndecorated(true);
		
		frame.setSize(new Dimension(display.getWidth(),height));
		frame.add(display.getDisplay());
		
		frame.setLocation(200,700);
		frame.setVisible(true);
		display.setValue("0.0");
		//display.add('4');
		
		ProcessDisplay process = new ProcessDisplay(frame, display);
		Thread thD = new Thread(process);
		thD.start();
		
	}

}
