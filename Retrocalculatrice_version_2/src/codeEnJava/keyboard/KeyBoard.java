package codeEnJava.keyboard;

import javax.swing.JPanel;

import codeEnJava.displays.Display;

public class KeyBoard implements ConfigKeyboard {
	
	private String borderColor     		= BORDERCOLOR;
	
	// keys divers
	private String bgColor         		= BACKGROUNDCOLORKEY;
	private String bgHoverColor    		= BACKGROUNDHOVEREDCOLORKEY;
	private String bgPressedColor  		= BACKGROUNDPRESSEDCOLORKEY;
	
	// keys numbers
	private String bgColorNumber         = BACKGROUNDCOLORKEYNUMBER;
	private String bgHoverColorNumber    = BACKGROUNDHOVEREDCOLORKEYNUMBER;
	private String bgPressedColorNumber  = BACKGROUNDPRESSEDCOLORKEYNUMBER;
	
	// keys operators
	private String bgColorOperator        = BACKGROUNDCOLORKEYOPERATOR;
	private String bgHoverColorOperator   = BACKGROUNDHOVEREDCOLORKEYOPERATOR;
	private String bgPressedColorOperator = BACKGROUNDPRESSEDCOLORKEYOPERATOR;
	
	// keys functions
	private String bgColorFunction        = BACKGROUNDCOLORKEYFUNCTION;
	private String bgHoverColorFunction   = BACKGROUNDHOVEREDCOLORKEYFUNCTION;
	private String bgPressedColorFunction = BACKGROUNDPRESSEDCOLORKEYFUNCTION;
	
	private String textWhite              = TEXTCOLORWHITE;
	private String textBlack              = TEXTCOLORBLACK;
	
	private int borderthickness           = BORDERTHICKNESS;
	private int borderRadius              = BORDERRADIUS;
	private int width                     = KEYWIDTH;
	private int height                    = KEYHEIGHT;
	
	private int columns                   = 6;
	private int rows                      = 5;
	
	// keys names for 28 
	private String [] keysName = {"CLS","C","CM","*","RM","MOD",
			                       "7","8","9","\u00F7","M+","%",
			                       "4","5","6","-","M-","\u00B9\u2044\u2093",
			                       "1","2","3","+","=","\u221Ax",
			                       "\u00B1",".","0","x\u00B2"};
	
	private int[] pos_x= {0,1,2,3,4,5,
			              0,1,2,3,4,5,
			              0,1,2,3,4,5,
			              0,1,2,3,4,5,
			              0,1,2,5};
	
	private int[] pos_y = {0,0,0,0,0,0,
			               1,1,1,1,1,1,
			               2,2,2,2,2,2,
			               3,3,3,3,3,3,
			               4,4,4,4};
	
	private int[] dx     = {1,1,1,1,1,1,
			                1,1,1,1,1,1,
			                1,1,1,1,1,1,
			                1,1,1,1,1,1,
			                1,1,1,1,};
	
	private int [] dy    = {1,1,1,1,1,1,
			                1,1,1,1,1,1,
			                1,1,1,1,1,1,
			                1,1,1,2,2,1,
			                1,1,1,1};
	
	
	private String[] bgc  		= {	bgColor,bgColor,bgColor,bgColorOperator,bgColor,bgColorFunction,
			                 		bgColorNumber,bgColorNumber,bgColorNumber,bgColorOperator,bgColor,bgColorFunction,
			                 		bgColorNumber,bgColorNumber,bgColorNumber,bgColorOperator,bgColor,bgColorFunction,
			                 		bgColorNumber,bgColorNumber,bgColorNumber,bgColorOperator,bgColorOperator,bgColorFunction,
			                 		bgColor,bgColorNumber,bgColorNumber,bgColorFunction};
	
	private String[] bgHovered = {	bgHoverColor,bgHoverColor,bgHoverColor,bgHoverColorOperator,bgHoverColor,bgHoverColorFunction,
						            bgHoverColorNumber,bgHoverColorNumber,bgHoverColorNumber,bgHoverColorOperator,bgHoverColor,bgColorFunction,
						            bgHoverColorNumber,bgHoverColorNumber,bgHoverColorNumber,bgHoverColorOperator,bgHoverColor,bgColorFunction,
						            bgHoverColorNumber,bgHoverColorNumber,bgHoverColorNumber,bgHoverColorOperator,bgHoverColorOperator,bgColorFunction,
						            bgHoverColor,bgHoverColorNumber,bgHoverColorNumber,bgHoverColorFunction};
	
	private String[] bgPressed  = {bgPressedColor,bgPressedColor,bgPressedColor,bgPressedColorOperator,bgPressedColor,bgPressedColorFunction,
						            bgPressedColorNumber,bgPressedColorNumber,bgPressedColorNumber,bgPressedColorOperator,bgPressedColor,bgPressedColorFunction,
						            bgPressedColorNumber,bgPressedColorNumber,bgPressedColorNumber,bgPressedColorOperator,bgPressedColor,bgPressedColorFunction,
						            bgPressedColorNumber,bgPressedColorNumber,bgPressedColorNumber,bgPressedColorOperator,bgPressedColorOperator,bgPressedColorFunction,
						            bgPressedColor,bgPressedColorNumber,bgPressedColorNumber,bgPressedColorFunction};
	
	
	private MyJButton[] keys = null;
	private Grid2D grid2d = null;
	
	public KeyBoard(Display[] displays) {
		super();
		this.keys = new JKey[keysName.length];
		
		for(int i=0;i<keysName.length;i++) {
			keys[i] = new JKey(displays,keysName[i],width,height);
			keys[i].setBackgroundColor(bgc[i]);
			keys[i].setBackgroundHoveredColor(bgHovered[i]);
			keys[i].setBackgroundPressedColor(bgPressed[i]);
			
			keys[i].setBorderColor(borderColor);
			keys[i].setRadius(borderRadius);
			keys[i].setMyBorder(borderthickness);
			keys[i].setTextColor(textBlack);
			keys[i].setTextHoveredColor(textWhite);
			keys[i].setTextPressedColor(textWhite);
		}
		
		this.grid2d= new Grid2D(columns,rows,width,height);
		
		for(int i=0;i<keysName.length;i++) {
			this.grid2d.put(keys[i], pos_x[i], pos_y[i], dx[i],dy[i]);
		}
	}
	
	public JPanel getGrid2D() {
		return this.grid2d.getGrid2D();
	}
	
	
	

}
