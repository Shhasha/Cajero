package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * La clase Historial implementa una interfase que informa al usuario sobre
 * todos los movimientos que realizo en su cuenta. Al ser un extends JFRAME se
 * utiliza para crear una ventana con características estándar de una ventana de
 * aplicación gráfica (GUI).
 */
public class Historial extends JFrame {
	// --------------------------------------------------------
	// Atributos
	// --------------------------------------------------------
	private static String usuarioCorrespondiente; // IMPORTANTE, DATO GLOBAL usuarioCorrespondiente que es el numero de
													// archivo que contiene usuarioX.txt que ayudara a abrir otro
													// archivo mostrando los datos de ese usuario
	private int eleccionCuenta; // puede ser 1, 2 o 3
	private String eleccionIdioma;
	// Además es una variable que aparecera solamente si el usuario inicia sesion,
	// cuando cierre sesion deberia desaparecer junto al .txt
	private static JTextField mensajeLabel = new JTextField();// guarda el mensaje que emerge en caso de que el usuario
																// no haya llenado sus datos
	private static JLabel lblNewLabel_saldo;
	private static JTextField text_montoRetirar;
	private static String Transacciones;
	private static String Transactions;
	private static String archivoTransaccion;
	private static String usuario; // Variable para almacenar el nombre recibido
	private static String numCuenta;
	private static String PIN;
	private static String ci;
	private static String Bolivianos;
	private static String Dolares;
	private static String Euros;
	private JLabel lblcajeroAutm;
	private JLabel lblbienvenido;
	
