package codeEnJava.keyboard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyJButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6754909011912247331L;
	
	// mise en place des parametres par défaut
	private static final int 	HEIGHT_DEFAULT						= 100; 
	private static final int 	WIDTH_DEFAULT						= 100; 
	private static final int 	RADIUS_DEFAULT						= 10;
	private static final int 	BORDER_DEFAULT						= 10; 
	
	private static final int 	FONTSIZE_DEFAULT					= 30; 
	
	// les couleurs du background en fonction de l'évenement
	private static final String BACKGROUND_COLOR_DEFAULT   		 = "#00AA10";
	private static final String BACKGROUND_HOVER_COLOR_DEFAULT   = "#AA2010";
	private static final String BACKGROUND_PRESSED_COLOR_DEFAULT = "#1020BB";
	
	// les couleurs de la bordure en fonction de l'évenement
	private static final String BORDER_COLOR_DEFAULT   			 = "#77AA10";
	private static final String BORDER_HOVER_COLOR_DEFAULT   	 = "#AA2077";
	private static final String BORDER_PRESSED_COLOR_DEFAULT   	 = "#7720BB";
	
	// les couleurs du texte en fonction de l'évenement
	private static final String TEXT_COLOR_DEFAULT   			 = "#DDDDDD";
	private static final String TEXT_HOVER_COLOR_DEFAULT   		 = "#AAAAAA";
	private static final String TEXT_PRESSED_COLOR_DEFAULT   	 = "#EEEEEE";
	
	// les attributs de l'objet MyjButton
	private Font font 		=null;
	private int  height;
	private int  width;
	private int  radius;
	private int  border;
	
	private int pos_x_text = 14;
	private int pos_y_text = 29;
	
	private Color backgroundColor 		 = null;
	private Color backgroundHoveredColor = null;
	private Color backgroundPressedColor = null;
	
	private Color borderColor 			 = null;
	private Color borderHoveredColor 	= null;
	private Color borderPressedColor 	 = null;
	
	private Color textColor      		 = null;
	private Color textHoveredColor       = null;
	private Color textPressedColor       = null;
	
	private boolean pressed              = false;
	private boolean hovered              = false;
	
	private String value                 = null;
	
	// mise en place du constructeur
	
	/**
	 * si le deuxième parametre existe, on fixe la largeur
	 * si le troisième parametre existe, on fixe la hauteur
	 * si le quatrième parametre existe, on fixe le radius 
	 * si le cinquième parametre existe, on fixe la epaisseur de la bordure
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
		
		font = new Font("Arial",Font.PLAIN,(int)(Math.min(height, width)*0.7f));
		super.setFont(font); //?? est-ce la bonne approche à vérifier lors des tests
		
		// fixer une taille fixe....
		super.setPreferredSize(new Dimension(this.width,this.height));
		super.setMinimumSize(new Dimension(this.width,this.height));
		super.setMaximumSize(new Dimension(this.width,this.height));
		
		super.setFocusable(false);
		super.setContentAreaFilled(false);
		
		// mettre en place l'écouteur sur les évenements de la souris
		
		super.addMouseListener(new MouseAdapter() {
			
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
				repaint();
			}
			
			public void mouseReleased(MouseEvent e){
				pressed = false;
				repaint();
			}
			
		});
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Color currentBackgroundColor 	= pressed?backgroundPressedColor:(hovered? backgroundHoveredColor:backgroundColor);
		Color currentBorderColor 		= pressed?borderPressedColor:(hovered? borderHoveredColor:borderColor);
		Color currentTextColor 			= pressed?textPressedColor:(hovered? textHoveredColor:textColor);
		
		Graphics2D g2 = (Graphics2D)g;
		// -1  placer la surface pour préparer la bordure
		g2.setColor(currentBorderColor);
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		
		// -2  placer la surface pour préparer le background
		g2.setColor(currentBackgroundColor);
		g2.fillRoundRect(border/2, border/2, width-border, height-border, radius, radius);
		
		// -3 placer le texte au dessus
		g2.setColor(currentTextColor);
		// vérifier lors des tests du bon positionnement 
		g2.drawString(this.value, -pos_x_text+(width-border/2)/2, pos_y_text+(height-border/2)/2);
		
		g2.dispose(); // on libère la ressource
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(255,255,255,0));
		g2.setStroke(new BasicStroke(1));
		g2.drawRoundRect(0, 0, width-1, height-1, radius, radius);
		g2.dispose();
	}
	
	
	/**
	 * Cette méthode permet de convertir une expression couleur au format #AABBCC en format RGB(R,G,B)
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
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
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

	public void setMyBorder(int border) {
		this.border = border;
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
	
	
	
}
