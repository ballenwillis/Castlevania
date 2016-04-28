package castlevania;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {

	private static final long serialVersionUID = -5471880502989465049L;
	private static int counter = 0;
	private int xSprite = 0, ySprite = 0;
	private int x, velx;

	private BufferedImage currentImage;
	
	private int y, vely, velyInit = 15, accel = -20, t = 0, direction = 1; //Should be 1

	private final int SPRITEROWS = 4, SPRITECOLS = 6, WIDTH = 128, HEIGHT = 128, RUNSPEED = 10; //RUNSPEED = 10;
	private SpriteSheet sheet;
	private int health;
	private ArrayList<Item> items;
	public boolean isRunning = false, isAttacking = false, isStanding = true, isJumping = false;

	public Player(int x, int y) {
		super();
		sheet = new SpriteSheet("spritesheets/belmont_sprite_sheet.jpg", WIDTH, HEIGHT, SPRITEROWS, SPRITECOLS);
		currentImage = sheet.getImage(0, 0);
		this.x = x;
		this.y = y;
		health = 10;
		items = new ArrayList<Item>(); // for items gathered in game
		setFocusable(true);
	}

	public void resetTime() {
		this.t = 0;
	}

	public BufferedImage changeImages() // CHANGE THIS
										// METHOD!-----------------------------------------------------------
	{	
		counter++;
		if (isJumping) { //This probably needs to go in the counter.
			if (clearBelow()) {
				jump();
			} else {
				vely = 0;
				isJumping = false;
				xSprite = 0;
				ySprite = 0;
			}
		}

		if (counter >= 5) { //Should be 5
			if (isJumping) {
				xSprite = 0;
				ySprite = 5;
			} 
			else if (isStanding)
			{
				setVelx(0);
				xSprite = 0;
				ySprite = 0;
			}
			else if (isRunning) // I'm going to have images be returned
									// differently
			// depending on what the player is doing. This part
			// is if it's running.
			{
				xSprite = 0;
				setVelx(RUNSPEED * direction);
				if (ySprite != SPRITECOLS - 1 && velx != 0) {
					ySprite++;
				} else {
					ySprite = 0;
				}
			} 
			
			else if (isAttacking) // This sprite is for when he's attacking.
			{
				xSprite = 1; // Both of the attacks are in the same row.
				if (isStanding) {
					for (int i = 0; i < 2; i++) { // Also modified this to
													// appropriately change
													// xSprite
													// And ySprite instead of
													// returning
													// The image
						if (ySprite == 0) {
							ySprite = 1;
						} else {                    //This will not work
							ySprite = 0;
						}
					}
				} else {
					for (int i = 2; i < 4; i++) {
						return sheet.getImage(1, i); //This will not work
					}
				}
			}
			System.out.println(direction);
			if (direction == 1)
			{
				System.out.println("Going right");
				currentImage = sheet.getImage(xSprite, ySprite);
				//return sheet.getImage(xSprite, ySprite); // Faces right if he's
			}												// going right.
			else //if (direction == -1)
			{
				System.out.println("This should print");
				currentImage = sheet.getFlippedImage(xSprite, ySprite);
				//return sheet.getFlippedImage(xSprite, ySprite); // Faces left if
			}
			counter = 0;
		}
		this.x += velx;
		this.y += vely;
		return currentImage;
	
	}

	public boolean clearBelow() // Modify later to make it check below for
								// platforms.
	{
		if (this.y + HEIGHT > 600) {
			this.y = 600 - HEIGHT;
			return false;
		}
		return true;
	}

	public boolean clearAbove() {
		return true;
	}

	/*public BufferedImage mirror(BufferedImage image) {
		for (int i = 0; i < image.getWidth() / 2; i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				int tmp = image.getRGB(i, j);
				image.setRGB(i, j, image.getRGB(image.getWidth() - i - 1, j)); //Set the one on the left to the right
				image.setRGB(image.getWidth() - i - 1, j, tmp); //Set the one on the right to the left.
			}
		}
		return image;
	}*/

	public void jump() { // Needs to get fixed.
		// v = vi + at ---- Physics ----
		isJumping = true;
		t++;
		if (t % 4 == 0) {
			vely = (int) ((velyInit + accel * ((double) (t / 30.0))) * -1);
			System.out.println(vely);
		}
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	public boolean onGround() {
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