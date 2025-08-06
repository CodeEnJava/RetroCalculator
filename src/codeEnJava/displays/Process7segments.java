package codeEnJava.displays;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import fr.bs.dev.StringColor.StringColor;
import fr.bs.dev.input.Lecture;

@SuppressWarnings("unused")
public class Process7segments implements Runnable{
	
	private JFrame frame = null;
	Digit7Seg[] digit = null;
	
	
	public Process7segments(JFrame fr, Digit7Seg[] digit) {
		this.frame = fr;
		this.digit = digit;
	}

	@Override
	public void run() {
		boolean runnable= true;
		while(runnable) {
			
			System.out.println(StringColor.stringColor("Communication vers l'afficheur", "#00FF7F"));
			
			String strVal = Lecture.stringReader("Entrer la valeur à afficher : ", "#FF7F00", 1, 2);
			
			this.digit[1].setValue(strVal); // injection du caractère vers l'afficheur
			this.frame.repaint();  // mettre à jour les composants dans la frame
		    /*
			System.out.println(StringColor.stringColor("Modification des attributs ", "#00FF7F"));
			
			int height = Lecture.integerReader("Entrer la hauteur de  l'afficheur : ", "#00FF00");
			int fontsize = Lecture.integerReader("Entrer la taille de la font : ", "#00FF00");
			
			int top = Lecture.integerReader("Entrer la marge haute (top) : ", "#00FF00");
			int left = Lecture.integerReader("Entrer la marge gauche (left) : ", "#00FF00");
			
			digit[1].setFontSize(fontsize);
			digit[1].setHeight(height);
			
			
			digit[0].setHeight(height);
			digit[0].setFontSize(fontsize);
			
			if(strVal.contains("."))
				digit[1].setDp_marging_left(left);
			else
				digit[1].setMargin_left(left);
			
			digit[1].setMargin_top(top);
			
			// la marge si dp
			
			
			this.digit[1].setValue(strVal); // injection du caractère vers l'afficheur
			this.digit[0].setValue("0."); // injection du caractère vers l'afficheur
			*/
			frame.setSize(new Dimension((int) (digit[0].getDim().width*2.f),(int) (digit[0].getDim().height*1.0f)));
			//frame.setSize(new Dimension(80,(int) (digit[0].getDim().height*1.75f)));
			System.out.println(frame.getSize().toString());
			this.frame.repaint();  // mettre à jour les composants dans la frame
		    
			
		}
		
	}

}
