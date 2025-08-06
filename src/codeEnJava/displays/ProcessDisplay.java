package codeEnJava.displays;

import javax.swing.JFrame;

import fr.bs.dev.StringColor.StringColor;
import fr.bs.dev.input.Lecture;

public class ProcessDisplay implements Runnable{
	
	
	private JFrame  frame    = null;
	private Display display  = null;
	
	public ProcessDisplay(JFrame fr,Display dis) {
		super();
		this.frame = fr;
		this.display = dis;
	}
	
	
	
	

	@Override
	public void run() {
		boolean runnable = true;
		
		while(runnable) {
			
			System.out.println(StringColor.stringColor("Communication vers le display ", "#41F5F0"));
			String strval = Lecture.stringReader("Entrer la valeur à injecter dans le display ", "#E7B162", 1, 1);
			
			if(isValide(strval.charAt(0))) {
				
				if(strval.charAt(0)=='=') {
					System.out.println(StringColor.stringColor("Fin de la saisie et lancement du process ", "#41F5F0"));
					runnable = false;
					frame.dispose();
				}
				
				display.add(strval.charAt(0));
				frame.repaint();
			}else {
				System.out.println(StringColor.stringColor("Erreur dans la saisie ", "#FA0707"));
			}
			
			
		}
		
	}
	
	private boolean isValide(Character c) {
		return switch(c) {
		case Character car when car.charValue()>='0' && car.charValue()<='9'
				                || car.charValue()=='/' || car.charValue()=='*'
				                || car.charValue()=='-' || car.charValue()=='+'	
				                || car.charValue()=='.' || car.charValue()=='=' ->{yield true;}
	    default -> {yield false;}
		};
	}
	

}
