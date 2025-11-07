package codeEnJava.dataStructures;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import fr.bs.dev.StrucData.Queue;

public class JDisplayBTree extends JPanel{
	
	private static final long serialVersionUID = -6354059720407047299L;
	private JNode root;
	private int nodeSize = 50;  // le diamètre du cecle qui représente un Sommet
	private int vGap = 80;		// espace entre deux niveaux
	
	public JDisplayBTree(JNode root) {
		this.root = root;
		setBackground(Color.WHITE);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.root !=null) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			int panelWidth = getWidth();
			// méthode pour dessiner un JNode
			drawJNode(g2,root,panelWidth/2,60,panelWidth/4);
		}
	}

	// cette méthode désinner un Sommet + ses enfants d'une manière récurssive
	private void drawJNode(Graphics2D g2, JNode node, int xx, int yy, int hgap) {
		
		Queue<InfoJNode> queue = new Queue<InfoJNode>();
		
		queue.push(new InfoJNode(node,xx,yy,hgap));
		
		while(!queue.isEmpty()) {
			
		InfoJNode  current = queue.pop();
		JNode current_node = current.getNode();
		
		int x = current.getX();
		int y = current.getY();
		int hGap = current.gethGap();
		// dessiner les lignes reliant les nodes
		if(current_node.getLeftChild()!= null) {
			int childX = x - hGap;
			int childY = y + vGap;
			g2.setColor(Color.BLUE);
			g2.drawLine(x, y+nodeSize/2, childX, childY-nodeSize/2);
			//drawJNodeOLd(g2,node.getLeftChild(),childX,childY,hGap/2);
			queue.push(new InfoJNode(current_node.getLeftChild(),childX,childY,hGap/2));
		}
		
		if(current_node.getRightChild()!= null) {
			int childX = x + hGap;
			int childY = y + vGap;
			g2.setColor(Color.GREEN);
			g2.drawLine(x, y+nodeSize/2, childX, childY-nodeSize/2);
			//drawJNodeOLd(g2,node.getRightChild(),childX,childY,hGap/2);
			queue.push(new InfoJNode(current_node.getRightChild(),childX,childY,hGap/2));
		}
		
		//Définir une couleur en fonction du type de JNode
		Color nodeColor;
		switch(current_node.getType() != null? current_node.getType():-1) {
			case 0: nodeColor = new Color(255,127,0);break;//la racine
			case 1: nodeColor = new Color(100,255,100);break;//une feuille
			case 2: nodeColor = new Color(100,100,255);break;//un sommet ( node)
			default: nodeColor = Color.LIGHT_GRAY;break;
		}
		
		// selon la valeur de la vraiable visited on modifie en randant plus sombre le node
		if(current_node.getVisited()!=null && current_node.getVisited()>0) {
			nodeColor = nodeColor.darker();
		}
		
		// dessiner le node
		g2.setColor(nodeColor);
		g2.fillOval(x-nodeSize/2, y-nodeSize/2, nodeSize, nodeSize);
		g2.setColor(Color.BLACK);
		g2.drawOval(x-nodeSize/2, y-nodeSize/2, nodeSize, nodeSize);
		
		// dessiner valeur contenue dans le node
		String text = current_node.getValue()== null?"?":current_node.getValue().toString();
		FontMetrics fm = g2.getFontMetrics();
		int textWidth = fm.stringWidth(text);
		g2.drawString(text, x-textWidth/2, y+fm.getAscent()/2-2);
		
		// afficher le type et visited en dessous de node
		
		String infos = "T:"+current_node.getType()+" V:"+current_node.getVisited();
		int infosWidth = fm.stringWidth(infos);
		g2.setFont(new Font("SansSerif",Font.PLAIN,10));
		g2.drawString(infos, x-infosWidth/2, y+nodeSize/2+12);
		
		}
	}
	
	// cette méthode désinner un Sommet + ses enfants d'une manière récurssive
		private void drawJNodeOLd(Graphics2D g2, JNode node, int x, int y, int hGap) {
			
			// dessiner les lignes reliant les nodes
			if(node.getLeftChild()!= null) {
				int childX = x - hGap;
				int childY = y + vGap;
				g2.setColor(Color.BLUE);
				g2.drawLine(x, y+nodeSize/2, childX, childY-nodeSize/2);
				drawJNodeOLd(g2,node.getLeftChild(),childX,childY,hGap/2);
			}
			
			if(node.getRightChild()!= null) {
				int childX = x + hGap;
				int childY = y + vGap;
				g2.setColor(Color.GREEN);
				g2.drawLine(x, y+nodeSize/2, childX, childY-nodeSize/2);
				drawJNodeOLd(g2,node.getRightChild(),childX,childY,hGap/2);
			}
			
			//Définir une couleur en fonction du type de JNode
			Color nodeColor;
			switch(node.getType() != null? node.getType():-1) {
				case 0: nodeColor = new Color(255,127,0);break;//la racine
				case 1: nodeColor = new Color(100,255,100);break;//une feuille
				case 2: nodeColor = new Color(100,100,255);break;//un sommet ( node)
				default: nodeColor = Color.LIGHT_GRAY;break;
			}
			
			// selon la valeur de la vraiable visited on modifie en randant plus sombre le node
			if(node.getVisited()!=null && node.getVisited()>0) {
				nodeColor = nodeColor.darker();
			}
			
			// dessiner le node
			g2.setColor(nodeColor);
			g2.fillOval(x-nodeSize/2, y-nodeSize/2, nodeSize, nodeSize);
			g2.setColor(Color.BLACK);
			g2.drawOval(x-nodeSize/2, y-nodeSize/2, nodeSize, nodeSize);
			
			// dessiner valeur contenue dans le node
			String text = node.getValue()== null?"?":node.getValue().toString();
			FontMetrics fm = g2.getFontMetrics();
			int textWidth = fm.stringWidth(text);
			g2.drawString(text, x-textWidth/2, y+fm.getAscent()/2-2);
			
			// afficher le type et visited en dessous de node
			
			String infos = "T:"+node.getType()+" V:"+node.getVisited();
			int infosWidth = fm.stringWidth(infos);
			g2.setFont(new Font("SansSerif",Font.PLAIN,10));
			g2.drawString(infos, x-infosWidth/2, y+nodeSize/2+12);
			
		}


}
