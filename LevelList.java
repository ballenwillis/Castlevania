package castlevania;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JComponent;

public class LevelList extends JComponent{

	private static final long serialVersionUID = -6094887890667371175L;
	private ArrayList<Level> levels;
	private Image img;
	
	public LevelList()
	{
		levels = new ArrayList<Level>();
		
		levels.add(new Level("levels/level1bg.png",new Audio("music/vampirekiller.wav")));
		//levels.add(new Level("levels/level2bg.png",new Audio("music/monsterdance.wav")));
		
	}
	
	public Level loadLevel(int level)
	{
		img = Toolkit.getDefaultToolkit().createImage(levels.get(level).getLevelName());
		return levels.get(level);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img,0,0,null);
	}
	
	
}
