package pas.ta20_c4_ejercicio05;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnLimpiar;

	/**
	 * Create the frame.
	 */
	public Vista() {

		// Icono de la aplicación utilizando un una imagen de un enlace externo
		try {
			URL url = new URL("https://pauls23.000webhostapp.com/images/logo1.png");
			Image image = ImageIO.read(url);
			setIconImage(image);
		} catch (MalformedURLException ex) {
			System.out.println("Malformed URL");
		} catch (IOException iox) {
			System.out.println("Can not load file");
		}

		setTitle("Eventos del ratón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(27, 83, 866, 376);
		contentPane.add(textArea);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLimpiar.setBounds(373, 21, 173, 43);
		contentPane.add(btnLimpiar);
		btnLimpiar.addActionListener(actionListener);

		addMouseListener(mouseListener);
		setVisible(true);
	}

	// Listener para el botón de limpiar
	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.selectAll();
			textArea.replaceSelection("");
		}
	};

	// Listener para los eventos del ratón
	MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			textArea.append("- mouseReleased \n");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			textArea.append("- mousePressed \n");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			textArea.append("- mouseExited \n");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			textArea.append("- mouseEntered \n");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			textArea.append("- mouseClicked \n");
		}
	};
}
