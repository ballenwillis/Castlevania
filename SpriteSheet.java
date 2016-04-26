package castlevania;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage spriteSheet;
	private BufferedImage[][] images;
	private BufferedImage[][] flippedImages; //For when Player goes left

	public SpriteSheet(String stringSpriteSheet, int width, int height, int rows, int columns) 
	{
		try {
			this.spriteSheet = ImageIO.read(new File(stringSpriteSheet));
		} catch (IOException e) {

			System.out.println("Error Opening File.");
		}
		images = new BufferedImage[rows][columns];
		flippedImages = new BufferedImage[rows][columns];
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
		for (int i = 0; i < images.length; i++) {
			for (int j = 0; j < images[i].length; j++) {
				flippedImages[i][j] = mirror(images[i][j]);
			}
		}
	}

	public BufferedImage getImage(int i, int j) 
	{
		return images[i][j];
	}
	
	public BufferedImage getFlippedImage(int i, int j)
	{
		return flippedImages[i][j];
	}
	
	public BufferedImage mirror(BufferedImage image) { //This flips the image
		for (int i = 0; i < image.getWidth() / 2; i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				int tmp = image.getRGB(i, j);
				image.setRGB(i, j, image.getRGB(image.getWidth() - i - 1, j)); //Set the one on the left to the right
				image.setRGB(image.getWidth() - i - 1, j, tmp); //Set the one on the right to the left.
			}
		}
		return image;
	}
}
