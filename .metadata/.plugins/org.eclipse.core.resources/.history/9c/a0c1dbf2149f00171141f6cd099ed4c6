import java.awt.Graphics;

import javax.swing.JPanel;


public class GameBoard extends JPanel {

	@Override
	/**
	 * Create the panel.
	 */
	
	public void paint(Graphics g){
		super.paint(g); //call primary paint method
		
			//DRAW ROW LINES
			int rowindex=1;
			while(rowindex<16){
				g.drawLine(getWidth()/16, rowindex*(getHeight()/16), (getWidth())-getWidth()/16, rowindex*(getHeight()/16));
				rowindex++;
			}
			//Example on how to draw the first few rows manually
			//g.drawLine(0, getHeight()/16, getWidth(), getHeight()/16);
			//g.drawLine(0, 2*(getHeight()/16), 2*(getWidth()), 2*(getHeight()/16));
			
			//DRAW COL LINES
			int colindex=1;
			while(colindex<16){
				g.drawLine(colindex*(getWidth()/16), (getHeight()/16), colindex*(getWidth()/16), getHeight()-getHeight()/16);
				colindex++;
			}
			
			//g.drawLine(getWidth()/3, 0, getWidth()/3, getHeight());
	}
	
	public GameBoard() {

	}

}