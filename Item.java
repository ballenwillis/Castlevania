package castlevania;

import java.awt.image.BufferedImage;

public abstract class Item extends Entity {

	private int itemNum;
	private String itemType;
	private SpriteSheet sheet;
	private BufferedImage image;
	
	public Item(String itemType, SpriteSheet sheet, BufferedImage image)
	{
		super(sheet);
		this.itemType = itemType;
		this.image = image;
	}
	
	public Item(String itemType, SpriteSheet sheet)
	{
		this.itemType = itemType;
		this.sheet = sheet;
	}
	public Item(String itemType, BufferedImage image)
	{
		this.itemType = itemType;
		this.image = image;
	}
	
	
	
}
