package codeEnJava.test_JNode;


import java.awt.Frame;

import javax.swing.JFrame;

import codeEnJava.dataStructures.JDisplayBTree;
import codeEnJava.dataStructures.JNode;

public class TestJDisplayBTree {
	
	public static void main(String[] args) {
		
		JNode root = new JNode("+");
		
		
		
		JNode op1 = new JNode("-");
		JNode op2 = new JNode("50");
		
		root.addLeftChild(op1);
		root.addRightChild(op2);
		
		JNode op3 = new JNode("200");
		JNode op4 = new JNode("80");
		
		root.getLeftChild().addLeftChild(op3);
		root.getLeftChild().addRightChild(op4);
		
		JFrame showBtree = new JFrame("Affichage BTREE");
		showBtree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		showBtree.setSize(800, 600);
		showBtree.setLocationRelativeTo(null);
		
		showBtree.add(new JDisplayBTree(root));
		
		showBtree.setVisible(true);
	}

}
