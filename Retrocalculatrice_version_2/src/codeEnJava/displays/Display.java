package codeEnJava.displays;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Display {
	
	private Digit7Seg[] tabDigit   = null;
	private int nbDigit            = 0;
	private int height             = 0;
	
	private JPanel display         = null;
	private String str_val         = null;
	
	// modifications
	private int width;// largeur du display
	private Dimension dimDisplay  = null;
	
	public Display(int nbdigit, int height) {
		super();
		//ici modif exceptionnelle, j'utilise un PC Windows
		//String root ="C:\\Users\\stebar\\Documents\\";// chemin pour le mac  --->"/Users/steph.barois.dev/Desktop";
		String root ="/Users/steph.barois.dev/Desktop";
		if(nbdigit<1)
			this.nbDigit = 1;
		else
			this.nbDigit= nbdigit;
		
		
		this.height= height;
		this.tabDigit = new Digit7Seg[this.nbDigit];
		this.display = new JPanel(new GridLayout(1,this.nbDigit,0,0));
		
		for(int i = this.nbDigit-1;i>=0;i--) {
			this.tabDigit[i] = new Digit7Seg(root, height);
			this.display.add(this.tabDigit[i].getDigit());
		}
		
		// modifications 
		this.width = (int)((this.tabDigit[0].getDim()).getWidth()*this.nbDigit);
		// imposer la taille fixe pour le display
		this.dimDisplay = new Dimension(this.width,this.height);
		display.setPreferredSize(dimDisplay);	
		display.setMinimumSize(dimDisplay);
		display.setMaximumSize(dimDisplay);
	}
	
	
	private static int nbDP(String val) {
		int nb = 0;
		for(int i=0; i<val.length();i++) {
			if(val.charAt(i)=='.')
				nb++;
		}
		return nb;
	}
	
	public void setValue(String strval) {
		// il faudra prévoir une sécurité ou une astuce si la longueur de la chaine
		// strval est supérieure au nombre de digits ......
		
		this.str_val = strval;
		
		int len_str_digit = this.str_val.length()-nbDP(this.str_val);
		
		int jump = 0 ; // saut si on trouve un dp
		int pt   = 0 ; // pointeur pour parcourir chaque caractère de la chaine str_val
		int next = 0 ; // pointeur pour le caractère suivant
		
		while(pt<this.str_val.length()) {
			next = pt +1;
			if(this.str_val.charAt(pt)!='.') {
			  tabDigit[len_str_digit-1-pt+jump].setValue(""+this.str_val.charAt(pt));
			  
			}
			//traitement du suivant
			if(pt<this.str_val.length()-1 && this.str_val.charAt(next)=='.') {
				tabDigit[len_str_digit-1-pt+jump].setValue(this.str_val.substring(pt, pt+2));
				jump++;
				pt++;
			}
			pt++;
		}
		
	}

    public void add(char c) {
    	if(this.str_val ==  null || this.str_val.equals("0.0"))
    		this.str_val=" "+c;
    	else
    		this.str_val +=(""+c);
    	
    	this.setValue(str_val);
    }

	public String getStr_val() {
		return str_val;
	}



	public void setStr_val(String str_val) {
		this.str_val = str_val;
	}



	public JPanel getDisplay() {
		return display;
	}
	
	public JPanel get() {
		return this.display;
	}

	
	
	// modification : ajout des méthodes
	public void clear() {
		for(int i=this.nbDigit-1;i>=0;i--) {
			this.tabDigit[i].setValue(" ");
		}
	}

	public int getWidth() {
		return width;
	}
	
	public Dimension getDimDisplay() {
		return dimDisplay;
	}

	
}
