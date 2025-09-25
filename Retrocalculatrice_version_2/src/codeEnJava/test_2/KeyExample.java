package codeEnJava.test_2;

import codeEnJava.keyboard.MyJButton;

public class KeyExample {
	private MyJButton key = null;
	private String val    = null;
	
	
	public KeyExample(int width,int height, String val ) {
		super();
		this.val = val;
		key = new MyJButton(""+this.val.charAt(0), width,height);
	}


	public MyJButton getKey() {
		return key;
	}
	
}
