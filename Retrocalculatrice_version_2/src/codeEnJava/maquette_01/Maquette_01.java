package codeEnJava.maquette_01;

import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import codeEnJava.displays.Display;
import codeEnJava.keyboard.ConfigKeyboard;
import codeEnJava.keyboard.Grid2D;
import codeEnJava.keyboard.KeyBoard;

public class Maquette_01 implements ConfigKeyboard{

	public static void main(String[] args) {
		
		JFrame frame  = new JFrame("Calculatrice retro : maquette 01");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new FlowLayout(0,10,10));
		
		//Créer les deux displays
		
		Display display = new Display(NBDIGITS,SEVENSEGWIDTH);
		
		Display displayResult = new Display(NBDIGITS,SEVENSEGWIDTH);
		
		Display[] displays = {display,displayResult};
		
		display.setValue("0.0");
		displayResult.setValue("0.0");
		
		int grid2d_width  = 10;
		int grid2D_height = 10;
		
		int panel_width = COLUMNS*KEYWIDTH+4*grid2d_width;
		int panel_height = (int)(ROWS*KEYHEIGHT+6*grid2D_height+display.getDimDisplay().getHeight()+displayResult.getDimDisplay().getHeight());
		
		frame.pack();
		Insets insets = frame.getInsets();
		
		int frame_width = panel_width+insets.left+insets.right;
		int frame_height = panel_height+insets.top+insets.bottom;
		
		frame.setSize(frame_width,frame_height);
		
		Grid2D matrice = new Grid2D(14,16,grid2d_width,grid2D_height);
		
		KeyBoard keyboard = new KeyBoard(displays);
		
		
		matrice.setBackgroundColor("#1A2A3A");
		matrice.setBorderColor("#1A2A3A");
		
		
		matrice.put(display.get(), 1, 1, 12,1);
		matrice.put(displayResult.get(), 1, 3, 12,1);
		
		matrice.put(keyboard.getGrid2D(), 1, 5, 12,10);
		
		frame.add(matrice.getGrid2D());
		frame.setVisible(true);
		
	}

}
