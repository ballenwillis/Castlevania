package castlevania;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Enemy extends Entity {

	private static final long serialVersionUID = 2003297664785729009L;
	private int x;
	private int y;
	private final int WIDTH;
	private final int HEIGHT;
	private SpriteSheet SHEET;
	private BufferedImage image;
	
	public Enemy(int x, int y, int WIDTH, int HEIGHT, SpriteSheet sheet)
	{
		super(x, y, sheet);
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}
	
	public Enemy(int x, int y, int WIDTH, int HEIGHT, BufferedImage image)
	{
		this.x = x;
		this.y = y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		try{
			this.image = ImageIO.read(new File("image/"+image));
		}catch(IOException e)
		{
			System.out.println("ERROR: IMAGE FOR ENEMY NOT FOUND.");
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public SpriteSheet getSHEET() {
		return SHEET;
	}
	
	
}
