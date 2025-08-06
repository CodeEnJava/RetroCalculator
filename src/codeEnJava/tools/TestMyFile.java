package codeEnJava.tools;

import java.io.File;

public class TestMyFile {

	public static void main(String[] args) {
		String root = "/Users/steph.barois.dev/";
		if(args!=null && args.length>0)
			root = args[0];
		
		String pathFolder = MyFile.findCurrentFolderProject(root);
		System.out.println(pathFolder);
		
		if(pathFolder!=null) {
			File ff = new File(pathFolder);
			String parent = ff.getParent();
			System.out.println("le dossier parent:"+parent);
		}
	}

}
