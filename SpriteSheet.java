package castlevania;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage spriteSheet;
	private BufferedImage[][] images;

	public SpriteSheet(String stringSpriteSheet, int width, int height, int rows, int columns) 
	{
		try {
			this.spriteSheet = ImageIO.read(new File(stringSpriteSheet));
		} catch (IOException e) {

			System.out.println("Error Opening File.");
		}
		images = new BufferedImage[rows][columns];

		int y = 0;
		for (int i = 0; i < rows; i++) 
		{
			int x = 0;
			for (int j = 0; j < columns; j++) 
			{
				images[i][j] = this.spriteSheet.getSubimage(x, y, width, height);
				x += width;
			}
			y += height;
		}
	}

	public BufferedImage getImage(int i, int j) 
	{
		return images[i][j];
	}
}
