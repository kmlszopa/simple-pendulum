import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame implements ActionListener {
	private JFrame ramka;
	private JButton startButton;
	private JTextField lenghtTextField;
	private JTextField tiltTextField;
	private double angle = Math.PI / 2;
	private int length;
	private Pendulum pendulum;

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.zbudujGUI();

	}

	public void zbudujGUI() {
		this.ramka = new JFrame();
		this.ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ramka.setSize(400, 200);

		this.startButton = new JButton();
		this.startButton.setText("Witaj!");
		this.startButton.addActionListener(this);

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1, 2));
		jp.add(startButton);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 1));

		this.lenghtTextField = new JTextField("D³ugoœæ");
		this.tiltTextField = new JTextField("Wychylenie");
		// rezultatJL = new JLabel();
		// rezultatJL.setSize(400,20);

		jp2.add(this.lenghtTextField);
		jp2.add(this.tiltTextField);
		// jp2.add(rezultatJL);
		jp2.add(jp);
		this.ramka.add(jp2);
		this.ramka.setVisible(true);
	}

	public void actionPerformed(ActionEvent akcja) {
		if (akcja.getSource() == startButton) {
			// modyfikujemy komponent, zmieniaj¹c tekst
			this.length = Integer.parseInt(this.lenghtTextField.getText());
			this.angle = Double.parseDouble(this.tiltTextField.getText());
			this.pendulum = new Pendulum(this.length, this.angle);
			this.pendulum.showPendulum(this.angle, this.length);
		}
			
 
	}

}