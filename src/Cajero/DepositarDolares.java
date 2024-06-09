package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DepositarDolares extends JFrame {
	
	private static JTextField text_montoDepositoD; // private JTextField txt_saldo;
	private String montoDeposString;
	private static JLabel lblNewLabel_saldo;
	private JTextField mensajeLabel = new JTextField();// guarda el mensaje que emerge en caso de que el usuario no haya
														// llenado sus datos

	// Datos globales
	private static String usuarioCorrespondiente; // IMPORTANTE, DATO GLOBAL usuarioCorrespondiente que es el numero de
													// archivo que contiene usuarioX.txt que ayudara a abrir otro
													// archivo mostrando los datos de ese usuario
	// Además es una variable que aparecera solamente si el usuario inicia sesion,
	// cuando cierre sesion deberia desaparecer junto al .txt
	private int eleccionCuenta; // puede ser 1, 2 o 3
	private String eleccionIdioma;

	// Datos del usuario
	private static String usuario; // Variable para almacenar el nombre recibido
	private static String numCuenta;
	private static String PIN;
	private static String ci;
	private static String Bolivianos;
	private static String Dolares;
	private static String Euros;

	public DepositarDolares() {
		devuelveDatosUsuario();
		setSize(900, 800);
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
		panel_7.setBounds(10, 11, 571, 221);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		/*
		 * JButton btn_1 = new JButton("1"); // Creamos un botón con el texto "1"
		 * btn_1.setBounds(27, 11, 89, 38); // Configuración de la posición y tamaño del
		 * botón btn_1.addActionListener(new ActionListener() { // Añadimos un
		 * ActionListener al botón para manejar su acción public void
		 * actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el
		 * botón escribirNumero("1"); // Llamamos al método escribirNumero con el número
		 * "1" } });
		 */

		// BOTON 1
		JButton btn_1 = new JButton("1"); // Creamos un botón con el texto "1"
		btn_1.setBounds(27, 11, 89, 38); // Configuración de la posición y tamaño del botón
		btn_1.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("1"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_1);

		// BOTON 4
		JButton btn_4 = new JButton("4");
		btn_4.setBounds(27, 60, 89, 38);
		btn_4.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("4"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_4);

		// BOTON 7
		JButton btn_7 = new JButton("7");
		btn_7.setBounds(27, 109, 89, 38);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("7"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_7);

		// BOTON 2
		JButton btn_2 = new JButton("2");
		btn_2.setBounds(126, 11, 89, 38);
		btn_2.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("2"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_2);

		// BOTON 5
		JButton btn_5 = new JButton("5");
		btn_5.setBounds(126, 60, 89, 38);
		btn_5.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("5"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_5);

		// BOTON 8
		JButton btn_8 = new JButton("8");
		btn_8.setBounds(126, 109, 89, 38);
		btn_8.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("8"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_8);

		// BOTON 3
		JButton btn_3 = new JButton("3");
		btn_3.setBounds(225, 11, 89, 38);
		btn_3.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("3"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_3);

		// BOTON 6
		JButton btn_6 = new JButton("6");
		btn_6.setBounds(225, 60, 89, 38);
		btn_6.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("6"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_6);

		// BOTON 9
		JButton btn_9 = new JButton("9");
		btn_9.setBounds(225, 109, 89, 38);
		btn_9.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("9"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_9);

		// BOTON 0
		JButton btn_0 = new JButton("0");
		btn_0.setBounds(126, 158, 89, 38);
		btn_0.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				escribirNumero("0"); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_0);

		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(453, 11, 89, 38);
		btn_cancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				borrarTodo();

			}
		});
		panel_7.add(btn_cancelar);

		JButton btn_borrar = new JButton("Borrar");
		btn_borrar.setBounds(453, 60, 89, 38);
		btn_borrar.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su
															// acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				borrarNumero(); // Llamamos al método escribirNumero con el número "1"
			}
		});
		panel_7.add(btn_borrar);

		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(453, 109, 89, 38);
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faltanDatos();
			}
		});
		panel_7.add(btn_aceptar);

		JButton btn_ingresar = new JButton("Volver");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DolaresFrame frameVentana = new DolaresFrame();
				frameVentana.setVisible(true);
			}
		});
		btn_ingresar.setBounds(668, 194, 129, 38);
		panel_1.add(btn_ingresar);

		/*
		 * JButton btn_depositar = new JButton("<--"); //Depositar
		 * btn_depositar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { setVisible(false); Depositar frameDepositar
		 * = new Depositar(); frameDepositar.setVisible(true); } });
		 * btn_depositar.setBounds(572, 117, 89, 23); panel_3.add(btn_depositar);
		 */

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBackground(new Color(37, 37, 37));
		panel_3.setBounds(10, 81, 807, 321);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(228, 228, 228));
		panel_5.setBounds(10, 11, 572, 299);
		panel_3.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(26, 70, 498, 203);
		panel_5.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(210, 255, 204));
		panel_6.setBounds(10, 11, 478, 181);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(10, 11, 64, 14);
		panel_6.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Saldo:");
		lblNewLabel_3.setBounds(10, 36, 35, 14);
		panel_6.add(lblNewLabel_3);

		JLabel lblNewLabel_4Bs = new JLabel("$");
		lblNewLabel_4Bs.setBounds(49, 36, 35, 14);
		panel_6.add(lblNewLabel_4Bs);

		JPanel panel_opcione = new JPanel();
		panel_opcione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_opcione.setForeground(new Color(120, 171, 165));
		panel_opcione.setBackground(new Color(210, 255, 204));
		panel_opcione.setBounds(20, 61, 436, 72);
		panel_6.add(panel_opcione);
		panel_opcione.setLayout(null);

		JLabel txt_cantidad = new JLabel("Monto de deposito");
		txt_cantidad.setBounds(10, 11, 104, 14);
		panel_opcione.add(txt_cantidad);

		text_montoDepositoD = new JTextField();
		text_montoDepositoD.setBounds(89, 42, 272, 14);
		panel_opcione.add(text_montoDepositoD);
		// montoDeposString= text_montoDeposito.getText();
		/*
		 * txt_saldo = new JTextField(); // Creamos un JTextField para mostrar los
		 * números txt_saldo.setBounds(63, 36, 317, 14); // Configuración de la posición
		 * y tamaño del JTextField panel_6.add(txt_saldo); // Añadimos el JTextField al
		 * JPanel interno
		 */

		JLabel lblNewLabel_4_1Bs = new JLabel("$");
		lblNewLabel_4_1Bs.setBounds(66, 42, 48, 14);
		panel_opcione.add(lblNewLabel_4_1Bs);

		JLabel lblNewLabel_nameUsuario = new JLabel(usuario);
		lblNewLabel_nameUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_nameUsuario.setBounds(74, 11, 280, 14);
		panel_6.add(lblNewLabel_nameUsuario);

		lblNewLabel_saldo = new JLabel(Dolares); // lblNewLabel_saldo;
		lblNewLabel_saldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo.setBounds(74, 36, 280, 14);
		panel_6.add(lblNewLabel_saldo);

		JLabel lblDepositar = new JLabel("DEPOSITAR DOLARES");
		lblDepositar.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepositar.setForeground(Color.LIGHT_GRAY);
		lblDepositar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDepositar.setBackground(Color.LIGHT_GRAY);
		lblDepositar.setBounds(26, 19, 498, 40);
		panel_5.add(lblDepositar);

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

		// Crea una instancia de CajeroAutomático con un saldo inicial de $1000
		// cajero = new CajeroAutomatico(1000);
	}

	/**
	 * Método que comprueba que ambos JTextField esten llenos si text_montoRetirar
	 * esta vacio y text_montoRetirar es < 6 entonces nos saldra un mensaje diciendo
	 * que la contraseña debe ser mayor a 6 de lo contrario llamamos al metodo sumar
	 */
	private void faltanDatos() {
		if (text_montoDepositoD.getText().isEmpty()) {
			mensajeLabel.setText("Por favor, complete todos los campos.");
			JOptionPane.showMessageDialog(null, mensajeLabel.getText());
		}

		else {
			sumar();
		}

	}

	/**
	 * Método para escribir un número en el JTextField que seleccionemos de los 2
	 * que hay
	 * 
	 * @param numero
	 */
	private void escribirNumero(String numero) { // txt_saldo es el JTextField de saldo para mostrar los números
		String textoActual = text_montoDepositoD.getText(); // Obtenemos el texto actual del JTextField
		text_montoDepositoD.setText(textoActual + numero); // Concatenamos el numero presionado al texto actual y lo
															// seteamos en el JTextField
	}
	
	/**
	 * El método borrarNumero se activa si presionas el botón "Borrar" Si el
	 * JTextField en el que estes escribiendo es diferente de vacio obtiene la
	 * cadena que contiene el JTextField sin el último carácter y le reasigna ese
	 * valor
	 */
	private void borrarNumero() { // txt_saldo es el JTextField de saldo para mostrar los números
		String textoActual = text_montoDepositoD.getText(); // Obtenemos el texto actual del JTextField
		if (textoActual.length() > 0) { // Verificar que la cadena no esté vacía
			String textoNuevo = textoActual.substring(0, textoActual.length() - 1); // Obtener la cadena sin el último																				// carácter
			text_montoDepositoD.setText(textoNuevo); // Establecer el nuevo texto en el JTextField
			}
	}

	/**
	 * El metodo borrarTodo se activa si presionas el botón "Cancelar" Borra el
	 * contenido de JTextField pin y numUsuario
	 */
	private void borrarTodo() {
		text_montoDepositoD.setText(""); // Establecer el nuevo texto en el JTextField mandandole un String vacio (nada)
	}

	/**
	 * Abre el txt que tiene el usuario correspondiente que inicio sesion
	 * 
	 * @return numUsuariotxt en caso de que el archivo se abra sin problemas, sino
	 *         retorna 0
	 * @throws IOException e NumberFormatException e
	 */
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
		int numUsuario;// numero de usuario que inicio sesion
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo = "usuario" + numUsuario + ".txt";
		String[] lineas = new String[7];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			int i = 0;
			while (i < 7 && (linea = reader.readLine()) != null) {
				lineas[i] = linea;
				i++;
			}
			reader.close();

		} catch (IOException e) {
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
	
	/**
	 * Metodo que ordena los parametros necesarios para llamar al metodo actualizarLinea
	 */
	private void sumar() {

		int numUsuario;
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo = "usuario" + numUsuario + ".txt";

		double saldoSumar;
		saldoSumar = Double.parseDouble(text_montoDepositoD.getText());// Obtener el valor actual del JTextField

		actualizarLinea(nombreArchivo, 5, saldoSumar);

	}
	
	/**
	 * Metodo que actualiza el numeroLinea 5 (dolares) del txt restandole montoASumar por el deposito
	 * Ademas crea una cadena que se envia a registroMovimientosCuentaEspañol para el registro de movimientos
	 * @param nombreArchivo nombre del archivo que contiene los datos del usuario
	 * @param numeroLinea Linea del archivo con la que trabajaremos (Dolares)
	 * @param montoASumar monto que se sumara a la linea del archivo numeroLinea
	 */
	public static void actualizarLinea(String nombreArchivo, int numeroLinea, double montoASumar) {
		String DolaresAntes = Dolares;
		// Obtener la fecha y hora actuales
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		// Formatear la fecha y hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fechaHoraFormateada = null;
		// Crea una lista para almacenar las líneas del archivo
		List<String> lineas = new ArrayList<>();
		// Bloque try-with-resources para asegurar el cierre del BufferedReader
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) { // Lee el archivo línea por línea
				lineas.add(linea); // Añade cada línea leída a la lista
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
			return;
		}

		// Verifica si el índice de la línea a modificar es válido
		if (numeroLinea < lineas.size()) {
			try {
				// Intenta convertir el contenido de la línea a un valor double
				double valorActual = Double.parseDouble(lineas.get(numeroLinea));
				// Suma el monto especificado al valor actual
				double nuevoValor = valorActual + montoASumar;
				// COLOCAR ESO EN TODOS LOS FRAMES PARA REGISTRAR LOS MOVIMIENTOS
				fechaHoraFormateada = fechaHoraActual.format(formatter);
				String m1;
				m1 = "Se realizo el deposito de " + montoASumar + " $. a " + DolaresAntes
						+ " $. su saldo actual es de: " + nuevoValor + " $. " + fechaHoraFormateada;
				registroMovimientos(m1);

				// Actualiza la línea en la lista con el nuevo valor
				lineas.set(numeroLinea, String.valueOf(nuevoValor));
				// Actualiza el saldo en la ventana existente
				lblNewLabel_saldo.setText(String.valueOf(nuevoValor));
				text_montoDepositoD.setText("");
			} catch (NumberFormatException e) {
				System.out
						.println("La linea " + (numeroLinea + 1) + " no contiene un numero valido: " + e.getMessage());
				return;
			}
		} else {
			System.out.println("El archivo no tiene suficientes lineas.");
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
			// Escribe cada linea de la lista de nuevo en el archivo
			for (String linea : lineas) {
				writer.write(linea);
				writer.newLine();
			}
			// Manejo de excepción en caso de error al escribir en el archivo
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

	/**
	 * Metodo quee al ser llamado solicita un parametro, una vez lo tiene abre el
	 * archivo de registro de movimientos o historial del usuario que se hace el
	 * deposito y lo registra en el archivo de movimientos
	 * @param mensaje mensaje o registro de actividad 
	 */
	public static void registroMovimientos(String mensaje) {
		int numUsuario; // Número de usuario que inició sesión
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo1 = "movimientos" + numUsuario + ".txt"; // Movimientos de usuario 1

		// Movimientos de usuario 2 ya está registrado en: MovOtherUser

		// Escribir contenido para el usuario 1, añadiendo al final del archivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo1, true))) {
			writer.write(mensaje);
			writer.newLine(); // Añadir una nueva línea después del contenido
			System.out.println("El contenido ha sido aniadido al archivo " + nombreArchivo1);
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo " + nombreArchivo1 + ": " + e.getMessage());
		}

	}

	/**
	 * Método main donde crearemos una instancia de nuestra clase, asignaremos su
	 * tamaño, cuando el usuario hace clic en el botón de cerrar la ventana la
	 * aplicación Java se terminará completamente, y la haremos visible
	 * @param args permite a tu programa recibir argumentos desde la línea de comandos cuando se ejecuta
	 */
	public static void main(String[] args) {
		devuelveDatosUsuario();
		DepositarDolares miVentana = new DepositarDolares();
		miVentana.setSize(900, 800);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}