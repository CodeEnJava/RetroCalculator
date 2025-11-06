package codeEnJava.dataStructures;

public class JNode {
	
	private Object value = null;		//Objet contenu dans le JNode
	private Integer type = null;		// type = 0  --> racine (root)
										// type = 1  --> pas d'enfant donc une feuille
	                                    // type = 2  --> je node dispose d'au moins un fils donc c'est un sommet (node)
	
	private JNode parent 		= null;
	private JNode leftChild 	= null;
	private JNode rightChild 	= null;
	
	private Integer visited     = null;   // pour le parcours en profondeur de l'arbre
	
	
	public JNode(Object value) {
		this.value = value;
		this.type = 0;
		this.visited = 0;
	}
	
	public JNode(Object value, JNode parent) {
		this.value = value;
		this.parent = parent;
		this.type = 1;
		this.visited = 0;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public JNode getParent() {
		return parent;
	}

	public void setParent(JNode parent) {
		this.parent = parent;
	}

	public JNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(JNode leftChild) {
		this.leftChild = leftChild;
	}

	public JNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(JNode rightChild) {
		this.rightChild = rightChild;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}
	
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}
	
	public boolean isRoot() {
		return parent == null;
	}
	
	public boolean hasChildren() {
		return leftChild != null || rightChild != null;
	}
	
	private void updateType() {
		if(isRoot()) type = 0;
		else if (isLeaf()) type = 1;
		else type = 2;
	}
	
	public void addLeftChild(JNode child) {
		this.leftChild = child;
		child.setParent(this);
		this.updateType();
		child.updateType();
	}
	
	public void addRightChild(JNode child) {
		this.rightChild = child;
		child.setParent(this);
		this.updateType();
		child.updateType();
	}
	
	public void printJNode() {
		System.out.println(" valeur : "+value+ " type : "+type+"  visited : "+visited);
	}
}
