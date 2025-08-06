package codeEnJava.tools;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import fr.bs.dev.StrucData.Stack;

public class MyFile {
	
	private static final String FOLDER_7SEGMENTS ="PROJECT_CAL_FONTS_DISPLAY7SEG 10.57.52";
	
	public static String findCurrentFolderProject(String root) {
		Path currentDirectoryPath = FileSystems.getDefault().getPath(root);
		String currentDirectoryPathName = currentDirectoryPath.toAbsolutePath().toString();
		
		File file = new File(currentDirectoryPathName);
		File[] tab_list_files = file.listFiles();
		
		if(tab_list_files== null)
			return null;
		
		Stack<File> stack  = new Stack<>(32000);
		String pathForder = null;
		
		// remplir la pile
		for(File f:tab_list_files) {
			if(f.isDirectory())
				stack.push(f);
		}
		boolean find = false;
		
		while(!stack.isEmpty() && !find) {
			File popStack = stack.pop();
			//System.out.println(popStack);
			if(popStack.getName().equals(FOLDER_7SEGMENTS)) {
				find = true;
				pathForder = popStack.getAbsolutePath();
			}else if(popStack.isDirectory()) {
				File[] tf = popStack.listFiles();
				if(tf!=null) {
					for(File ff: tf) {
						if(ff.isDirectory())
							stack.push(ff);
					}
				}
			}
		}
		return pathForder;
	}

}