	/**
	 * Dentro del método constructor creamos toda la parte gráfica del programa que
	 * contiene: JLabels para enseñar textos, un JTextField para que el usuario
	 * ingrese el monto que desea depositar. Un teclado con botones que contienen números del
	 * 0 al 9 los cuales funcionan al tener contacto con ellos se escribe en el
	 * JTextField que selecciones. Botones para "Volver"
	 */
	public Historial() {
		devuelveDatosUsuario();
		setSize(900, 800); // Tamaño de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(37, 37, 37));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(120, 171, 165));
		panel.setBounds(10, 11, 827, 739);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBackground(new Color(37, 37, 37));
		panel_3.setBounds(10, 81, 807, 647);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(228, 228, 228));
		panel_5.setBounds(10, 11, 571, 625);
		panel_3.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(26, 200, 509, 414);
		panel_5.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(210, 255, 204));
		panel_6.setBounds(10, 41, 478, 362);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Por favor ingrese sus datos:");
		lblNewLabel_1.setBounds(10, 11, 241, 14);
		panel_4.add(lblNewLabel_1);

		// Crear el JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 458, 340);
		archivoTransaccion = verQueIdiomaArchivo();
		String contenidoArchivo = leerContenidoArchivo(Transacciones);
		textArea.setText(contenidoArchivo);

		// Agregar el JTextArea a un JScrollPane con barras de desplazamiento vertical y
		// horizontal
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 11, 458, 340);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_6.add(scrollPane);

		lblbienvenido = new JLabel("Historial");
		lblbienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		lblbienvenido.setForeground(Color.LIGHT_GRAY);
		lblbienvenido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblbienvenido.setBackground(Color.LIGHT_GRAY);
		lblbienvenido.setBounds(26, 21, 498, 40);
		panel_5.add(lblbienvenido);

		JLabel lblNewLabel_1_1 = new JLabel("Usuario:");
		lblNewLabel_1_1.setBounds(26, 72, 64, 14);
		panel_5.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3 = new JLabel("Saldo:");
		lblNewLabel_3.setBounds(26, 97, 35, 14);
		panel_5.add(lblNewLabel_3);

		JLabel lblNewLabel_4_Simbolo$ = new JLabel("Bs");
		lblNewLabel_4_Simbolo$.setBounds(65, 97, 25, 14);
		panel_5.add(lblNewLabel_4_Simbolo$);

		JLabel lblNewLabel_nameUsuario = new JLabel(usuario);
		lblNewLabel_nameUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_nameUsuario.setBounds(98, 72, 184, 14);
		panel_5.add(lblNewLabel_nameUsuario);

		JLabel lblNewLabel_saldo$ = new JLabel(Bolivianos);
		lblNewLabel_saldo$.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo$.setBounds(98, 97, 174, 14);
		panel_5.add(lblNewLabel_saldo$);

		JLabel lblNewLabel_3_1 = new JLabel("Saldo:");
		lblNewLabel_3_1.setBounds(26, 123, 35, 14);
		panel_5.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1SimboloBs = new JLabel("$");
		lblNewLabel_4_1SimboloBs.setBounds(65, 123, 25, 14);
		panel_5.add(lblNewLabel_4_1SimboloBs);

		JLabel lblNewLabel_saldo_1Bs = new JLabel(Dolares);
		lblNewLabel_saldo_1Bs.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo_1Bs.setBounds(98, 123, 174, 14);
		panel_5.add(lblNewLabel_saldo_1Bs);

		JLabel lblNewLabel_3_2 = new JLabel("Saldo:");
		lblNewLabel_3_2.setBounds(26, 148, 35, 14);
		panel_5.add(lblNewLabel_3_2);

		JLabel lblNewLabel_4_2SimboloE = new JLabel("E");
		lblNewLabel_4_2SimboloE.setBounds(65, 148, 13, 14);
		panel_5.add(lblNewLabel_4_2SimboloE);

		JLabel lblNewLabel_saldo_2E = new JLabel(Euros);
		lblNewLabel_saldo_2E.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo_2E.setBounds(98, 148, 174, 14);
		panel_5.add(lblNewLabel_saldo_2E);

		JLabel lblNewLabel_3_3 = new JLabel("CI");
		lblNewLabel_3_3.setBounds(295, 122, 35, 14);
		panel_5.add(lblNewLabel_3_3);

		JLabel lblNewLabel_saldoD_1 = new JLabel(ci);
		lblNewLabel_saldoD_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldoD_1.setBounds(372, 122, 174, 14);
		panel_5.add(lblNewLabel_saldoD_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Contraseñaa");
		lblNewLabel_3_1_1.setBounds(295, 148, 86, 14);
		panel_5.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_saldo_1Bs_1 = new JLabel(PIN);
		lblNewLabel_saldo_1Bs_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo_1Bs_1.setBounds(372, 148, 174, 14);
		panel_5.add(lblNewLabel_saldo_1Bs_1);

		JLabel lblNewLabel_3_3_1 = new JLabel("Número de");
		lblNewLabel_3_3_1.setBounds(295, 72, 64, 14);
		panel_5.add(lblNewLabel_3_3_1);

		JLabel lblNewLabel_saldo$_1_1 = new JLabel(numCuenta);
		lblNewLabel_saldo$_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo$_1_1.setBounds(372, 83, 174, 14);
		panel_5.add(lblNewLabel_saldo$_1_1);

		JLabel lblNewLabel_3_3_1_1 = new JLabel("Usuario:");
		lblNewLabel_3_3_1_1.setBounds(295, 97, 64, 14);
		panel_5.add(lblNewLabel_3_3_1_1);

		JButton btn_ingresar = new JButton("Volver");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BolivianosFrame frameDepositar = new BolivianosFrame();
				frameDepositar.setVisible(true);
			}
		});
		btn_ingresar.setBounds(668, 598, 129, 38);

		panel_3.add(btn_ingresar);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 807, 59);
		panel.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);

		lblcajeroAutm = new JLabel("CAJERO AUTOMATICO");
		lblcajeroAutm.setBackground(new Color(192, 192, 192));
		lblcajeroAutm.setHorizontalAlignment(SwingConstants.CENTER);
		lblcajeroAutm.setForeground(new Color(192, 192, 192));
		lblcajeroAutm.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblcajeroAutm.setBounds(97, 11, 633, 40);
		panel_2.add(lblcajeroAutm);
		ButtonGroup group = new ButtonGroup();

	}

	/// Abre el txt que tiene el numero GLOBAL del usuario que inicio sesion
	// se encarga de abrir un archivo llamado "usuarioCorrespondiente.txt" y leer el
	/// número almacenado en la primera línea. Este número representa la cantidad de
	/// usuarios registrados en el sistema.
	private static int abrirUsuarioCorrespondiente() {
		// System.out.println("LeerNumArchivo()");
		int numUsuariotxt = 0;
		usuarioCorrespondiente = "usuarioCorrespondiente.txt"; // IMPORTANTE
		// System.out.println(cantidadUsuarios);
		try {
			// Abre el archivo para lectura
			BufferedReader reader = new BufferedReader(new FileReader(usuarioCorrespondiente));

			// Lee la primera línea del archivo
			String linea = reader.readLine();

			// Cierra el BufferedReader después de leer
			reader.close();

			// Convierte la línea leída a entero y la almacena en la variable 'numero'
			if (linea != null) {
				numUsuariotxt = Integer.parseInt(linea);
				System.out.println("La cantidad de Usuarios es de " + (numUsuariotxt));
			}

			// Retorno del número leído
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
	 * Este método abre el archivo que contiene los datos del usuario que inicio
	 * sesion preguntando a abrirUsuarioCorrespondiente() y almacenando en
	 * numUsuario, de forma que el nombre de usuario. luego vamos recorriendo las 6
	 * lineas en las que almacena datos el txt guardando en un arreglo del cual
	 * luago ingresaremos y sacaremoslos valores para uruariom numCuenta, pin, ci,
	 * bolivianos, dolares, euros
	 */
	private static void devuelveDatosUsuario() {
		int numUsuario;// número de usuario que inicio sesion
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo = "usuario" + numUsuario + ".txt";
		Transacciones = "movimientos" + numUsuario + ".txt";
		String[] lineas = new String[7];
		try {
			// Abre un BufferedReader para leer desde el archivo
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

			// Variable para almacenar cada linea leida del archivo
			String linea;

			// indice para controlar el nemero de lineas leidas
			int i = 0;

			// Lee hasta 5 lineas del archivo o hasta que no haya mas lineas
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

		usuario = lineas[0];
		numCuenta = lineas[1];
		PIN = lineas[2];
		ci = lineas[3];
		Bolivianos = lineas[4];
		Dolares = lineas[5];
		Euros = lineas[6];

	}

	private static String verQueIdiomaArchivo() {// idioma
		int numUsuario;// número de usuario que inicio sesion
		String idioma = "";
		numUsuario = abrirUsuarioCorrespondiente();
		if (idioma == "esp") {
			Transacciones = "Transacciones" + numUsuario + ".txt";
			return Transacciones;
		}
		if (idioma == "ing") {
			Transactions = "Transactions" + numUsuario + ".txt";
			return Transactions;
		}
		return "";
	}

	private static String leerContenidoArchivo(String nombreArchivo) {
		StringBuilder contenido = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				contenido.append(linea).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido.toString();
	}

	public static void main(String[] args) {
		Historial miVentana = new Historial();
		miVentana.setSize(900, 800);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}
