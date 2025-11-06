package codeEnJava.keyboard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MyJButton extends JButton implements ConfigKeyboard{

	private static final long serialVersionUID = 6754909011912247331L;
	// les attributs de l'objet MyjButton
	private Font font 					 = null;
	private int  height;
	private int  width;
	private int  radius;
	private int  border;
	
	private int pos_x_text = 0;// modif avant 14
	private int pos_y_text = 0;// modif avant 29
	
	private Color backgroundColor 		 = null;
	private Color backgroundHoveredColor = null;
	private Color backgroundPressedColor = null;
	
	private Color borderColor 			 = null;
	private Color borderHoveredColor 	 = null;
	private Color borderPressedColor 	 = null;
	
	private Color textColor      		 = null;
	private Color textHoveredColor       = null;
	private Color textPressedColor       = null;
	
	private boolean pressed              = false;
	private boolean hovered              = false;
	
	// modif ajouter 
	private boolean released             = true;
	
	private String value                 = null;
	
	// ajouté
	private MouseListener listener       = null;
	
	// pour les tests et mesures
	//private  float coef = 1.0f;
	
	// mise en place du constructeur
	
	/**
	 * Constructeur
	 * si le deuxième paramètre existe, on fixe la largeur
     * si le troisième paramètre existe, on fixe la hauteur
     * si le quatrième paramètre existe, on fixe le radius 
     * si le cinquième paramètre existe, on fixe la épaisseur de la bordure
     * 
     * 
     * if the second parameter exists, set the width
	 * if the third parameter exists, set the height
     * if the fourth parameter exists, set the radius 
     * if the fifth parameter exists, set the border thickness
	 * 
	 * @param val
	 * @param options
	 */
	public MyJButton(String val,int ...options) {
		super();
		
		this.width  				= options.length>0?options[0]: WIDTH_DEFAULT;
		this.height 				= options.length>1?options[1]: HEIGHT_DEFAULT;
		this.radius 				= options.length>2?options[2]: RADIUS_DEFAULT;
		this.border 				= options.length>3?options[3]: BORDER_DEFAULT;
		
		this.backgroundColor        = StrToColor(BACKGROUND_COLOR_DEFAULT);
		this.backgroundHoveredColor = StrToColor(BACKGROUND_HOVER_COLOR_DEFAULT);
		this.backgroundPressedColor = StrToColor(BACKGROUND_PRESSED_COLOR_DEFAULT);
		
		this.borderColor            = StrToColor(BORDER_COLOR_DEFAULT);
		this.borderHoveredColor 	= StrToColor(BORDER_HOVER_COLOR_DEFAULT);
		this.borderPressedColor 	= StrToColor(BORDER_PRESSED_COLOR_DEFAULT);
		
		this.textColor 				= StrToColor(TEXT_COLOR_DEFAULT);
		this.textHoveredColor 		= StrToColor(TEXT_HOVER_COLOR_DEFAULT);
		this.textPressedColor 		= StrToColor(TEXT_PRESSED_COLOR_DEFAULT);
		
		this.setValue(val);
		this.setSize();
		
		this.setMyBorder(border);
		
		super.setFocusable(false);
		super.setContentAreaFilled(false);
	}
	
	
	/**
	 * Cette méthode permet de definir la taille du bouton et la rendre non modifiable
	 * This method allows you to set the button size and make it non-editable.
	 */
	private void setSize() {
		super.setPreferredSize(new Dimension(this.width,this.height));
		super.setMinimumSize(new Dimension(this.width,this.height));
		super.setMaximumSize(new Dimension(this.width,this.height));
	}
	
	/**
	 * Cette méthode permet de mettre en place l'écouteur sur les évènements de la souris
	 * This method allows you to set up the listener on mouse events.
	 */
	private void mouseListener() {
		listener = new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				hovered = true;
				repaint();
			}
			
			public void mouseExited(MouseEvent e){
				hovered = false;
				repaint();
			}
			
			public void mousePressed(MouseEvent e){
				pressed = true;
				released = false;
				repaint();
			}
			
			public void mouseReleased(MouseEvent e){
				pressed = false;
				released = true;
				repaint();
			}
			
		};
		super.addMouseListener(listener);
		revalidate();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Color currentBackgroundColor 	= pressed?backgroundPressedColor:(hovered? backgroundHoveredColor:backgroundColor);
		Color currentBorderColor 		= pressed?borderPressedColor:(hovered? borderHoveredColor:borderColor);
		Color currentTextColor 			= pressed?textPressedColor:(hovered? textHoveredColor:textColor);
		
		Graphics2D g2 = (Graphics2D)g;
		// -1  placer la surface pour préparer la bordure
		// -1  place the surface to prepare the border
		g2.setColor(currentBorderColor);
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		
		// -2  placer la surface pour préparer l'arrière plan
		// -2  place the surface to prepare the background
		g2.setColor(currentBackgroundColor);
		
		g2.fillRoundRect(border, border, width-2*border, height-2*border, radius, radius);
		
		// -3 placer le texte au dessus
		// -3 place the text above
		g2.setColor(currentTextColor);
		
		FontMetrics fm = g2.getFontMetrics();
		int textWidth = fm.stringWidth(value);
		int textHeight = fm.getHeight();
		
		g2.drawString(this.value, -pos_x_text+(width-textWidth)/2, 
				      pos_y_text+(height/2+textHeight)/2);
		
		g2.dispose(); // on libère la ressource :we release the resource
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		// Permet de supprimer la bordure native du composant ( Ici le JButton)
		// Allows you to remove the native border of the component (in this case, the JButton).
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(255,255,255,0));
		g2.setStroke(new BasicStroke(1));
		g2.drawRoundRect(0, 0, width-1, height-1, radius, radius);
		g2.dispose();
	}
	
	
	/**
	 * Cette méthode permet de convertir une expression couleur au format #AABBCC en format RGB(R,G,B)
	 * 
	 * This method converts a color expression in #AABBCC format to RGB(R,G,B) format.
	 * 
	 * @param color
	 * @return	un Objet de type Color
	 */
	private Color StrToColor(String color) {
		if(color == null || !color.contains("#") || color.length()!=7)
			return Color.BLACK;
		else {
			
			int red = Integer.parseInt(color.substring(1, 3),16);
			int green = Integer.parseInt(color.substring(3, 5),16);
			int blue = Integer.parseInt(color.substring(5),16);
			return new Color(red,green,blue);
		}
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		this.setMyBorder(this.border);
		this.setSize();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		this.setMyBorder(this.border);
		this.setSize();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getMyBorder() {
		return border;
	}

	/**
	 * 
	 * @param border
	 */
	public void setMyBorder(int border) {
		this.border = border;
		//modif 2
		//on fixe la valeur max de la bordure à 30% du min(width,height)
		this.border = (int) (this.border>Math.min(this.width, this.height)*0.3f?
				             Math.min(this.width, this.height)*0.3f:this.border);
		
		if(this.value.length()==1 && !(this.value.charAt(0)>='A' && this.value.charAt(0)<='Z'))
			font = new Font("Arial",Font.PLAIN,
				        (int)(Math.min(height-2*border, width-2*border)*(1.0f)));
		else {
			System.out.println("char value = "+this.value);
			font = new Font("Arial",Font.PLAIN,(int)(Math.min(height-2*border, width-2*border)*(1.0f)/2.5));
			this.pos_y_text = (int)((height-2*border)/4);
			this.mouseListener();
			this.repaint();
			return;
		}
		super.setFont(font); 
		
		
				
		Integer heightWidth = (int)Math.min(this.width, this.height);
		Character car = this.value.charAt(0);
		System.out.println("car ="+car);
		switch(car) {
		
			case Character c when (c.charValue()>='0' && c.charValue()<='9') 
			                       || c.charValue() =='%' 
			                       || c.charValue()=='.'||
			                    	  c.charValue()=='(' ||
									  c.charValue()==')'->{
				function_y_pos_number(heightWidth);
				break;
				}
			
			case Character c when (c.charValue()=='(' ||
				                   c.charValue()==')')->{
					  function_y_pos_number((int)(heightWidth));
					  break;
				  }
			
			case Character c when c.charValue()=='*' ->{
				this.pos_y_text=13;//prévoir tests en fonction de la hauteur: valeur avant modif 26
				break;
			}
			
			case Character c when c.charValue()=='+' || 
					              c.charValue()=='=' ->{
				function_y_pos_plus_sign(heightWidth);
				break;
			}
			
			case Character c when c.charValue()=='-' ->{
				function_y_pos_minus_sign(heightWidth);
				break;
			}
			
			case Character c when c.charValue()=='/' || 
					              c.charValue()=='÷' ||
					              c.charValue()=='±' ->{
				function_y_pos_div_sign( heightWidth);
				break;
			}
			
		default -> throw new IllegalArgumentException("Unexpected value: " + car);
		}
		
		
	    
	    if(height > width) {
	    	float coef = function_coef();
	    	System.out.println("coef ="+coef);
	    	this.pos_y_text = this.pos_y_text+(int)(width/coef);
	    }
	    
	    this.mouseListener();
		this.repaint();
	}
	
	/**
	 * Fonction pour calculer le décalage de l'axe Y pour les chiffres
	 * @param heightWidth
	 */
	private void function_y_pos_number(Integer heightWidth) {
		this.pos_y_text = switch(heightWidth) {
			case Integer i when i.intValue()<200 ->{
				yield (int)(0.4714f*this.border+1.5f);
			}
			case Integer i when  i.intValue()<300 ->{
				yield (int)(0.4319f*this.border+5.1209f);	
			}
			case Integer i when  i.intValue()<400 ->{
				yield (int)(0.4225f*this.border+8.7451f);
			}
			default ->{
				yield (int)(0.4471f*this.border+9.6471f);
			}
		};
	}
	/**
	 * Fonction pour calculer le décalage de l'axe Y pour le signe de soustraction
	 * @param heightWidth
	 */
	private void function_y_pos_minus_sign(Integer heightWidth) {
		this.pos_y_text = switch(heightWidth) {
			case Integer i when i.intValue()<200 ->{
				yield (int)(0.6f*this.border-4.8571f);
			}
			case Integer i when  i.intValue()<300 ->{
				yield (int)(0.5273f*this.border-9.3636f);	
			}
			case Integer i when  i.intValue()<400 ->{
				if(border<=60)
					yield (int)(0.4f*this.border-20.0f);
				yield (int)(0.6667*this.border-32.0f);
			}
			default ->{
				yield (int)(0.4471f*this.border+9.6471f);
			}
		};
	}
	
	/**
	 * Fonction pour calculer le décalage de l'axe Y pour le signe de l'addition
	 * @param heightWidth
	 */
	private void function_y_pos_plus_sign(Integer heightWidth) {
		this.pos_y_text = switch(heightWidth) {
			case Integer i when i.intValue()<200 ->{
				yield (int)(0.4214f*this.border+2.25f);
			}
			case Integer i when  i.intValue()<300 ->{
				yield (int)(0.4509f*this.border+6.1818f);	
			}
			case Integer i when  i.intValue()<400 ->{
				yield (int)(0.4431f*this.border+4.9804);
			}
			default ->{
				yield (int)(0.4f*this.border+8.0f);
			}
		};
	}
	
	/**
	 * Fonction pour calculer le décalage de l'axe Y pour le signe div
	 * @param heightWidth
	 */
	private void function_y_pos_div_sign(Integer heightWidth) {
		this.pos_y_text = switch(heightWidth) {
			case Integer i when i.intValue()<200 ->{
				yield (int)(-0.0076f*Math.pow(this.border, 2)+0.7286f*this.border+0.6905f);
			}
			case Integer i when  i.intValue()<300 ->{
				yield (int)(0.0002f*Math.pow(this.border, 3)-0.0202f*Math.pow(this.border, 2)+1.0059f*this.border+0.7912f);	
			}
			case Integer i when  i.intValue()<400 ->{
				yield (int)(2.1561f*this.border-6.0175f);
			}
			default ->{
				yield (int)(0.4374f*this.border+11.749f);
			}
		};
	}
	
	private float function_coef() {
		float p = this.height/(this.width*1.0f);
		System.out.println("p ="+p);
		return (float) (10.572f*Math.pow(p, -1.402f));
	}
	
	public int getPos_x_text() {
		return pos_x_text;
	}

	public void setPos_x_text(int pos_x_text) {
		this.pos_x_text = pos_x_text;
	}

	public int getPos_y_text() {
		return pos_y_text;
	}

	public void setPos_y_text(int pos_y_text) {
		this.pos_y_text = pos_y_text;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = StrToColor(backgroundColor);
	}

	public Color getBackgroundHoveredColor() {
		return backgroundHoveredColor;
	}

	public void setBackgroundHoveredColor(String backgroundHoverColor) {
		this.backgroundHoveredColor = StrToColor(backgroundHoverColor);
	}

	public Color getBackgroundPressedColor() {
		return backgroundPressedColor;
	}

	public void setBackgroundPressedColor(String backgroundPressedColor) {
		this.backgroundPressedColor = StrToColor(backgroundPressedColor);
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = StrToColor(borderColor);
	}

	public Color getBorderHoveredColor() {
		return borderHoveredColor;
	}

	public void setBorderHoveredColor(String borderHoverColor) {
		this.borderHoveredColor = StrToColor(borderHoverColor);
	}

	public Color getBorderPressedColor() {
		return borderPressedColor;
	}

	public void setBorderPressedColor(String borderPressedColor) {
		this.borderPressedColor = StrToColor(borderPressedColor);
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = StrToColor(textColor);
	}

	public Color getTextHoveredColor() {
		return textHoveredColor;
	}

	public void setTextHoveredColor(String textHoverColor) {
		this.textHoveredColor = StrToColor(textHoverColor);
	}

	public Color getTextPressedColor() {
		return textPressedColor;
	}

	public void setTextPressedColor(String textPressedColor) {
		this.textPressedColor = StrToColor(textPressedColor);
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public boolean isHovered() {
		return hovered;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// ajouté
	public boolean isReleased() {
		return released;
	}

	// modif utile uniquement pour les tests et mesures
//	public float getCoef() {
//		return coef;
//	}
//
//
//	public void setCoef(float coef) {
//		this.coef = coef;
//	}
	
	
	
}
