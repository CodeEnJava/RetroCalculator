package codeEnJava.keyboard;

import javax.swing.JFrame;

import fr.bs.dev.StringColor.StringColor;
import fr.bs.dev.input.Lecture;

public class ProcessMyJButton implements Runnable {

	private MyJButton button = null;
	private JFrame frame = null;
	
	
	
	
	public ProcessMyJButton(MyJButton button, JFrame frame) {
		super();
		this.button = button;
		this.frame = frame;
	}

	@Override
	public void run() {
		boolean runnable = true;
		
		while(runnable) {
			System.out.println(StringColor.stringColor("Communication vers un objet MyJButton", "#00FF00"));
			int width = Lecture.integerReader("Entrer la largeur du bouton : ", "#FF7F00");
			int height = Lecture.integerReader("Entrer la hauteur du bouton : ", "#FF7F00");
			int border = Lecture.integerReader("Entrer la valeur de la bordure : ", "#FF7F00");
			//int radius = Lecture.integerReader("Entrer la valeur du radius : ", "#FF7F00");
			//int pos_x = Lecture.integerReader("Entrer la valeur de x : ", "#FF7F00");
			//int pos_y = Lecture.integerReader("Entrer la valeur de y : ", "#FF7F00");
			String value = Lecture.stringReader("Entrer le nom de la touche", "\"#FF7F00\"", 1, 1);
			
			//float coef = (float) Lecture.doubleReader("La valeur du coeffient correctif", "#FF7F00");
			
			this.button.setMyBorder(border);
			this.button.setRadius(10);
			//this.button.setPos_x_text(pos_x);
			//this.button.setPos_y_text(pos_y);
			//this.button.setCoef(coef);
			this.button.setWidth(width);
			this.button.setHeight(height);
			this.button.setValue(value);
			frame.repaint();
		}

	}

}
