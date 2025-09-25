package codeEnJava.test_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import codeEnJava.displays.Display;

public class ProcessKeyDisplay {
	
	private KeyExample[] keyboard = null;
	private Display display       = null;
	private String message        = null; // information contenu dans le display
	
	private BigDecimal operande1  = new BigDecimal("0.45");
	private BigDecimal operande2  = null;
	
	private Thread[] thread       = null;
	int index                     = 0;
	public ProcessKeyDisplay(KeyExample[] keyboard, Display display) {
		super();
		this.keyboard = keyboard;
		this.display = display;
		
		this.thread = new Thread[this.keyboard.length];
		
		// mettre en place un écouter sur la première touche du clavier
		
			keyboard[0].getKey().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				index = 0;
				System.out.println("la touche :"+keyboard[index].getKey().getValue()+" a été préssée");
				thread[index] = new Thread(() ->{
					System.out.println("Le THREAD a été lancé après le clic sur la touche N°"+index);
					//simulation d'une action 
					try {
						Thread.sleep(10);
						action(index);
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Le traitement associé à la touche N°"+index+" est terminé");
					
				});
				
				thread[index].start();
			}
		});
			
			keyboard[1].getKey().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					index = 1;
					System.out.println("la touche :"+keyboard[index].getKey().getValue()+" a été préssée");
					thread[index] = new Thread(() ->{
						System.out.println("Le THREAD a été lancé après le clic sur la touche N°"+index);
						//simulation d'une action 
						try {
							Thread.sleep(10);
							action(index);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("Le traitement associé à la touche N°"+index+" est terminé");
						
					});
					thread[index].start();
				}
			});	
		
			keyboard[2].getKey().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					index = 2;
					System.out.println("la touche :"+keyboard[index].getKey().getValue()+" a été préssée");
					thread[index] = new Thread(() ->{
						System.out.println("Le THREAD a été lancé après le clic sur la touche N°"+index);
						//simulation d'une action 
						try {
							Thread.sleep(10);
							action(index);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("Le traitement associé à la touche N°"+index+" est terminé");
						
					});
					
					thread[index].start();
				}
			});
			
	}
	
	private void action(int index) {
		// incrémenter - décrémenter et remettre à 0
		
		System.out.println("action : "+index);
		message = display.getStr_val();
		
		operande2 = new BigDecimal(message);
		
		switch(index) {
		
		case 0:
			if(message.contains(".")) {
				BigDecimal result = operande2.add(operande1);
				display.clear();
				display.setValue(String.valueOf(result.floatValue()));
			}else {
				display.clear();
				display.setValue(""+(Integer.parseInt(message.trim())+1));
			}
			break;
		
		case 1:
			if(message.contains(".")) {
				BigDecimal result = operande2.subtract(operande1);
				display.clear();
				display.setValue(String.valueOf(result.floatValue()));
			}else {
				display.clear();
				display.setValue(""+(Integer.parseInt(message.trim())-1));
			}
			break;
		
		case 2:
			display.clear();
			display.setValue("0.0");
			break;
		}
	}
	
	
	
	

}
