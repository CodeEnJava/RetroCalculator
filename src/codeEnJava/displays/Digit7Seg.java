package codeEnJava.displays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import codeEnJava.tools.FontLoader;

public class Digit7Seg {
	
	private final int    WIDTHDIGIT              = 70;        // une largeur de 70 pixels pour une hauteur de 100 pixels
	private final int    MAXWIDTH                = 200;
	private final int    MINWIDTH                = 50;
	
	private final String DEFAULTCOLORSEGMENTS    = "#10EE05";
	private final String DEFAULTBACKBROUNDCOLOR  = "#000000";
	
	private int 		widthDigit 				 = 0;
	private int 		height     				 = 0;
	private int         fontSize                 = 0;
	private String 		value   				 = null; 	// la valeur est un chiffre ou 
	                               							// un chiffre avec un point décimal ou un opérateur mathématiques
	private String 		colorSegment 			 = null;
	private Color 		backgroundColor 		 = null;  // format RGB
	
	private JPanel 		panel 					 = null;
	private JLabel 		label                    = null;
	private Dimension 	dim						 = null;
	
	private Font		font                     = null;
	
	private static final int MARGIN_TOP          =  1 ;
	private static final int MARGIN_LEFT         = -3 ;
	private static final int DP_MARGIN_LEFT      =  4 ;
	
	private int 		margin_top				 = MARGIN_TOP; //px
	private int         margin_left				 = MARGIN_LEFT; //px
	private int         dp_marging_left          = DP_MARGIN_LEFT; //px
	
	
	public Digit7Seg(String root, int height) {
		
		this.colorSegment = DEFAULTCOLORSEGMENTS;
		this.backgroundColor = StrToCOlor(DEFAULTBACKBROUNDCOLOR);
		this.height = normalizeHeight(height);
		this.fontSize = this.height;
		
		this.font = FontLoader.getInstance(root).getFont();
		this.panel = new JPanel();
		this.label = new JLabel();
		
		this.setValue(" ")       ;// l'afficheur 7 segments n'est pas allumé
		
		this.ajusteSizeDigit7Segment();
		
		this.label.setFont(this.font);
		this.label.setOpaque(true);
		this.label.setBackground(this.backgroundColor);
		this.panel.add(this.label);
	}
	/**
	 * 
	 * @param height
	 * @return
	 */
	private int normalizeHeight(int height) {
		if(height<MINWIDTH)
			return MINWIDTH;
		if(height>MAXWIDTH)
			return MAXWIDTH;
		return height;
	}

	/**
	 * cette méthode permet de mettre à jour la dimenssion de l'afficheur en fonction de la hauteur
	 */
	private void ajusteSizeDigit7Segment() {
		this.widthDigit = (int)((this.height*WIDTHDIGIT)/100);
		this.dim = new Dimension(this.widthDigit, this.height);
		this.label.setSize(dim);
	}


	/**
	 * Cette méthode permet de convertir une expression couleur au format #AABBCC en format RGB(R,G,B)
	 * @param color
	 * @return	un Objet de type Color
	 */
	private Color StrToCOlor(String color) {
		if(color == null || !color.contains("#") || color.length()!=7)
			return Color.BLACK;
		else {
			
			int red = Integer.parseInt(color.substring(1, 3),16);
			int green = Integer.parseInt(color.substring(3, 5),16);
			int blue = Integer.parseInt(color.substring(5),16);
			return new Color(red,green,blue);
		}

	}
	/**
	 * Cette fonction indique si la valeur contient un point décimal
	 * @param val
	 * @return
	 */
	public static boolean containsDecimalPoint(String val) {
		return val.contains(".");
	}
	
	public void setValue(String val) {
		this.value = val;
		boolean flag_dp = containsDecimalPoint(val);
		this.setMargin(val.charAt(0),height,flag_dp);
		String str_value = String.format("""
											<html>
													<body style = '
													                font-size:%d;
													                color:%s;
													                margin-top:%d;
													                margin-left:%d
													               '>
													               %s
													</body>
											</html>
				
										 """, this.fontSize,
										      this.colorSegment,
										      this.margin_top,
										      flag_dp?this.dp_marging_left:this.margin_left,
										      this.value);
		this.label.setText(str_value);
	}

