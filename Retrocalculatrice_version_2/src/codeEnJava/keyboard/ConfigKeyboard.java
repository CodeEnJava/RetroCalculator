package codeEnJava.keyboard;

public interface ConfigKeyboard {
		// mise en place des parametres par défaut pour la classe MyButton
	
		public static final int 	HEIGHT_DEFAULT						= 100; 
		public static final int 	WIDTH_DEFAULT						= 100; 
		public static final int 	RADIUS_DEFAULT						= 30;
		public static final int 	BORDER_DEFAULT						= 5;
		
		public static final int 	FONTSIZE_DEFAULT					= 30; 
		
		// les couleurs du background en fonction de l'évenement
		public static final String BACKGROUND_COLOR_DEFAULT   		    = "#2563EB";// bleu vif
		public static final String BACKGROUND_HOVER_COLOR_DEFAULT    	= "#1E40AF";// bleu plus foncé
		public static final String BACKGROUND_PRESSED_COLOR_DEFAULT 	= "#1E3A8A";// encore plus sombre, effet "enfoncé"
		
		// les couleurs de la bordure en fonction de l'évenement
		public static final String BORDER_COLOR_DEFAULT   			 	= "#1E3A8A";
		public static final String BORDER_HOVER_COLOR_DEFAULT   	 	= "#1E3A8A";
		public static final String BORDER_PRESSED_COLOR_DEFAULT   	 	= "#172554";
		
		// les couleurs du texte en fonction de l'évenement
		public static final String TEXT_COLOR_DEFAULT   			 	= "#000000";
		public static final String TEXT_HOVER_COLOR_DEFAULT   		 	= "#202020";
		public static final String TEXT_PRESSED_COLOR_DEFAULT   	 	= "#505050";
		
		// fin constantes pour la classe MyJButton
		
		//--------------------------------------------------------------------------
		// les constantes pour la mise en place des displays
		   public static final int  NBDIGITS                            = 15;
		   public static final int  SEVENSEGWIDTH                       = (int)((8/3.)*NBDIGITS);
		
		//--------------------------------------------------------------------------
		
		// configuration du keyboard
		
		// backgroundColor
		
		// background color pour les commandes actions cls - memoires et +-
		public static final String BACKGROUNDCOLORKEY                  = "#FF0000";
		public static final String BACKGROUNDHOVEREDCOLORKEY           = "#85FF99";
		public static final String BACKGROUNDPRESSEDCOLORKEY           = "#B00AFF";
		
		// background color pour les nombres
		public static final String BACKGROUNDCOLORKEYNUMBER            = "#FF7F00";
		public static final String BACKGROUNDHOVEREDCOLORKEYNUMBER     = "#7FFFFA";
		public static final String BACKGROUNDPRESSEDCOLORKEYNUMBER     = "#307FFF";
		
		// background color pour les opérateurs
		public static final String BACKGROUNDCOLORKEYOPERATOR          = "#4896D5";
		public static final String BACKGROUNDHOVEREDCOLORKEYOPERATOR   = "#4855FF";
		public static final String BACKGROUNDPRESSEDCOLORKEYOPERATOR   = "#2896FF";
		
		// background color pour les functions
		public static final String BACKGROUNDCOLORKEYFUNCTION          = "#5AF1E7";
		public static final String BACKGROUNDHOVEREDCOLORKEYFUNCTION   = "#C8A1F7";
		public static final String BACKGROUNDPRESSEDCOLORKEYFUNCTION   = "#38CCE7";
		
		
		public static final String BORDERCOLOR                         = "#FFAA15";
		
		public static final String TEXTCOLORWHITE                      = "#FFFFFF";
		public static final String TEXTCOLORBLACK                      = "#000000";
		
		public static final int    BORDERTHICKNESS                     = 3;
		public static final int    BORDERRADIUS                        = 10;
		public static final int    KEYWIDTH                            = (int)(2.6*SEVENSEGWIDTH);
		public static final int    KEYHEIGHT                           = (int)(2.6*SEVENSEGWIDTH);
		
		public static final int    ROWS                                = 5;
		public static final int    COLUMNS                             = 6;
		
		
		
		
}
