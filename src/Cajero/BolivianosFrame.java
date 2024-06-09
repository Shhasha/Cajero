package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase BolivianosFrame implementa una interfase que ayuda al usuario con la
 * interacción con su cuenta de Bolivianos. Al ser un extends JFRAME se utiliza
 * para crear una ventana con características estándar de una ventana de
 * aplicación gráfica (GUI).
 */
public class BolivianosFrame extends JFrame {
	// --------------------------------------------------------
	// Atributos
	// --------------------------------------------------------
	private static String usuarioCorrespondiente; // IMPORTANTE, DATO GLOBAL usuarioCorrespondiente que es el numero de
													// archivo que contiene usuarioX.txt que ayudara a abrir otro
													// archivo mostrando los datos de ese usuario
	// Además es una variable que aparecera solamente si el usuario inicia sesion,
	// cuando cierre sesion deberia desaparecer junto al .txt
	private static int eleccionCuenta = 1; // puede ser 1, 2 o 3
	private String eleccionIdioma;
	private static String usuario;
	private static String numCuenta;
	private static String PIN;
	private static String ci;
	private static String Bolivianos;
	private static String Dolares;
	private static String Euros;
	private JComboBox<String> comboBox;
	private int ultimaSeleccion = 0;
	public static int frameOpcion = 1;
	private static JButton btnMostrarSpanish;
	private static JButton btnMostrarEnglish;
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_3_1;
	private static JLabel lblNewLabel_3_2;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_6_1;
	private static JLabel lblNewLabel_6_1_1;
	private static JLabel lblNewLabel_6_1_1_1;
	private static JButton btn_cancelar;
	private static JButton btn_borrar;
	private static JButton btn_aceptar;
	private static JButton btn_ingresar_1;
	private static JButton btn_ingresar;
	private static JLabel lblInicio;
	
