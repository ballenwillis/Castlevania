package castlevania;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level {

	private BufferedImage image;
	private boolean load;
	
	public Level(String level)
	{
		try {
			this.setImage(ImageIO.read(new File(level)));
		} catch (IOException e) {

			System.out.println("Error Opening File.");
		}
		
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public boolean isLoading()
	{
		return load;
	}
}
