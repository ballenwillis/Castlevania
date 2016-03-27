package castlevania;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity implements KeyListener{
	
	private static final long serialVersionUID = -5471880502989465049L;
	private static int counter = 0;
	private int xSprite = 0, ySprite = 0;
	private int x, velx;
	private int y;
	private int spriteRows = 4, spriteCols = 6;
	private final int WIDTH = 128;
	private final int HEIGHT = 128;
	private SpriteSheet sheet;
	private int health;
	private ArrayList<Item> items;
	public boolean isRunning = false, isAttacking = false;
	
	public Player(int x, int y)
	{
		super();
		sheet = new SpriteSheet("belmont_sprite_sheet.jpg", WIDTH, HEIGHT, spriteRows, spriteCols);
		this.x = x;
		this.y = y;
		health = 10;
		items = new ArrayList<Item>(); //for items gathered in game
		setFocusable(true);
	}
	
	public BufferedImage changeImages() //CHANGE THIS METHOD!-----------------------------------------------------------
	{
		counter++;
		if (counter > 5)
		{
			if (isRunning)//I'm going to have images be returned differently depending on what the player is doing. This part is if it's running.
			{
				if (ySprite != spriteRows -1 && velx != 0)
				{
					ySprite++;
				}
				else
				{
					ySprite = 0;
				}
				counter = 0;
			}
			else if (isAttacking)//This sprite is for when he's attacking.
			{
				
			}
		}
		this.x += velx;
		return sheet.getImage(xSprite, ySprite);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Player.counter = counter;
	}

	public int getxSprite() {
		return xSprite;
	}

	public void setxSprite(int xSprite) {
		this.xSprite = xSprite;
	}

	public int getySprite() {
		return ySprite;
	}

	public void setySprite(int ySprite) {
		this.ySprite = ySprite;
	}

	public int getSpriteRows() {
		return spriteRows;
	}

	public void setSpriteRows(int spriteRows) {
		this.spriteRows = spriteRows;
	}

	public int getSpriteCols() {
		return spriteCols;
	}

	public void setSpriteCols(int spriteCols) {
		this.spriteCols = spriteCols;
	}
	
	@Override
	public SpriteSheet getSheet() {
		return sheet;
	}
	
	@Override
	public void setSheet(SpriteSheet sheet) {
		this.sheet = sheet;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setVelx(int x)
	{
		this.velx = x;
	}
	
	public int getVelx()
	{
		return this.velx;
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}