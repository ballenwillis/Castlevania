package castlevania;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {

	private static final long serialVersionUID = -5471880502989465049L;
	private static int counter = 0;
	private int xSprite = 0, ySprite = 0;
	private int x, velx;
	private int y;
	private final int SPRITEROWS= 4, SPRITECOLS= 6;
	private final int WIDTH = 128;
	private final int HEIGHT = 128;
	private SpriteSheet sheet;
	private int health;
	private ArrayList<Item> items;
	public boolean isRunning = false, isAttacking = false, isStanding = true,
			isJumping = false;

	public Player(int x, int y) {
		super();
		sheet = new SpriteSheet("spritesheets/belmont_sprite_sheet.jpg", WIDTH, HEIGHT,
				SPRITEROWS, SPRITECOLS);
		this.x = x;
		this.y = y;
		health = 10;
		items = new ArrayList<Item>(); // for items gathered in game
		setFocusable(true);
	}

	public BufferedImage changeImages() // CHANGE THIS
										// METHOD!-----------------------------------------------------------
	{
		counter++;
		if (counter > 5) {
			if (isRunning)// I'm going to have images be returned differently
							// depending on what the player is doing. This part
							// is if it's running.
			{
				if (ySprite != SPRITECOLS - 1 && velx != 0) {
					ySprite++;
				} else {
					ySprite = 0;
				}
				counter = 0;
			} else if (isAttacking)// This sprite is for when he's attacking.
			{
				if (isStanding) {
					for (int i = 0; i < 2; i++) {
						return sheet.getImage(1, i);
					}
				} else {
					for (int i = 2; i < 4; i++) {
						return sheet.getImage(1, i);
					}
				}
			}
		}
		this.x += velx;
		
		return sheet.getImage(xSprite, ySprite);
	}

	public void jump() { //Needs to get fixed.
		if (!isJumping) {
			isJumping = true;
			int originalPos = this.y;
			int initYVel = 50;
			int t = 0;
			int acceleration = 1;
			while (true) {
				t++;
				this.y = originalPos;
				this.y += t * (initYVel + ((acceleration * t) / 2));
				if (this.y == originalPos && t != 0)
				{
					break;
				}
			}
			t = 0;
			
			/*
			for (int y = this.getY(); y >= originalPos - 60; y--) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.setY(y);
			}

			for (int y = getY(); y <= originalPos + 5; y++) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setY(y);
			}*/
		}
	}

	public boolean testBelow() {
		// For now this will just return true, but later we will set this up to
		// test for a collision.
		return true;
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

	public void setHealth(int x) {
		this.health = x;
	}

	public int getHealth() {
		return health;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
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
		return SPRITEROWS;
	}
	
	public int getSpriteCols() {
		return SPRITECOLS;
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

	public void setVelx(int x) {
		this.velx = x;
	}

	public int getVelx() {
		return this.velx;
	}
}