package codeEnJava.test_JNode;


import java.awt.Frame;

import javax.swing.JFrame;

import codeEnJava.dataStructures.JDisplayBTree;
import codeEnJava.dataStructures.JNode;

public class TestJDisplayBTree {
	
	public static void main(String[] args) {
		
		JNode root = new JNode("-");
		JNode n1 = new JNode("*");
		JNode n2 = new JNode("/");
		JNode n3 = new JNode("*");
		JNode n4 = new JNode("+");
		JNode n5 = new JNode("5");
		JNode n6 = new JNode("+");
		JNode n7 = new JNode("3");
		JNode n8 = new JNode("8");
		JNode n9 = new JNode("-");
		JNode n10 = new JNode("*");
		JNode n11 = new JNode("2");
		JNode n12 = new JNode("3");
		JNode n13 = new JNode("4");
		JNode n14 = new JNode("5");
		JNode n15 = new JNode("2");
		JNode n16 = new JNode("3");
		
		root.addLeftChild(n1);
		root.addRightChild(n2);
		
		n1.addLeftChild(n3);
		n1.addRightChild(n4);
		
		n2.addLeftChild(n5);
		n2.addRightChild(n6);
		
		n3.addLeftChild(n7);
		n3.addRightChild(n8);
		
		n4.addLeftChild(n9);
		n4.addRightChild(n10);
		
		n6.addLeftChild(n11);
		n6.addRightChild(n12);
		
		n9.addLeftChild(n13);
		n9.addRightChild(n14);
		
		n10.addLeftChild(n15);
		n10.addRightChild(n16);
		
		
		JFrame showBtree = new JFrame("Affichage BTREE");
		showBtree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		showBtree.setSize(800, 600);
		showBtree.setLocationRelativeTo(null);
		
		showBtree.add(new JDisplayBTree(root));
		
		showBtree.setVisible(true);
	}

}
