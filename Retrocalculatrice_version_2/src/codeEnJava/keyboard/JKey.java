package codeEnJava.keyboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import codeEnJava.displays.Display;

public class JKey extends MyJButton{

	private static final long serialVersionUID = 8914601348180507609L;
	private Display[] displays = null;
	private static boolean flagDp = false;

	public JKey(Display[] dis,String val, int... options) {
		super(val, options);
		this.displays = dis;
		String value = super.getValue();
		
		super.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("valeur du bouton :"+value);
				//---------------------------------------------------
				// rediriger la saisi des nombres vers le display N°1
				if(value.charAt(0)>='0' && value.charAt(0)<='9')
					displays[0].add(value.charAt(0));
				//---------------------------------------------------
				
				// gestion du point décimal
				if(value.charAt(0)=='.' && !flagDp) {
					displays[0].add(value.charAt(0));
					flagDp = true;
				}
				
				// rediriger la saisi des opérateurs vers le display N°1 et réinitialiser
				// l'utilisation du point décimal
				if(value.charAt(0)=='+' || 
				   value.charAt(0)=='-'|| 
				   value.charAt(0)=='*'|| 
				   value.charAt(0)=='÷') {
					displays[0].add(value.charAt(0));
					flagDp = false;
				}
				// Effacer le contenu du display N°1
				if(value.equals("CLS")){
					displays[0].clear();
					displays[0].setValue("0.0");
			    }
			}
		});
	}

}
