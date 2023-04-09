package pas.ta20_c4_ejercicio08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final double TASA_CAMBIO = 166.386;

	private JPanel contentPane;
	private JToggleButton tglbtnSelectorMoneda;
	private JButton btnCambiar;
	private JLabel lblresultadoTotal;
	private double cambioResultado = TASA_CAMBIO;
	private JTextField textField;
	private JButton btnBorrar;

	public Vista() {
		setTitle("Calculadora cambio de monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tglbtnSelectorMoneda = new JToggleButton("Euros a ptas", false);
		tglbtnSelectorMoneda.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tglbtnSelectorMoneda.setBounds(67, 67, 150, 39);
		contentPane.add(tglbtnSelectorMoneda);

		JLabel lblNewLabel = new JLabel("Cantidad a convertir");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(21, 22, 183, 34);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(204, 17, 150, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(calcular);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblResultado.setBounds(364, 22, 94, 34);
		contentPane.add(lblResultado);

		lblresultadoTotal = new JLabel("0.0");
		lblresultadoTotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblresultadoTotal.setBounds(468, 20, 139, 39);
		contentPane.add(lblresultadoTotal);

		btnCambiar = new JButton("Cambiar");
		btnCambiar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCambiar.setBounds(234, 67, 150, 39);
		contentPane.add(btnCambiar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBorrar.setBounds(394, 67, 150, 39);
		contentPane.add(btnBorrar);
		tglbtnSelectorMoneda.addActionListener(cb);
		btnCambiar.addActionListener(calcular);
		btnBorrar.addActionListener(borrar);

		setVisible(true);
	}

	// Calcular el resultado total del cambio de moneda
	ActionListener borrar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setText("");
			lblresultadoTotal.setText("0.0");
		}
	};

	// Calcular el resultado total del cambio de moneda
	ActionListener calcular = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Comprobamos que el campo no esté vacío
			if (textField.getText().isEmpty()) {
				JLabel label = new JLabel("<html><h1>Has dejado el campo en blanco</h1></html>"); // Imagen de victoria
				label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
				JOptionPane.showMessageDialog(contentPane, label, "Introduce un valor",
						JOptionPane.INFORMATION_MESSAGE);
			// Comprobamos que el valor introducido sea mayor que 0
			} else if (Double.parseDouble(textField.getText()) <= 0) {
				JLabel label = new JLabel("<html><h1>Introduce un valor mayor que 0</h1></html>"); // Imagen de victoria
				label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
				JOptionPane.showMessageDialog(contentPane, label, "Valor incorrecto",
						JOptionPane.INFORMATION_MESSAGE);
			// Si esta todo correcto, calculamos y mostramos el resultado por pantalla
			} else {
				double dinero = Double.parseDouble(textField.getText());
				dinero = dinero * cambioResultado;
				lblresultadoTotal.setText(Double.toString(dinero));
			}
		}
	};

	// Cambio de dirección en la selección de la moneda
	// De euros a pesetas o vicevessa
	ActionListener cb = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JToggleButton boton = (JToggleButton) e.getSource();
			if (boton.isSelected()) {
				boton.setText("Ptas a Euros");
				cambioResultado = 1 / TASA_CAMBIO;
			} else {
				boton.setText("Euros a ptas");
				cambioResultado = TASA_CAMBIO;
			}
		}
	};
}
