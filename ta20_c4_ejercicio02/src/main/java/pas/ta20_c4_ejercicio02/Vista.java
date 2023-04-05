package pas.ta20_c4_ejercicio02;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	protected JButton btn1, btn2;

	public Vista() {

		// Cambiamos el icono de la aplicación utilizando un una imagen de un enlace externo
		try {
			URL url = new URL("https://pauls23.000webhostapp.com/images/logo1.png");
			Image image = ImageIO.read(url);
			setIconImage(image);
		} catch (MalformedURLException ex) {
			System.out.println("Malformed URL");
		} catch (IOException iox) {
			System.out.println("Can not load file");
		}

		setTitle("Ventana con interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Pulsa un botón");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel.setBounds(89, 25, 301, 60);
		contentPane.add(lblNewLabel);

		btn1 = new JButton("Button 1");
		btn1.setBounds(89, 82, 147, 42);
		contentPane.add(btn1);
		btn1.addActionListener(al);

		btn2 = new JButton("Button 2");
		btn2.setBounds(243, 82, 147, 42);
		contentPane.add(btn2);
		btn2.addActionListener(al);

		setVisible(true);
	}

	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			lblNewLabel.setText("Has pulsado: " + source.getText());
		}
	};
	
}