	/**
	 * Dentro del método constructor creamos toda la parte gráfica del programa que
	 * contiene: JLabels para enseñar textos JTextField para que el usuario ingrese
	 * texto interactuando con el programa Un teclado con botones que contienen
	 * números del 0 al 9 los cuales funcionan al tener contacto con ellos se
	 * escribe en el JTextField que selecciones. Botones para "Aceptar", "Borrar",
	 * "Cancelar", "Historial" "Salir" "Depositar" "Retirar" "Cambiar contraseña"
	 * "Transferir"
	 */
	public BolivianosFrame() {
		devuelveDatosUsuario();
		setSize(900, 800);// definimos el tamaño de mi ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // significa que al cerrar la ventana principal, la aplicación
														// finalizará su ejecución y se cerrará por completo
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
		panel_7.setBounds(10, 11, 520, 221);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_1.setBounds(27, 11, 89, 38);
		panel_7.add(btn_1);

		JButton btn_4 = new JButton("4");
		btn_4.setBounds(27, 60, 89, 38);
		panel_7.add(btn_4);

		JButton btn_7 = new JButton("7");
		btn_7.setBounds(27, 109, 89, 38);
		panel_7.add(btn_7);

		JButton btn_2 = new JButton("2");
		btn_2.setBounds(126, 11, 89, 38);
		panel_7.add(btn_2);

		JButton btn_5 = new JButton("5");
		btn_5.setBounds(126, 60, 89, 38);
		panel_7.add(btn_5);

		JButton btn_8 = new JButton("8");
		btn_8.setBounds(126, 109, 89, 38);
		panel_7.add(btn_8);

		JButton btn_3 = new JButton("3");
		btn_3.setBounds(225, 11, 89, 38);
		panel_7.add(btn_3);

		JButton btn_6 = new JButton("6");
		btn_6.setBounds(225, 60, 89, 38);
		panel_7.add(btn_6);

		JButton btn_9 = new JButton("9");
		btn_9.setBounds(225, 109, 89, 38);
		panel_7.add(btn_9);

		JButton btn_0 = new JButton("0");
		btn_0.setBounds(126, 158, 89, 38);
		panel_7.add(btn_0);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(400, 11, 89, 38);
		panel_7.add(btn_cancelar);

		btn_borrar = new JButton("Borrar");
		btn_borrar.setBounds(400, 60, 89, 38);
		panel_7.add(btn_borrar);

		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(400, 109, 89, 38);
		btn_aceptar.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su
																// acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				devuelveDatosUsuario();
			}
		});
		panel_7.add(btn_aceptar);

		btn_ingresar = new JButton("Salir");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Borrar los datos del archivo usuarioCorrespondiente.txt
				try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarioCorrespondiente.txt"))) {
					writer.write(""); // Escribe una cadena vacía para borrar el contenido
				} catch (IOException ex) {
					System.out.println(
							"Error al borrar el contenido del archivo usuarioCorrespondiente.txt: " + ex.getMessage());
				}

				setVisible(false); // Cierra la ventana
			}
		});
		btn_ingresar.setBounds(668, 194, 129, 38);
		panel_1.add(btn_ingresar);

		btn_ingresar_1 = new JButton("Historial");
		btn_ingresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// esta pantalla actual deja de ser visible
				Historial frameDepositar = new Historial(); // Visibiliza el historial
				frameDepositar.setVisible(true);
			}
		});
		btn_ingresar_1.setBounds(668, 11, 129, 38);
		panel_1.add(btn_ingresar_1);

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
		panel_6.setBounds(10, 11, 478, 179);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(20, 45, 64, 14);
		panel_6.add(lblNewLabel_1);

		lblNewLabel_3 = new JLabel("Saldo:");
		lblNewLabel_3.setBounds(20, 70, 64, 14);
		panel_6.add(lblNewLabel_3);

		JLabel lblNewLabel_4_SimboloBs = new JLabel("Bs");
		lblNewLabel_4_SimboloBs.setBounds(94, 70, 25, 14);
		panel_6.add(lblNewLabel_4_SimboloBs);

		JLabel lblNewLabel_nameUsuario = new JLabel(usuario);
		lblNewLabel_nameUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_nameUsuario.setBounds(94, 45, 280, 14);
		panel_6.add(lblNewLabel_nameUsuario);

		JLabel lblNewLabel_saldoBs = new JLabel(Bolivianos);
		lblNewLabel_saldoBs.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldoBs.setBounds(119, 70, 280, 14);
		panel_6.add(lblNewLabel_saldoBs);

		lblNewLabel_6 = new JLabel("Depositar");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(404, 11, 64, 14);
		panel_6.add(lblNewLabel_6);

		lblNewLabel_6_1 = new JLabel("Retirar");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setBounds(404, 42, 64, 14);
		panel_6.add(lblNewLabel_6_1);

		lblNewLabel_6_1_1 = new JLabel("Transferir");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1.setBounds(404, 77, 64, 14);
		panel_6.add(lblNewLabel_6_1_1);

		lblNewLabel_6_1_1_1 = new JLabel("Cambiar contraseña");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1_1.setBounds(324, 110, 144, 14);
		panel_6.add(lblNewLabel_6_1_1_1);

		lblNewLabel_3_1 = new JLabel("Saldo:");
		lblNewLabel_3_1.setBounds(20, 96, 64, 14);
		panel_6.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1Simbolo$ = new JLabel("$");
		lblNewLabel_4_1Simbolo$.setBounds(94, 96, 13, 14);
		panel_6.add(lblNewLabel_4_1Simbolo$);

		JLabel lblNewLabel_saldo_1$ = new JLabel(Dolares);///
		lblNewLabel_saldo_1$.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo_1$.setBounds(119, 96, 280, 14);
		panel_6.add(lblNewLabel_saldo_1$);

		lblNewLabel_3_2 = new JLabel("Saldo:");
		lblNewLabel_3_2.setBounds(20, 121, 64, 14);
		panel_6.add(lblNewLabel_3_2);

		JLabel lblNewLabel_4_2SimboloE = new JLabel("E");
		lblNewLabel_4_2SimboloE.setBounds(94, 121, 13, 14);
		panel_6.add(lblNewLabel_4_2SimboloE);

		JLabel lblNewLabel_saldo_2E = new JLabel(Euros);/////
		lblNewLabel_saldo_2E.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo_2E.setBounds(119, 121, 280, 14);
		panel_6.add(lblNewLabel_saldo_2E);

		lblInicio = new JLabel("CUENTA BOLIVIANOS");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.LIGHT_GRAY);
		lblInicio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInicio.setBackground(Color.LIGHT_GRAY);
		lblInicio.setBounds(26, 21, 498, 40);
		panel_5.add(lblInicio);

		// IR A DEPOSITAR
		JButton btn_depositar = new JButton("<--"); // Depositar
		btn_depositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DepositarBolivianos frameDepositar = new DepositarBolivianos();
				frameDepositar.setVisible(true);
			}
		});
		btn_depositar.setBounds(572, 103, 89, 23);
		panel_3.add(btn_depositar);

		// IR A RETIRAR
		JButton btn_retirar = new JButton("<--");
		btn_retirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RetirarBolivianos frameRetirar = new RetirarBolivianos();
				frameRetirar.setVisible(true);
			}
		});
		btn_retirar.setBounds(572, 137, 89, 23);
		panel_3.add(btn_retirar);

		// IR A TRANSFERIR
		JButton btn_transferir = new JButton("<--");
		btn_transferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TransferirBolivianos frameTransferir = new TransferirBolivianos();
				frameTransferir.setVisible(true);
			}
		});
		btn_transferir.setBounds(572, 171, 89, 23);
		panel_3.add(btn_transferir);

		// IR A CAMBIAR CONTRASEÑA
		JButton btn_cambiarContrasenia = new JButton("<--");
		btn_cambiarContrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CambiarContrasenia frameCambContra = new CambiarContrasenia(frameOpcion);
				frameCambContra.setVisible(true);
			}
		});
		btn_cambiarContrasenia.setBounds(572, 203, 89, 23);
		panel_3.add(btn_cambiarContrasenia);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 807, 59);
		panel.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("CAJERO AUTOMATICO");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(88, 11, 633, 40);
		panel_2.add(lblNewLabel);

		// OPCIONES DESPLEGABLES

		// Crear el JComboBox con las opciones
		comboBox = new JComboBox<>(); // Inicializa comboBox antes de los bloques if
		if (eleccionCuenta == 1) {
			String[] opciones = { "Bolivianos", "Dolares", "Euros" };
			comboBox = new JComboBox<>(opciones);
			comboBox.setBounds(572, 64, 195, 30);
			panel_3.add(comboBox);
		}
		if (eleccionCuenta == 2) {
			String[] opciones = { "Dolares", "Bolivianos", "Euros" };
			comboBox = new JComboBox<>(opciones);
			comboBox.setBounds(572, 64, 195, 30);
			panel_3.add(comboBox);
		}
		if (eleccionCuenta == 3) {
			String[] opciones = { "Euros", "Bolivianos", "Dolares" };
			comboBox = new JComboBox<>(opciones);
			comboBox.setBounds(572, 64, 195, 30);
			panel_3.add(comboBox);
		}

		// Establecer la última opción seleccionada guardada
		comboBox.setSelectedIndex(ultimaSeleccion);

		// Agregar un ActionListener al JComboBox
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBox.getSelectedItem();
				ultimaSeleccion = comboBox.getSelectedIndex(); // Guardar el índice de la última opción seleccionada
				switch (seleccion) {
				case "Bolivianos":
					// Aquí iría el código para cambiar de frame según la selección
					break;
				case "Dolares":
					setVisible(false);
					DolaresFrame vent2 = new DolaresFrame(); // CORREGIR ESTO, NO SE NECESITA YA QUE ESAS VARIABLES
																// DEBEN SER CONSEGUIDAS AL LLAMAR AL ARCHIVO
																// USUARIO.TXT CORRESPONDIENTE
					vent2.setVisible(true);

					// Aquí iría el código para cambiar de frame según la selección
					break;
				case "Euros":
					setVisible(false);
					EuroFrame vent3 = new EuroFrame(); // CORREGIR ESTO, NO SE NECESITA YA QUE ESAS VARIABLES DEBEN SER
														// CONSEGUIDAS AL LLAMAR AL ARCHIVO USUARIO.TXT CORRESPONDIENTE
					vent3.setVisible(true);

					// Aquí iría el código para cambiar de frame según la selección
					break;
				}
			}
		});
	}

	/**
	 * Abre el txt que tiene el usuario correspondiente que inicio sesion
	 * 
	 * @return numUsuariotxt en caso de que el archivo se abra sin problemas, sino
	 *         retorna 0
	 * @throws IOException e NumberFormatException e
	 */
	private static int abrirUsuarioCorrespondiente() {
		int numUsuariotxt = 0;
		usuarioCorrespondiente = "usuarioCorrespondiente.txt"; // IMPORTANTE
		try {
			BufferedReader reader = new BufferedReader(new FileReader(usuarioCorrespondiente));
			String linea = reader.readLine();
			reader.close();
			if (linea != null) {
				numUsuariotxt = Integer.parseInt(linea);
				System.out.println("La cantidad de Usuarios es de " + (numUsuariotxt));
			}
			return numUsuariotxt;

		} catch (IOException e) {
			// Maneja cualquier excepción de entrada/salida que pueda ocurrir
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch (NumberFormatException e) {
			// Maneja cualquier excepción de formato de número que pueda ocurrir
			System.out.println("El contenido del archivo no es un número válido: " + e.getMessage());
		}

		// En caso de error, retorna 0 por defecto
		return 0;

	}

	/**
	 * Abre el txt que tiene el numero GLOBAL del usuario que inicio sesion
	 * 
	 * @return numUsuariotxt en caso de que el archivo se abra sin problemas, sino
	 *         retorna 0
	 * @throws IOException e NumberFormatException e
	 */
	private static int abrirCuentaCorrespondiente() {
		// System.out.println("LeerNumArchivo()");
		int eleccionCuenta = 0;
		usuarioCorrespondiente = "usuarioCorrespondiente.txt"; // IMPORTANTE
		// System.out.println(cantidadUsuarios);
		try {
			// Abre el archivo para lectura
			BufferedReader reader = new BufferedReader(new FileReader(usuarioCorrespondiente));

			// Lee la primera línea del archivo
			String linea = reader.readLine();
			String linea2 = reader.readLine(); // Usaremos este pq el tipo de cuenta esta almacenado en la segunda linea

			// Cierra el BufferedReader después de leer
			reader.close();

			// Convierte la segunda línea leída a entero y la almacena en la variable
			// 'eleccionCuenta'
			if (linea2 != null) {
				eleccionCuenta = Integer.parseInt(linea2);
				System.out.println("La elección de cuenta es " + (eleccionCuenta));
			}

			// Retorno del número leído (numUsuariotxt)
			return eleccionCuenta;

		} catch (IOException e) {
			// Maneja cualquier excepción de entrada/salida que pueda ocurrir
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch (NumberFormatException e) {
			// Maneja cualquier excepción de formato de número que pueda ocurrir
			System.out.println("El contenido del archivo no es un número válido: " + e.getMessage());
		}

		// En caso de error, retorna 0 por defecto
		return 0;

	}

	/**
	 * Este método abre el archivo que contiene los datos del usuario que inicio
	 * sesion preguntando a abrirUsuarioCorrespondiente() y almacenando en
	 * numUsuario, de forma que el nombre de usuario. luego vamos recorriendo las 6
	 * lineas en las que almacena datos el txt guardando en un arreglo del cual
	 * luago ingresaremos y sacaremoslos valores para uruariom numCuenta, pin, ci,
	 * bolivianos, dolares, euros
	 * 
	 * @throws IOException
	 */
	private static void devuelveDatosUsuario() {
		int numUsuario;// número de usuario que inicio sesion
		// int elecCuenta;// tipo de cuenta elegida 1, 2, 3
		numUsuario = abrirUsuarioCorrespondiente();
		// elecCuenta = abrirCuentaCorrespondiente();
		String nombreArchivo = "usuario" + numUsuario + ".txt";
		String[] lineas = new String[7];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			int i = 0;

			// Lee hasta 5 líneas del archivo o hasta que no haya más líneas
			while (i < 7 && (linea = reader.readLine()) != null) {
				lineas[i] = linea; // Almacena la línea en el arreglo
				i++; // Incrementa el índice
			}

			// Cierra el BufferedReader después de leer
			reader.close();

		} catch (IOException e) {
			// Maneja cualquier excepción de entrada/salida que pueda ocurrir
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		// Imprime las líneas leídas, verificando que no sean nulas
		for (int i = 0; i < lineas.length; i++) {
			System.out.println("Línea " + (i + 1) + ": " + (lineas[i] != null ? lineas[i] : "No hay datos"));
		}

		usuario = lineas[0];
		numCuenta = lineas[1];
		PIN = lineas[2];
		ci = lineas[3];
		Bolivianos = lineas[4];
		Dolares = lineas[5];
		Euros = lineas[6];

		// eleccionCuenta = elecCuenta;
		// guardarEleccionCuenta(eleccionCuenta);
		// modificarSegundaLinea();
	}

	/**
	 * Método main donde crearemos una instancia de nuestra clase, asignaremos su
	 * tamaño, cuando el usuario hace clic en el botón de cerrar la ventana la
	 * aplicación Java se terminará completamente, y la haremos visible
	 * @param args permite a tu programa recibir argumentos desde la línea de comandos cuando se ejecuta
	 */
	public static void main(String[] args) {
		BolivianosFrame miVentana = new BolivianosFrame();
		miVentana.setSize(900, 800);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);

	}
}