package castlevania;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable, KeyListener {

	private final int WIDTH = 800, HEIGHT = 600;
	private boolean running = false;
	private Player p;
	private Graphics g;
	private GUI gui;
	private boolean aIsDown = false, wIsDown = false, sIsDown = false,
			dIsDown = false;
	
	private Level[] levels = { 
			new Level("levels/level1bg.png", new Audio("music/vampirekiller.wav")) 
			};
	
	private int oldHealth, loop = 0;
	
	public Game() {
		p = new Player(0, HEIGHT - 128);
		oldHealth = p.getHealth();
		gui = new GUI();
		setSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		add(gui);
		setLocationRelativeTo(null);
		setFocusable(true);
		setResizable(false);
		pack();
		setVisible(true);
		addKeyListener(this);
	}

	public void start() {
		run();
	}

	public void run() {
		running = true;

		while (running) {
			try {
				Thread.sleep(17);
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//repaint();
		}
	}

	public void stop() {
		running = false;
	}

	public void keyPressed(KeyEvent e) {
		p.isRunning = false;
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_W:
			wIsDown = true;
			if(p.clearBelow() && !p.isJumping)
				p.resetTime(); //Using v = v_i + a*t for velocity, so need to reset time.
				p.jump();
			break;
		/*case KeyEvent.VK_S:
			sIsDown = true;
			p.setY(p.getY() + 10);
			break;
			*
			* This is commented out because we don't need 'S' to do anything yet.
			*/
		case KeyEvent.VK_A:
			aIsDown = true;
			p.isStanding = false;
			p.setDirection(-1);
			break;
		case KeyEvent.VK_D:
			dIsDown = true;
			p.isStanding = false;
			p.setDirection(1);
			break;
		case KeyEvent.VK_SPACE:
			Audio whip1 = new Audio("soundeffects/whip1.wav");
			whip1.play();
			break;
		}
		if (aIsDown || dIsDown) {
			p.isRunning = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int i = e.getKeyCode();
		switch (i) {
		case KeyEvent.VK_A:
			aIsDown = false;
			break;
		case KeyEvent.VK_D:
			dIsDown = false;
			break;
		case KeyEvent.VK_W:
			wIsDown = false;
			break;
		case KeyEvent.VK_S:
			sIsDown = false;
			break;
		}
		if (!aIsDown && !dIsDown) //This is where I have to fix things. Along with the below if statement.
		{
			if (!p.isJumping)
			{
				p.isRunning = false;
				p.isStanding = true;
			}
		}
		
		if ((aIsDown || dIsDown) && !p.isJumping)
		{
			System.out.println("This is happening");
			p.isRunning = true;
			//p.setVelx(p.);
			p.isStanding = false; //Changed this.
		}
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int newHealth = p.getHealth();
		p.changeImages();
		//g.drawImage(image, p.getX(), p.getY(), null);
		p.paintComponent(g);
		
		if (newHealth != oldHealth || loop == 0)
		{
			gui.paintComponent(g);
		}
		loop++;

		pack();
		
		repaint();
	}
	
	/*@Override
	public void paint(Graphics g) {
		int newHealth = p.getHealth();
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(p.getX() + ", " + p.getY());
		if (loop == 0)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			p.paintComponent(g);
			gui.paintComponent(g);
		}
		
		if (newHealth != oldHealth)
		{
			gui.setPlayerHealth(newHealth);
			gui.paintComponent(g);
		}
		p.paintComponent(g);
		loop++;
		repaint();
	}*/

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
}