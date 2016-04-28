package castlevania;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
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
				BufferedImage img = this.spriteSheet.getSubimage(x, y, width, height);
				images[i][j] = img; //this.spriteSheet.getSubimage(x, y, width, height);
				flippedImages[i][j] = createFlipped(createRotated(this.spriteSheet.getSubimage(x, y, width, height))); //This is the way to go.
				x += width;
			}
			y += height;
		}
				 
		/*for (int i = 0; i < images.length; i++) {
			for (int j = 0; j < images[i].length; j++) {
				flippedImages[i][j] = getImage(i, j);
			}
		}
		
		for (int i = 0; i < flippedImages.length; i++) {
			for (int j = 0; j < flippedImages[i].length; j++) {
				flippedImages[i][j] = mirror(flippedImages[i][j]);
			}
		}*/
	}
	
	private static BufferedImage createRotated(BufferedImage image)
    {
        AffineTransform at = AffineTransform.getRotateInstance(
            Math.PI, image.getWidth()/2, image.getHeight()/2.0);
        return createTransformed(image, at);
    }    
	
	private static BufferedImage createFlipped(BufferedImage image)
    {
        AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
        return createTransformed(image, at);
    }

	
	private static BufferedImage createTransformed(
	        BufferedImage image, AffineTransform at)
	    {
	        BufferedImage newImage = new BufferedImage(
	            image.getWidth(), image.getHeight(),
	            BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g = newImage.createGraphics();
	        g.transform(at);
	        g.drawImage(image, 0, 0, null);
	        g.dispose();
	        return newImage;
	    }

	public BufferedImage getImage(int i, int j) 
	{
		return images[i][j];
	}
	
	public BufferedImage getFlippedImage(int i, int j)
	{
		return flippedImages[i][j];
	}
	
	public static BufferedImage mirror(BufferedImage image) { //This flips the image
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
