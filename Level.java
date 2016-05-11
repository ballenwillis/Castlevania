package castlevania;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Level extends JComponent{

	private BufferedImage image;
	private boolean loading;
	private boolean won;
	private Audio music;
	private ArrayList<Entity> obstacles;
	
	public Level(String level, Audio music)
	{
		try {
			this.setImage(ImageIO.read(new File(level)));
		} catch (IOException e) {

			System.out.println("Error Opening Level File.");
		}
		
		this.obstacles = new ArrayList<Entity>();
		this.music = music;
		music.play();
		
	}
	public void loadLevel(int index)
	{
		
	}
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public boolean isLoading()
	{
		return loading;
	}
	public void setLoading(boolean loading)
	{
		this.loading = loading;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public Audio getMusic() {
		return music;
	}

	public void setMusic(Audio music) {
		this.music = music;
	}
	
	public void addObstacle(Entity obj)
	{
		obstacles.add(obj);
	}
	
	public void removeObstacle(Entity obj)
	{
		obstacles.remove(obj);
	}
	
	
	
}