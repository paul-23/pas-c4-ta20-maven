package pas.ta20_c4_ejercicio06;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	private JButton btnCalcular;
	private JLabel lblIMC;
	private JLabel lblResultado;
	private double altura = 0, peso = 0, resultado = 0;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("Índice de Masa Corporal");

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

		// Panel de la ventana principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TextField para introducir altura
		textFieldAltura = new JTextField();
		textFieldAltura.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAltura.setFont(new Font("Arial", Font.PLAIN, 21));
		textFieldAltura.setBounds(178, 11, 168, 38);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		textFieldAltura.addActionListener(al);

		JLabel lblAltura = new JLabel("Altura (metros)");
		lblAltura.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAltura.setBounds(24, 10, 144, 38);
		contentPane.add(lblAltura);

		JLabel lblPeso = new JLabel("Peso (Kg)");
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPeso.setBounds(383, 10, 95, 38);
		contentPane.add(lblPeso);

		// TextField para introducir peso
		textFieldPeso = new JTextField();
		textFieldPeso.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPeso.setFont(new Font("Arial", Font.PLAIN, 21));
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(488, 11, 168, 38);
		contentPane.add(textFieldPeso);
		textFieldPeso.addActionListener(al);

		// Botón para calcular el IMC
		btnCalcular = new JButton("Calcular IMC");
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCalcular.setBounds(178, 62, 168, 38);
		contentPane.add(btnCalcular);
		btnCalcular.addActionListener(al);

		lblIMC = new JLabel("IMC:");
		lblIMC.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIMC.setBounds(383, 62, 52, 38);
		contentPane.add(lblIMC);

		// Label donde mostramos el resultado
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 20));
		lblResultado.setBounds(445, 62, 168, 38);
		contentPane.add(lblResultado);

		setVisible(true);
	}

	ActionListener al = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Comprobamos que los campos de texto no esten vacios
			if (textFieldAltura.getText().isEmpty()) {
				JOptionPane.showMessageDialog(contentPane, "No has introducido los datos de altura");
			} else if (textFieldPeso.getText().isEmpty()) {
				JOptionPane.showMessageDialog(contentPane, "No has introducido los datos de peso");
			} else {
				// Si no estan vacios calculamos y mostramos el resultado del IMC
				altura = Double.parseDouble(textFieldAltura.getText());
				peso = Double.parseDouble(textFieldPeso.getText());
				resultado = peso / (altura * altura);
				lblResultado.setText(String.valueOf(resultado));
			}
		}
	};
}
