package codeEnJava.test_1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import codeEnJava.displays.Display;
import codeEnJava.keyboard.MyJButton;

public class KeyExample {
	private MyJButton key = null;
	@SuppressWarnings("unused")
	private Display display = null;
	@SuppressWarnings("unused")
	private String val = null;
	
	public KeyExample(int width, int height, String val, Display display) {
		super();
		this.display = display;
		this.val = val;
		
		key = new MyJButton(""+val.charAt(0), width,height);
		
		key.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int int_count = 0;
				float float_count = 0.0f;
				if(key.isPressed()) {
					
					switch(key.getValue()) {
					
					case "+":	
							if( display.getStr_val().contains(".")) {
								BigDecimal a = new BigDecimal(display.getStr_val());
								BigDecimal b = new BigDecimal("0.5");
								BigDecimal result = a.add(b);
								float_count = result.floatValue();
								display.clear();
								display.setValue(String.valueOf(float_count));
							}else {
								int_count = Integer.parseInt(display.getStr_val().trim())+1;
								display.setValue(""+int_count);
							}
					
							break;
							
					case "-":	
							if( display.getStr_val().contains(".")) {
								BigDecimal a = new BigDecimal(display.getStr_val());
								BigDecimal b = new BigDecimal("0.5");
								BigDecimal result = a.subtract(b);
								float_count = result.floatValue();
								display.clear();
								display.setValue(String.valueOf(float_count));
							}else {
								int_count = Integer.parseInt(display.getStr_val().trim())-1;
								display.setValue(""+int_count);
							}
					
							break;
					
					case "C":
							display.clear();
							display.setValue("0.0");
							break;
					default:
						
					}
					
				}
			}
		});
	}

	public MyJButton getKey() {
		return key;
	}
	
	
	

}
