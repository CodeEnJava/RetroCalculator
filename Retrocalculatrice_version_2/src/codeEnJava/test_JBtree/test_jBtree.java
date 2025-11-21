package codeEnJava.test_JBtree;

import javax.swing.JFrame;

import codeEnJava.dataStructures.JBtree;
import codeEnJava.dataStructures.JDisplayBTree;

public class test_jBtree {

	public static void main(String[] args) {
		String infixe = "2.025+(3.56-2.0023*4.365)*5.85";
		infixe = "1.4-3*2.25+7.32-5.25*4.85";
		JBtree btree = new JBtree(infixe);
		
		JFrame showBtree = new JFrame("Affichage btree étape 1");
		showBtree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showBtree.setSize(900,700);
		showBtree.setLocationRelativeTo(null);
		showBtree.add(new JDisplayBTree(btree.getRoot()));
		showBtree.setVisible(true);
		
	}

}
