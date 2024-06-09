package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * La clase CrearCuenta implementa una interfase que ayuda al usuario con la
 * creación de cuenta Al ser un extends JFRAME se utiliza para crear una ventana
 * con características estándar de una ventana de aplicación gráfica (GUI).
 */

public class CrearCuenta extends JFrame {
	// --------------------------------------------------------
	// Atributos
	// --------------------------------------------------------

	private JTextField textField_Usuario;
	private JTextField textField_Contrasenia;
	private JTextField textField_CI;
	private JLabel lblNewLabel_NumCuenta;
	Random random = new Random(); // Crea una instancia de la clase Random
	private int generadorNumCuenta = 10000 + random.nextInt(90000); // Genera un número aleatorio entre 10000 y 99999

	private JTextField textFieldActivo; // JTextField activo
	private int contadorUsuarios;
	private JTextField mensajeLabel = new JTextField();// guarda el mensaje que emerge en caso de que el usuario no haya
														// llenado sus datos

	private JButton btn_crearCuenta;
	private static int contadorCuentas;
	private String usuario;
	private String contrasenia;
	private String ci;
	private String numCuenta;

	/**
	 * Dentro del método constructor creamos toda la parte gráfica del programa que
	 * contiene: JLabels para enseñar textos JTextField para que el usuario ingrese
	 * texto interactuando con el programa Un teclado con botones que contienen
	 * números del 0 al 9 los cuales funcionan al tener contacto con ellos se
	 * escribe en el JTextField que selecciones Botones para "Aceptar", "Borrar",
	 * "Cancelar", "Iniciar sesión" y Salir
	 */
	public CrearCuenta() {

		setSize(900, 800);// definimos el tamaño de mi ventana
		getContentPane().setBackground(new Color(37, 37, 37));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(120, 171, 165));
		panel.setBounds(10, 11, 827, 696);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(37, 37, 37));
		panel_1.setBounds(10, 413, 807, 245);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setBounds(10, 11, 553, 221);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JButton btn_1 = new JButton("1");
		btn_1.setBounds(27, 11, 89, 38);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "1"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_1);

		JButton btn_4 = new JButton("4");
		btn_4.setBounds(27, 60, 89, 38);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "4"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_4);

		JButton btn_7 = new JButton("7");
		btn_7.setBounds(27, 109, 89, 38);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "7"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_7);

		JButton btn_2 = new JButton("2");
		btn_2.setBounds(126, 11, 89, 38);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "2"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_2);

		JButton btn_5 = new JButton("5");
		btn_5.setBounds(126, 60, 89, 38);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "5"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_5);

		JButton btn_8 = new JButton("8");
		btn_8.setBounds(126, 109, 89, 38);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "8"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_8);

		JButton btn_3 = new JButton("3");
		btn_3.setBounds(225, 11, 89, 38);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "3"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_3);

		JButton btn_6 = new JButton("6");
		btn_6.setBounds(225, 60, 89, 38);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "6"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_6);

		JButton btn_9 = new JButton("9");
		btn_9.setBounds(225, 109, 89, 38);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "9"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_9);

		JButton btn_0 = new JButton("0");
		btn_0.setBounds(126, 158, 89, 38);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "0"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_0);

		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(418, 11, 114, 38);
		btn_cancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				borrarTodo();

			}
		});
		panel_7.add(btn_cancelar);

		JButton btn_borrar = new JButton("Borrar");
		btn_borrar.setBounds(418, 60, 114, 38);
		btn_borrar.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su
															// acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				borrarNumero(); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_borrar);

		btn_crearCuenta = new JButton("Aceptar");
		btn_crearCuenta.setBounds(418, 109, 114, 38);
		btn_crearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faltanDatos();
			}
		});
		panel_7.add(btn_crearCuenta);

		JButton btn_ingresar = new JButton("Salir");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		btn_ingresar.setBounds(668, 194, 129, 38);
		panel_1.add(btn_ingresar);

		JButton btn_registrarse = new JButton("Iniciar sesión");
		btn_registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Registro registro = new Registro();
				registro.setVisible(true);
			}
		});
		btn_registrarse.setBounds(668, 145, 129, 38);
		panel_1.add(btn_registrarse);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBackground(new Color(37, 37, 37));
		panel_3.setBounds(10, 81, 807, 321);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(228, 228, 228));
		panel_5.setBounds(10, 11, 552, 299);
		panel_3.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(26, 72, 498, 201);
		panel_5.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(210, 255, 204));
		panel_6.setBounds(10, 38, 478, 152);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(20, 26, 64, 14);
		panel_6.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("PIN");
		lblNewLabel_1_1.setBounds(20, 76, 104, 14);
		panel_6.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Carnet de Identidad:");
		lblNewLabel_1_2.setBounds(20, 101, 124, 14);
		panel_6.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Número de usuario:");
		lblNewLabel_1_1_1.setBounds(20, 51, 124, 14);
		panel_6.add(lblNewLabel_1_1_1);

		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(167, 26, 230, 14);
		// Agregar un MouseListener al primer JTextField para detectar clics de ratón
		textField_Usuario.addMouseListener(new MouseAdapter() {
			// Método que se ejecuta cuando se hace clic en el primer JTextField
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = textField_Usuario; // Asignar el primer JTextField como activo
			}
		});
		panel_6.add(textField_Usuario);

		textField_Contrasenia = new JTextField();
		textField_Contrasenia.setBounds(167, 76, 230, 14);
		// Agregar un MouseListener al textField_Contraseña para detectar clics de ratón
		textField_Contrasenia.addMouseListener(new MouseAdapter() {
			// Método que se ejecuta cuando se hace clic en el textField_Contraseña
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = textField_Contrasenia; // Asignar el textField_Contraseña como activo
			}
		});
		panel_6.add(textField_Contrasenia);

		textField_CI = new JTextField();
		textField_CI.setBounds(167, 101, 230, 14);
		// Agregar un MouseListener al primer JTextField para detectar clics de ratón
		textField_CI.addMouseListener(new MouseAdapter() {
			// Método que se ejecuta cuando se hace clic en el primer JTextField
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = textField_CI; // Asignar el primer JTextField como activo
			}
		});
		panel_6.add(textField_CI);

		lblNewLabel_NumCuenta = new JLabel(Integer.toString(generadorNumCuenta));
		lblNewLabel_NumCuenta.setBounds(167, 51, 230, 14);
		panel_6.add(lblNewLabel_NumCuenta);

		JLabel lblNewLabel_1_3 = new JLabel("Por favor ingrese sus datos:");
		lblNewLabel_1_3.setBounds(10, 13, 241, 14);
		panel_4.add(lblNewLabel_1_3);

		JLabel lblInicio = new JLabel("CREAR CUENTA");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.LIGHT_GRAY);
		lblInicio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInicio.setBackground(Color.LIGHT_GRAY);
		lblInicio.setBounds(26, 21, 498, 40);
		panel_5.add(lblInicio);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 807, 59);
		panel.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("CAJERO AUTOMATICO");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(97, 11, 633, 40);
		panel_2.add(lblNewLabel);

		// LECTURA DE DATOS DEL .txt Inicializamos el contador leyendo el valor del
		// archivo de configuración
		try {
			BufferedReader reader = new BufferedReader(new FileReader("configuracion.txt"));
			String linea = reader.readLine();
			if (linea != null) {
				contadorCuentas = Integer.parseInt(linea);
			} else {
				contadorCuentas = 0; // Si el archivo está vacío, empezamos desde cero
			}
			reader.close();
		} catch (IOException e) {
			contadorCuentas = 0; // Si ocurre algún error al leer el archivo, empezamos desde cero
		}
	}

	/**
	 * El metodo leerContador abre un BufferedReader que se utiliza para leer texto
	 * de un flujo de entrada de caracteres desde el archivo "contador.txt". Si
	 * abrimos y leemos el archivo llamado "contador.txt" se lee la primera línea
	 * para guardarlo en la variable String linea y verificamos si la línea leida es
	 * o no nula
	 * 
	 * @throws IOException | NumberFormatException e Captura cualquier excepción de
	 *                     E/S o de formato de número y devuelve 1 en caso de error
	 * @return si linea no es nula retorna la linea convertida a entero. Si el
	 *         archivo esta vacio retorna 1
	 */
	private static int leerContador() {
		try {
			// Abre un BufferedReader para leer desde el archivo "contador.txt"
			BufferedReader reader = new BufferedReader(new FileReader("contador.txt"));

			// Lee la primera línea del archivo
			String linea = reader.readLine();

			// Cierra el BufferedReader después de leer
			reader.close();

			// Verifica si la línea leída no es nula
			if (linea != null) {
				// Si el archivo no está vacío, convierte la línea a entero y devuelve el valor
				return Integer.parseInt(linea);
			} else {
				// Si el archivo está vacío, devuelve 1
				return 1;
			}
		} catch (IOException | NumberFormatException e) {
			// Captura cualquier excepción de E/S o de formato de número y devuelve 1 en
			// caso de error
			return 1;
		}
	}

	/**
	 * Metodo estatico para actualizar el contador en el archivo, crea el archivo
	 * contador.txt y actualiza su valor con contadorUsuarios
	 * 
	 * @param contadorUsuarios
	 * @throws IOException e Maneja cualquier excepción de entrada/salida que pueda
	 *                     ocurrir al escribir en el archivo, muestra en consola un
	 *                     mensaje de error
	 */
	private static void actualizarContador(int contadorUsuarios) {
		try {
			// Escribe el valor actualizado del contador en el archivo "contador.txt"
			FileWriter writer = new FileWriter("contador.txt"); // crea un archivo .txt
			writer.write(String.valueOf(contadorUsuarios)); // Escribe el valor actualizado del contador (convertido a
															// String) en el archivo "contador.txt"
			writer.close(); // Cierra el FileWriter después de escribir para asegurar que los datos se
							// escriban correctamente en el archivo
		} catch (IOException e) {
			// Maneja cualquier excepción de entrada/salida que pueda ocurrir al escribir en
			// el archivo
			System.out.println("Error al actualizar el contador: " + e.getMessage());
		}
	}

	/**
	 * El método faltanDatos se activa si presionas el botón "Aceptar". Verifica si
	 * faltan datos en los campos de texto JTextField numUsuario y pin y muestra un
	 * mensaje si es así. Si los textField numUsuario y pin están vacíos, o ninguno
	 * de los rbtn (botones de elección de cuenta) estan seleccionados se muestra un
	 * mensaje que pide que completemos los datos. De lo contrario, si el contenido
	 * del JTextField pin es < 6 se muestra un mensaje que pide que el pin sea de un
	 * tamaño <6. Si todos los campos están completos y la contraseña tiene al menos
	 * 6 caracteres, llamamos al método registrarJugador(), una vez este se ejecute
	 * con éxito se mostrara un mensaje confirmando la creación de la cuenta y al
	 * realizarse eso se muestra un mensaje del tipo de cuentas que tienes
	 * disponibles. Por último se deshabilita el boton crear cuenta para que no se
	 * vuelva a crear una cuenta con un mismo número de usuario que ya asigno el
	 * programa, recuerda que el número de usuario es único
	 */
	private void faltanDatos() {
		// Verificar si alguno de los campos está vacío
		if (textField_Usuario.getText().isEmpty() || textField_Contrasenia.getText().isEmpty()
				|| textField_CI.getText().isEmpty()) {
			mensajeLabel.setText("Por favor, complete todos los campos.");
			JOptionPane.showMessageDialog(null, mensajeLabel.getText());
		} else {
			// Verificar la longitud de la contraseña
			String contrasenia = textField_Contrasenia.getText();
			if (contrasenia.length() < 6) {
				JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// Si todos los campos están completos y la contraseña tiene al menos 6
				// caracteres, proceder con el registro del jugador
				registrarJugador();
				mensajeLabel.setText("¡Cuenta creada con éxito!");
				JOptionPane.showMessageDialog(null, mensajeLabel.getText());
				mensajeLabel.setText(
						"<html>Estimado usuario, nuestro banco le ofrece tres tipos de cuentas desde el momento en la creación de cuenta: <br>"
								+ "* Bolivianos<br>" + "* Dólares<br>" + "* Euros<br>"
								+ "Gracias por la confianza depositada en nuestro banco." + "</html>");
				if (true) {
					// Mostrar el segundo JOptionPane
					JOptionPane.showMessageDialog(null, mensajeLabel.getText());
				}
				btn_crearCuenta.setEnabled(false);
			}
		}
	}

	/**
	 * Registra los datos del usuario en un archivo usuario_.txt
	 */
	public void registrarJugador() {
		// Lee el contador actual desde el archivo
		int contadorUsuarios = leerContador();
		usuario = textField_Usuario.getText(); // Obtiene el texto del campo de usuario y lo asigna a la variable
												// 'usuario'
		contrasenia = textField_Contrasenia.getText(); // Obtiene el texto del campo de contraseña y lo asigna a la
														// variable 'contraseña'
		ci = textField_CI.getText(); // Obtiene el texto del campo de CI (cédula de identidad) y lo asigna a la
										// variable 'ci'
		numCuenta = lblNewLabel_NumCuenta.getText();
		String Bolivianos = "0";
		String Dolares = "0";
		String Euros = "0";
		try {
			// Crea un FileWriter para escribir en el archivo "usuarioX.txt", donde X es el
			// valor actual del contador
			FileWriter writer = new FileWriter("usuario" + contadorUsuarios + ".txt", true);

			// Escribe los datos del usuario en el archivo, cada dato en una nueva línea
			writer.write(usuario + "\n" + numCuenta + "\n" + contrasenia + "\n" + ci + "\n" + Bolivianos + "\n"
					+ Dolares + "\n" + Euros + "\n");

			// Cierra el FileWriter para asegurar que los datos se escriban correctamente en
			// el archivo
			writer.close();

			// Imprime un mensaje en la consola indicando que el registro fue exitoso
			System.out.println("¡Registro exitoso cliente " + contadorUsuarios + "!");

			// Incrementa el contador de usuarios para el próximo registro
			contadorUsuarios++;

			// Actualiza el contador en el archivo
			actualizarContador(contadorUsuarios);
		} catch (IOException e) {
			// Maneja cualquier excepción de entrada/salida que pueda ocurrir y
			// imprime un mensaje de error en la consola con la descripción del problema
			System.out.println("Error al registrar al jugador: " + e.getMessage());
		}
	}

	/**
	 * El método borrarNumero se activa si presionas el botón "Borrar" Si el
	 * JTextField en el que estes escribiendo es diferente de vacio obtiene la
	 * cadena que contiene el JTextField sin el último carácter y le reasigna ese
	 * valor
	 */
	private void borrarNumero() { // txt_saldo es el JTextField de saldo para mostrar los números
		String textoActual = textFieldActivo.getText(); // Obtenemos el texto actual del JTextField
		if (textoActual.length() > 0) { // Verificar que la cadena no esté vacía
			String textoNuevo = textoActual.substring(0, textoActual.length() - 1); // Obtener la cadena sin el último
																					// carácter
			textFieldActivo.setText(textoNuevo); // Establecer el nuevo texto en el JTextField
			/*
			 * Este método substring de la clase String toma dos argumentos. El primer
			 * argumento es el índice inicial (0 en este caso) y el segundo argumento es el
			 * índice final (en este caso, textoActual.length() - 1). Esto devuelve una
			 * subcadena de textoActual que comienza en el índice 0 y va hasta el índice
			 * textoActual.length() - 1, excluyendo este último. Por lo tanto, la subcadena
			 * resultante es textoActual sin su último carácter.
			 */
		}
	}

	/**
	 * El método borrarTodo se activa si presionas el botón "Cancelar" Borra el
	 * contenido de JTextField pin y numUsuario
	 */
	private void borrarTodo() {
		textField_Usuario.setText(""); // Establecer el nuevo texto en el JTextField mandandole un String vacio (nada)
		textField_Contrasenia.setText("");
		textField_CI.setText("");
	}

	/**
	 * Metodo main donde crearemos una instancia de nuestra clase, asignaremos su
	 * tamaño, cuando el usuario hace clic en el boton de cerrar la ventana la
	 * aplicacion Java se terminará completamente, y la haremos visible
	 * 
	 * @param args permite a tu programa recibir argumentos desde la línea de
	 *             comandos cuando se ejecuta
	 */
	public static void main(String[] args) {
		CrearCuenta miVentana = new CrearCuenta();
		miVentana.setSize(900, 800);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}