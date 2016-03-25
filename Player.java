package castlevania;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity{
	
	private static int counter = 0;
	private int xSprite = 0, ySprite = 0;
	private int x;
	private int y;
	private int spriteRows = 4, spriteCols = 6;
	private final int WIDTH = 128;
	private final int HEIGHT = 128;
	private SpriteSheet sheet;
	private int health;
	private ArrayList<Item> items;
	
	public Player(int x, int y)
	{
		super();
		sheet = new SpriteSheet("belmont_sprite_sheet.jpg", WIDTH, HEIGHT, spriteRows, spriteCols);
		this.x = x;
		this.y = y;
		health = 10;
		items = new ArrayList<Item>(); //for items gathered in game
	}
	
	public BufferedImage changeImages() //CHANGE THIS METHOD!-----------------------------------------------------------
	{
		/*
		 * Might want to have this method access a class level variable
		 * called like *currentSprite*, have it access which image in the array it is
		 * and just add 1 to the y-value to cycle through the images instead of relying on
		 * time. Have it run smooth with the rest of the game.
		 */
		counter++;
		if (counter > 5)
		{
			setX(this.x + 10);
			if (ySprite != spriteRows -1 )
			{
				ySprite++;
			}
			else
			{
				ySprite = 0;
			}
			counter = 0;
			
		}
		return sheet.getImage(xSprite, ySprite);
	}

	public int getX() {
		return x;
	}
	
	public void setX(int _x) {
		this.x = _x;
	}

	public int getY() {
		return y;
	}

	public void setY(int _y) {
		this.y = _y;
	}
	
	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
	
	public void setHealth(int x)
	{
		this.health = x;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}
	
	public void removeItem(Item item)
	{
		items.remove(item);
	}
}