package codeEnJava.dataStructures;

import fr.bs.dev.StrucData.Array;
import fr.bs.dev.StrucData.Stack;

public class JBtree {

	private JNode root = null;
	private String infixe = null;
	private Array<String> array_infixe = null;
	private Array<String> array_prefixe = null;
	
	public JBtree(String infixe) {
		super();
		this.infixe = infixe;
		if(isWellBracket()) {
			System.out.println("Expression infixe correcte");
			stringToArray();
			createBtree();
			pathPrefixe();
		}else {
			System.out.println("Expression infixe n'est pas correcte");
			// envoyer un message d'erreur vers le display
		}
		
	}

	private void pathPrefixe() {
		// TODO Auto-generated method stub
		
	}

	private void createBtree() {
		// TODO Auto-generated method stub
		
	}

	private void stringToArray() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Cette méthode va évaluer si une expression infixe est correctement parenthésée
	 * On dit qu'un expression infixe est correctement parenthésés lorsque chaque parenthèse OUVRANTE est
	 * associée à une parenthèse FERMANTE correspondante et que l'ordre d'imbrication est respecté.
	 * 
	 * Pour réaliser cette méthode, je vais mettre en oeuvre une pile (stack)
	 * 	->	A chaque fois que l'on rencontre une paraenthèse ouvrante, on la place dans la pile
	 * 	-> A chaque fois que l'on rencontre une prenthèse fermante et que la pile n'est pas vide, on la retire de la pile
	 * 			--> si la pile est vide --> donc l'expression infixe n'est pas correctement parenthésée
	 * 	à la fin du traitement de l'expression infixe :
	 * 									--> la pile est vide donc expression correctement parenthésée
	 * 									--> la pile n'est pas vide l'expression infixe n'est pas correctement parenthésée
	 * 
	 * @return
	 */
	private boolean isWellBracket() {
		Stack<String> stack = new Stack<>();
		int pointer = 0;
		while(pointer<infixe.length()) {
			String caractere = infixe.substring(pointer, pointer+1);
			System.out.println("Ligne 63: caractere ="+caractere);
			if(caractere.equals("("))
				stack.push("(");
			
			if(caractere.equals(")")) {
				if(!stack.isEmpty())
					stack.pop();
				else
					return false;
			}
			
			pointer++;
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	
	
	
	
}
