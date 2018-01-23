import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame implements ActionListener {
	private JFrame frame;
	private JButton startButton;
	private JTextField lenghtTextField;
	private JTextField angleTextField;
	private double angle = Math.PI / 2;
	private int length;
	private Pendulum pendulum;

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.buildGui();

	}

	public void buildGui() {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(400, 200);

		this.startButton = new JButton();
		this.startButton.setText("Start");
		this.startButton.addActionListener(this);

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1, 2));
		jp.add(startButton);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 1));

		this.lenghtTextField = new JTextField("Podaj d³ugoœæ");
		this.angleTextField = new JTextField("Podaj wychylenie");

		jp2.add(this.lenghtTextField);
		jp2.add(this.angleTextField);
		jp2.add(jp);

		this.frame.add(jp2);
		this.frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent action) {
		if (action.getSource() == startButton) {
			if (isNumeric(this.lenghtTextField.getText())) {
				this.length = Integer.parseInt(this.lenghtTextField.getText());
				if (isNumeric(this.angleTextField.getText())) {
					this.angle = Double.parseDouble(this.angleTextField.getText());
					if (this.pendulum != null) {
						this.pendulum.getFrame().setVisible(false);
						this.pendulum = null;
					}

					this.pendulum = new Pendulum(this.length, this.angle);
					this.pendulum.showPendulum(this.angle, this.length);
				} else {
					this.angleTextField.setText("Podaj wychylenie");
				}
			} else {
				this.lenghtTextField.setText("Podaj d³ugoœæ");
			}

		}
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}