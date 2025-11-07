package codeEnJava.dataStructures;

public class InfoJNode {
	// cette classe va jouer le rôle d'une mémoire
	// pour stocker le JNode, sa position dans le contexte graphique, et l'écart entre le Jnode et ses enfants
	
	private JNode node;
	int x,y,hGap;
	
	public InfoJNode(JNode n,int x, int y, int hgap) {
		this.node = n;
		this.x = x;
		this.y = y;
		this.hGap = hgap;
	}

	public JNode getNode() {
		return node;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int gethGap() {
		return hGap;
	}
	
	
}
