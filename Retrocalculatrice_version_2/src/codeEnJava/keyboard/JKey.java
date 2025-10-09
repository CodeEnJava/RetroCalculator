package codeEnJava.keyboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import codeEnJava.displays.Display;

public class JKey extends MyJButton{

	private static final long serialVersionUID = 8914601348180507609L;
	private Display[] displays = null;
	private static boolean dpFlag = false;

	public JKey(Display[] dis,String val, int ... options) {
		super(val, options);
		this.displays = dis;
		String value = super.getValue();
		super.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("la touche -->"+value);
				
				// exemple de code pour injecter les datas vers le premier display
				
				if(value.charAt(0)>='0' && value.charAt(0)<='9')
					displays[0].add(value.charAt(0));
				
				// gestion du point décimal
				if(value.charAt(0)=='.' && !dpFlag) {
					displays[0].add(value.charAt(0));
					dpFlag= true;
				}
				
				// affichage des opérateurs de bases + - * /
				if((value.charAt(0)=='+' || value.charAt(0)=='-' || 
					value.charAt(0)=='÷' ||value.charAt(0)=='*') &&
					!(displays[0].getStr_val()).equals("0.0")) {
					
					displays[0].add(value.charAt(0));
					dpFlag= false;
				}
				
				
				// clear screen 0
				if(value.equals("CLS")) {
					displays[0].clear();
					displays[0].setValue("0.0");
				}
				
			}
			
	    });
	}

}
