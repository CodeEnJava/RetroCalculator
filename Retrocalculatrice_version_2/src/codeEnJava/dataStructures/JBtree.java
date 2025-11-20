package codeEnJava.dataStructures;

import fr.bs.dev.StrucData.Array;
import fr.bs.dev.StrucData.Stack;
import fr.bs.dev.input.Lecture;

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
			// pour les tests
			for(int pt =0;pt<array_infixe.size();pt++) {
				System.out.println("tab["+pt+"]= "+array_infixe.get(pt));
			}
			// fin des tests
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

	/**
	 * cette méthode sera appelée si et seulement si l'expression infixe est valide
	 */
	private void stringToArray() {
		array_infixe = new Array<String>();
		
		int pt_current = 0;
		int pt_next = 0;
		String v = null;
		char c = 0;
		
		//parcourir la chaine qui contient l'expression infixe
		do {
			v = infixe.substring(pt_current,pt_current+1);
			c = v.charAt(0);
			if(isBracket(c) || isOperator(c)) {
				array_infixe.addToEnd(v);
				pt_current ++;
			}else {
				// on doit récupérer le nombre
				pt_next = pt_current;
				do {
					v = infixe.substring(pt_next,pt_next+1);
					c = v.charAt(0);
					pt_next ++;
					
				}while(!isOperator(c) && !isBracket(c) && pt_next < infixe.length());
				
				if(pt_next >=infixe.length()) {
					array_infixe.addToEnd(infixe.substring(pt_current));
					pt_current = pt_next;
				}else {
					array_infixe.addToEnd(infixe.substring(pt_current,pt_next-1));
					pt_current =  pt_next -1;
				}
			}
			
		}while(pt_current<infixe.length());
		
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
			//System.out.println("Ligne 63: caractere ="+caractere);
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
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isBracket(char c) {
		return c == '(' || c == ')';
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isOperator(char c) {
		boolean op= false;
		switch(c) {
		case '+','-','*','/','%':
			op = true;
			break;
		default:
			op = false;
		}
		return op;
	}
	
}
