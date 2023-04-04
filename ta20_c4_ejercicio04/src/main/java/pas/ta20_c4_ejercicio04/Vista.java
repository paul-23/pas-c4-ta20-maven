package pas.ta20_c4_ejercicio04;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class Vista extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private String textoEventos = "";
	private JTextArea textArea;
	
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eventos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(26, 11, 138, 59);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(26, 81, 473, 474);
		contentPane.add(textArea);
		
		addWindowListener(this);
		setVisible(true);
	}
	
	public void windowActivated(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana activada\n");

	}

	public void windowClosed(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana cerrada\n");

	}

	public void windowClosing(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana cerrándose\n");

	}

	public void windowDeactivated(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana desactivada\n");

	}

	public void windowDeiconified(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana desiconizada\n");

	}

	public void windowIconified(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana iconizada\n");

	}

	public void windowOpened(WindowEvent e) {
		textArea.append(textoEventos + "- Ventana abierta\n");

	}
}
