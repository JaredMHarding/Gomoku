import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GameBoard extends JPanel {

	@Override
	/**
	 * Create the panel.
	 */
	
	public void paint(Graphics g){
		super.paint(g); //call primary paint method
		
		int index=1;
		while(index<16){
			g.drawLine(getWidth()/16, index*(getHeight()/16), (getWidth())-getWidth()/16, index*(getHeight()/16));
			g.drawLine(index*(getWidth()/16), (getHeight()/16), index*(getWidth()/16), getHeight()-getHeight()/16);
			index++;
		}	
		
		final BufferedImage image;
		
		try {
			image = ImageIO.read(new File("./white.png"));
			g.drawImage(image,(0+1)*40-20, (2+1)*40-20, null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
					
			
	}
	
	public GameBoard() {

	}

}