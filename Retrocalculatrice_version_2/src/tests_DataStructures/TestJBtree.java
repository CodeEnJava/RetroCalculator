package tests_DataStructures;

import codeEnJava.dataStructures.JBtree;

public class TestJBtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String infixe = "2+3.45*(7.1-6.3)+2.35";
		infixe = "2.025+(3.56-2.0023*4.365)*5.85";
		JBtree btree = new JBtree(infixe);
		
	}

}