	/**
	 * 
	 * @param c
	 * @param height2
	 * @param dp
	 */
	private void setMargin(char c, int height2,boolean dp) {
		switch(c) {
		
			case '*':
			      this.setMargin_left(this.fn_left_prod(height2));
			      this.setMargin_top(this.fn_top_prod(height2));
			      this.setFontSize((int)(height2*0.9f));
			      break;
			case '+':
			      this.setMargin_left(this.fn_left_add(height2));
			      this.setMargin_top(this.fn_top_add(height2));
			      this.setFontSize((int)(height2*0.7f));
			      break;
			
			case '-':
			      this.setMargin_left(this.fn_left_sub(height2));
			      this.setMargin_top(0);
			      this.setFontSize((int)(height2*0.7f));
			      break;
			
			case '/':
			      this.setMargin_left(this.fn_left_div(height2));
			      this.setMargin_top(0);
			      this.setFontSize((int)(height2*0.7f));
			      break;
			      
			case '1':
					this.setMargin_top(1);
					this.setFontSize(height2);
					if(dp) {
						this.setDp_marging_left(fn_left_1(height2));
					}else
						this.setMargin_left(fn_left_1(height2));
					break;
				 
			case '3','7':
					this.setMargin_top(1);
					this.setFontSize(height2);
					if(dp) {
						this.setDp_marging_left(fn_dp_left_37(height2));
					}else
						this.setMargin_left(fn_left_37(height2));
				
				 break;
			
			case '9','8','6','5','4','2','0':
					this.setMargin_top(1);
					this.setFontSize(height2);
					if(dp) {
						this.setDp_marging_left(1);
					}else
						this.setMargin_left(1);
		      		break;
				 
			default:
				  this.setMargin_left(MARGIN_LEFT);
			      this.setMargin_top(MARGIN_TOP);
			      this.setFontSize(height2);
				
		}
		
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_top_prod(int x) {
		return (int)(0.5f*x+5);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_left_prod(int x) {
		return (int)(0.1763F*x-0.4779F);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_top_add(int x) {
		return (int)(-0.0003f*Math.pow(x, 2)-0.005f*x+0.9727f);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_left_add(int x) {
		return (int)(0.1262f*x-0.3971f);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_left_sub(int x) {
		return (int)(0.2082f*x-0.7206f);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_left_div(int x) {
		return (int)(0.1722f*x-0.2132f);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_dp_left_37(int x) {
		if(x<120)
			return (int)(0.0786f*x-0.8571f);
		return 9;
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_left_37(Integer x) {
		return switch(x) {
			case Integer y when y<80 -> {yield 3;}
			case Integer y when y>110 && y<140 -> {yield 8;}
			case Integer y when y>139 && y<170 -> {yield 9;}
			case Integer y when y>169 && y<200 -> {yield 10;}
			case Integer y when y>199 -> {yield 11;}
			default ->  {yield (int)(0.1f*x-4);}
		};
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private int fn_left_1(int x) {
		return (int)(0.3088f*x+1.8971f);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = normalizeHeight(height);
		this.ajusteSizeDigit7Segment();
	}
	
	

	public String getColorSegment() {
		return colorSegment;
	}

	public void setColorSegment(String colorSegment) {
		this.colorSegment = colorSegment;
		this.setValue(this.value);
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = StrToCOlor(backgroundColor);
		this.label.setBackground(getBackgroundColor());
	}

	public int getMargin_top() {
		return margin_top;
	}

	public void setMargin_top(int margin_top) {
		this.margin_top = margin_top;
	}

	public int getMargin_left() {
		return margin_left;
	}

	public void setMargin_left(int margin_left) {
		this.margin_left = margin_left;
	}

	public int getDp_marging_left() {
		return dp_marging_left;
	}

	public void setDp_marging_left(int dp_maring_left) {
		this.dp_marging_left = dp_maring_left;
	}
	
	
	public Dimension getDim() {
		return dim;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	
	
	public JPanel getPanel() {
		return panel;
	}
	
	public JLabel getDigit() {
		return this.label;
	}

	public String getValue() {
		return value;
	}
	
}
