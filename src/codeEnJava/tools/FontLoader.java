package codeEnJava.tools;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FontLoader {
	
	private static final String FontFilename = "7Segment.ttf";
	private String path = null;
	@SuppressWarnings("unused")
	private String root = null;
	private Font font = null;
	
	private static volatile FontLoader instance = null;
	
	private FontLoader(String root) throws Exception {
		this.root = root;
		
		if(root == null) {
			this.root = getRootOs();
		}
		
		this.path = MyFile.findCurrentFolderProject(root);
		
		if(this.path==null) {
			throw ErrorPathConf();
			
		}else
			this.font = loadFont(50);
	}

	private Font loadFont(int size) {
		Font newFont = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try {
			FileInputStream fis = new FileInputStream(this.path+File.separator+FontFilename);
			newFont = Font.createFont(Font.TRUETYPE_FONT, fis);
			ge.registerFont(newFont);
			
		} catch (IOException | FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		int indexFont = -1;
		String[] listFonts= ge.getAvailableFontFamilyNames();
		int pt =0;
		boolean  findFont = false;
		while(pt<listFonts.length && !findFont) {
			//System.out.println(listFonts[pt]);
			if(listFonts[pt].equals(newFont.getFamily())) {
				indexFont = pt;
				findFont = true;
			}
			pt++;
		}
		//System.out.println("indexfont="+indexFont);
		//newFont = new Font(ge.getAvailableFontFamilyNames()[indexFont],Font.PLAIN,size);
		//System.out.println(newFont);
		return new Font(ge.getAvailableFontFamilyNames()[indexFont],Font.PLAIN,size);
	}

	private Exception ErrorPathConf() {
		System.err.println("Le dossier n'existe pas ou il a été supprimé");
		return null;
	}

	private String getRootOs() {
		String SE = System.getProperty("os.name").toLowerCase();
		if(SE.indexOf("win")>=0)
			return "C:\\";
		else
			return "/";
		
	}

	public Font getFont() {
		return font;
	}

	public static FontLoader getInstance(String root) {
		if(instance == null)
			try {
				instance = new FontLoader(root);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return instance;
	}

}
