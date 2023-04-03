package pas.ta20_c4_ejercicio01;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ejercicio01 extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Ejercicio01() {
		
        try {
        	URL url = new URL("https://pauls23.000webhostapp.com/images/logo1.png");
            Image image = ImageIO.read(url);
            setIconImage(image);
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException iox) {
            System.out.println("Can not load file");
        }
		
		setTitle("TA20 - Ejercicio 01 - Paul");
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Ejercicio 01 - Paul");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
	}

}
