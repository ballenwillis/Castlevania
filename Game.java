package castlevania;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game implements Runnable, KeyListener {

	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private boolean running = false;
	private JFrame frame;
	private Player p;
	private boolean aIsDown = false, wIsDown = false, sIsDown = false,
			dIsDown = false;

	public Game() {
		frame = new JFrame();
		frame.setSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.add(new GUI());

	}

	public void start() {
		run();
	}

	public void run() {
		running = true;
		p = new Player(0, HEIGHT - 128);

		while (running) {
			try {
				Thread.sleep(17);
				BufferedImage image = p.changeImages();
				Graphics g = frame.getGraphics();
				g.drawImage(image, p.getX(), p.getY(), null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		running = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_W:
			p.setY(p.getY() - 10);
			break;
		case KeyEvent.VK_S:
			p.setY(p.getY() + 10);
			break;
		case KeyEvent.VK_A:
			aIsDown = true;
			p.setVelx(-10);
			break;
		case KeyEvent.VK_D:
			dIsDown = true;
			p.setVelx(10);
			break;
		}
	}

	public boolean movingLeftOrRight() {
		if (aIsDown == true || dIsDown == true) {
			p.isRunning = true;
			return true;
		}
		return false;
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

		if (!movingLeftOrRight())
			p.setVelx(0);
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public JFrame getFrame() {
		return frame;
	}
}