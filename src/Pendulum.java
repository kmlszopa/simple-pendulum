import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pendulum extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private double angle = Math.PI / 2;
	private int length;

	public Pendulum(int length, double angle) {
		this.length = length;
		this.angle = Math.PI / angle;
		setDoubleBuffered(true);
	}

	public void paint(Graphics g) {
		int anchorX = getWidth() / 2, anchorY = getHeight() / 4;
		int ballX = anchorX + (int) (Math.sin(angle) * length);
		int ballY = anchorY + (int) (Math.cos(angle) * length);
		int ballRadious = this.length / 10;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.YELLOW);
		g.drawLine(anchorX, anchorY, ballX, ballY);
		g.setColor(Color.BLACK);
		g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
		g.fillOval(ballX - ballRadious, ballY - ballRadious, ballRadious * 2, ballRadious * 2);
	}

	public void run() {
		double angleAccel, angleVelocity = 0, dt = 0.1;
		while (true) {
			angleAccel = -9.81 / length * Math.sin(angle);
			angleVelocity += angleAccel * dt;
			angle += angleVelocity * dt;
			repaint();
			try {
				Thread.sleep(15);
			} catch (InterruptedException ex) {
			}
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(2 * length + 100, length / 2 * 3);
	}

	public void showPendulum(double titl, int length) {
		JFrame f = new JFrame("Pendulum Example");
		Pendulum p = new Pendulum(length, titl);
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		new Thread(p).start();
	}
}