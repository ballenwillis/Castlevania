package castlevania;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Level extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8421850790282934351L;
	private BufferedImage image;
	private boolean loading;
	private boolean won;
	private Audio music;
	private JLabel background;
	private int x;
	private int y;
	private ArrayList<Entity> obstacles;
	
	public Level(String level, Audio music)
	{
		try{
		this.image = ImageIO.read(new File(level));
		}catch(Exception e){System.out.println("ERROR: LEVEL FILE NOT FOUND.");}
		this.obstacles = new ArrayList<Entity>();
		this.music = music;
		this.x = 0;
		this.y = 0;
		music.play();
		
	}
	public Level(String level)
	{
		try{
		this.image = ImageIO.read(new File(level));
		}catch(Exception e){System.out.println("ERROR: LEVEL FILE NOT FOUND.");}
		this.obstacles = new ArrayList<Entity>();
		this.x = 0;
		this.y = 0;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0,0,null);
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
	
	public void addObstacle(Object obj)
	{
		obstacles.add((Entity) obj);
	}
	
	public void removeObstacle(Object obj)
	{
		obstacles.remove(obj);
	}
	
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	
	
	
}
