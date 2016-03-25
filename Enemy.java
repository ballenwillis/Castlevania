package castlevania;

public abstract class Enemy extends Entity {

	private int x;
	private int y;
	private final int WIDTH;
	private final int HEIGHT;
	private SpriteSheet sheet;
	
	public Enemy(int x, int y, int WIDTH, int HEIGHT, SpriteSheet SHEET)
	{
		super(x, y, SHEET);
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
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
		return sheet;
	}
	
	
}
