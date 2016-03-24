package Caslevania;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game implements Runnable{

	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private boolean running = false;
	private JFrame frame;
	private static long frames;
	
	public Game()
	{
		frame = new JFrame();
		frame.setSize(new Dimension(800,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void start()
	{
		run();
	}

	public void run() {
		running = true;
		Player p = new Player(50,50);
		while(running)
		{
			try {
				Thread.sleep(17);
				frames = System.currentTimeMillis() / 100000000;
				BufferedImage image = p.changeImages();
				Graphics g = frame.getGraphics();
				g.drawImage(image, p.getX(), p.getY(), null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void stop()
	{
		running = false;
	}
	
	public static long getFrames()
	{
		return frames;
	}
}
