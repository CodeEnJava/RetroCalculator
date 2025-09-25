package codeEnJava.keyboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Grid2D {
	
	private int columns = 0;
	private int rows    = 0;
	private int width   = 0;  // la largeur d'une cellule de la grille
	private int height  = 0;  // la hauteur d'une cellule de la grille
	
	private int nbx     = 0;
	private int nby     = 0;
	
	private JPanel grid2D          = null;
	private GridBagConstraints gbc = null;
	private JLabel[] cells         = null;
	
	private  final static Color  BACKGROUNDCOLOR     = Color.gray;
	private  final static Color  BORDERCOLOR         = Color.blue;
	private  final static int    BORDERLINETHICKNESS = 1;
	
	
	public Grid2D(int columns, int rows, int width, int height) {
		super();
		this.columns = columns;
		this.rows = rows;
		this.width = width;
		this.height = height;
		
		this.cells = new JLabel[this.columns*this.rows];
		
		this.grid2D = new JPanel();
		this.grid2D.setLayout(new GridBagLayout());
		
		this.gbc = new GridBagConstraints();
		this.gbc.fill = GridBagConstraints.BOTH; // le composant occupe toute la surface de la cellule
		this.gbc.weightx = 1.0;
		this.gbc.weighty = 1.0;
		
		for(int row = 0;row<this.rows;row++) {
			for(int col= 0; col<this.columns;col++) {
				int pointer = row*this.columns+col;
				Dimension dim = new Dimension(this.width,this.height);
				
				cells[pointer] = new JLabel();
				
				//création des bordures
				Border border= BorderFactory.createLineBorder(BORDERCOLOR, BORDERLINETHICKNESS);
				cells[pointer].setBorder(border);
				
				cells[pointer].setOpaque(true);
				cells[pointer].setBackground(BACKGROUNDCOLOR);
				
				cells[pointer].setMinimumSize(dim);
				cells[pointer].setMaximumSize(dim);
				cells[pointer].setPreferredSize(dim);
				
				gbc.gridx = col;
				gbc.gridy = row;
				grid2D.add(cells[pointer],gbc);
			}
		}
		
	}


	public JPanel getGrid2D() {
		return grid2D;
	}
	
	
	public void put(MyJButton button,int column,int row,int ...nbcells) {
		
		if(nbcells == null || nbcells.length !=2) {
			this.nbx = 1;
			this.nby = 1;
		}else {
			this.nbx = nbcells[0];
			this.nby = nbcells[1];
		}
		
		this.gbc.gridx = column;
		this.gbc.gridy = row;
		
		// suppression des composants avant injections du bouton
		for(int y= row; y<row+nby;y++) {
			for(int x=column;x<column+nbx;x++) {
				this.grid2D.remove(cells[y*this.columns+x]);
			}
		}
		
		gbc.gridwidth = nbx;
		gbc.gridheight= nby;
		
		button.setWidth(nbx*this.width);
		button.setHeight(nby*this.height);
		
		grid2D.add(button,gbc);
	}
	
}
