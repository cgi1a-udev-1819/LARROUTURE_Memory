import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Jeu {

	private ImageIcon[][] figures;

	private int rows = 4;
	private int cols = 3;

	public Jeu() throws IOException {
		figures = loadImages();
	}

	public ImageIcon[][] loadImages() throws IOException {

		ImageIcon[][] images = ResourceUtility.splitImageIcon(
				ResourceUtility.loadBufferedImage("images/butterfly2.png")
				, rows, cols);
		int index = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				images[i][j].setDescription("c"+index++);
			}
		}
		return images;
	}

	public LinkedList<ImageIcon> creerPioche()
	{
		LinkedList<ImageIcon> pioche = new LinkedList<>();

		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < rows; j++)
			{
				for (int k = 0; k < cols; k++)
				{
					pioche.push(figures[j][k]);
				}
			}
		}
		Collections.shuffle(pioche);
		return pioche;
	}
}