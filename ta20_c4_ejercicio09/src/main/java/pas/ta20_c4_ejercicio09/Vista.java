package pas.ta20_c4_ejercicio09;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	private ArrayList<Color> colores;
	private ArrayList<JButton> buttons;
	private int movimientosTotal;
	private JButton primerBoton;
	private JButton secondButton;
	private Color[] COLORES_DISPONIBLES = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE,
			Color.MAGENTA, Color.BLACK, Color.GRAY };

	public Vista() {
		setTitle("Juego de formar parejas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 4));

		// Crear los colores para las cartas
		colores = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			colores.add(COLORES_DISPONIBLES[i]);
			colores.add(COLORES_DISPONIBLES[i]);
		}
		// Mezclamos los colroes para que no salgan las mismas combinaciones siempre
		Collections.shuffle(colores);

		// Crear los botones y añadirlos a la ventana
		buttons = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			JButton button = new JButton();
			button.addActionListener(al);
			buttons.add(button);
			add(button);
		}
		setSize(700, 700);
		setVisible(true);
	}

	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();

			if (primerBoton == null) {
				// Es la primera carta que se comprueba
				button.setBackground(colores.get(buttons.indexOf(button)));
				// Mostramos su color por pantalla
				primerBoton = button;
			} else if (secondButton == null && button != primerBoton) {
				// Es la segunda carta que se comprueba
				button.setBackground(colores.get(buttons.indexOf(button)));
				// Mostramos su color por pantalla
				secondButton = button;
				movimientosTotal++;

				if (colores.get(buttons.indexOf(primerBoton)).equals(colores.get(buttons.indexOf(secondButton)))) {
					// Las dos cartas son del mismo color
					primerBoton.setEnabled(false);
					secondButton.setEnabled(false);
					primerBoton = null;
					secondButton = null;

					// Verificamos si hemos ganado
					// Recorremos todos los botones y comprobamos si hay alguno activo
					// Si no es así, mostramos mensaje de victoria
					boolean todosAcertaos = true;
					for (JButton b : buttons) {
						if (b.isEnabled()) {
							todosAcertaos = false;
							break;
						}
					}
					if (todosAcertaos) {
						JOptionPane.showMessageDialog(getContentPane(),
								"¡Felicidades! ¡Has ganado en " + movimientosTotal + " movimientos!");
					}
				} else {
					// Las dos cartas son de diferente color
					// Si son diferentes damos 1 segundo para mostrar las cartas seleccionadas
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException ex) {
							}
							// A continuación se elimina el color y vuelven al estado inicial
							primerBoton.setBackground(null);
							secondButton.setBackground(null);
							primerBoton = null;
							secondButton = null;
						}
					}).start();
				}
			}
		}
	};
}