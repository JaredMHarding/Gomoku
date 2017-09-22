import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GameBoard extends JPanel {

	public Gomoku mainBoard;
	private BufferedImage blackPiece;
	private BufferedImage whitePiece;
	
	/**
	 * Create the panel.
	 */
	
	public GameBoard() {
		mainBoard = new Gomoku();
		try {
			blackPiece = ImageIO.read(new File("./black.png"));
			whitePiece = ImageIO.read(new File("./white.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		super.paint(g); //call primary paint method
		
		int index=1;
		while(index<16){
			g.drawLine(getWidth()/16, index*(getHeight()/16), (getWidth())-getWidth()/16, index*(getHeight()/16));
			g.drawLine(index*(getWidth()/16), (getHeight()/16), index*(getWidth()/16), getHeight()-getHeight()/16);
			index++;
		}

		for (int i = 0;i<15;i++) {
			for (int j = 0;j<15;j++) {
				int state = mainBoard.getState(i, j);
				if (state == mainBoard.BLACK) {
					g.drawImage(blackPiece,(i+1)*40-20, (j+1)*40-20, null);
				}
				else if (state == mainBoard.WHITE) {
					g.drawImage(whitePiece,(i+1)*40-20, (j+1)*40-20, null);
				}
			}
		}
//
//		final BufferedImage blackPiece;
//		final BufferedImage whitePiece;
//		
//		try {
//			blackPiece = ImageIO.read(new File("./black.png"));
//			whitePiece = ImageIO.read(new File("./white.png"));
//			
//			
//			//g.drawImage(image,(0+1)*40-20, (2+1)*40-20, null);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
			
					
			
	}

}