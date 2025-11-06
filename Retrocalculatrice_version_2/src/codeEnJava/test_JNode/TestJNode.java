package codeEnJava.test_JNode;

import codeEnJava.dataStructures.JNode;

public class TestJNode {

	public static void main(String[] args) {
		
		JNode root = new JNode("root");
		
		root.printJNode();
		
		JNode left = new JNode("left");
		JNode right = new JNode("right");
		
		root.addLeftChild(left);
		root.addRightChild(right);
		
		(root.getLeftChild()).printJNode();
		(root.getRightChild()).printJNode();
		
		boolean leaf_left = (root.getLeftChild()).isLeaf();
		System.out.println("leaf_left ="+leaf_left);
		
		boolean isroot =(root.getLeftChild()).isRoot(); 
		System.out.println("isroot ="+isroot);
	}

}
