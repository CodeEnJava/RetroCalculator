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
}
