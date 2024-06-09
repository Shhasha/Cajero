package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * La clase Registro implementa una interfase de inicio de sesión, el usuario
 * que ya creo cuenta con anterioridad puede iniciar seseión Al ser un extends
 * JFRAME se utiliza para crear una ventana con características estándar de una
 * ventana de aplicación gráfica (GUI).
 */
public class Registro extends JFrame {

	// --------------------------------------------------------
	// Atributos
	// --------------------------------------------------------
	private ArrayList<String> lineas = new ArrayList<>(); // Declara un ArrayList para almacenar las líneas del archivo
	private JLabel lblcajeroAutm;
	private JLabel lblbienvenido;
	private JLabel lblbotonNumUsuario;
	private JLabel lblbotonPin;
	private JButton btnbotonCancelar;
	private JButton btnbotonBorrar;
	private JButton btnbotonAceptar;
	private JButton btnbotonCrearCuenta;
	private JButton btnbotonSalir;
	private JButton btnMostrarSpanish;
	private JButton btnMostrarEnglish;
	private JTextField textField_numUsuario;
	private JPasswordField textField_pin;
	private JTextField mensajeLabel = new JTextField();
	private JTextField text_montoDeposito;
	private JTextField textFieldActivo;
	private JRadioButton rbtnBolivianos;
	private JRadioButton rbtnDolares;
	private JRadioButton rbtnEuros;
	private JButton btnAceptar;
	private int numeroUsuarios = 0;
	private String rutaArchivo = "contador.txt";
	private String usuarioCorrespondiente;
	private int eleccionCuenta;
	private String eleccionIdioma = "esp";

	/**
	 * Dentro del método constructor creamos toda la parte gráfica del programa que
	 * contiene: JLabels para enseñar textos JTextField para que el usuario ingrese
	 * texto interactuando con el programa Un teclado con botones que contienen
	 * números del 0 al 9 los cuales funcionan al tener contacto con ellos se
	 * escribe en el JTextField que selecciones Botones para "Aceptar", "Borrar",
	 * "Cancelar", "Iniciar sesión" y Salir y también tiene rbtncon 3 opciones queu
	 * son los tipos de cuenta, 1Bs, 2 $, 3E
	 */
	public Registro() {

		setSize(900, 800);// definimos el tamaño de mi ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		// BOTON 1
		JButton btn_1 = new JButton("1");
		btn_1.setBounds(27, 11, 89, 38);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribirNumero("1");
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

		btnbotonCancelar = new JButton("Cancelar");
		btnbotonCancelar.setBounds(414, 11, 128, 38);
		btnbotonCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				borrarTodo();

			}
		});
		panel_7.add(btnbotonCancelar);

		btnbotonBorrar = new JButton("Borrar");
		btnbotonBorrar.setBounds(414, 60, 128, 38);
		btnbotonBorrar.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su
																// acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				borrarNumero(); // Llamamos al método borrarNumero al darle clic al boton
			}
		});
		panel_7.add(btnbotonBorrar);

		btnbotonAceptar = new JButton("Aceptar");
		btnbotonAceptar.setBounds(414, 109, 128, 38);
		btnbotonAceptar.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su
																	// acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				faltanDatos(); // Llamamos al método faltanDatos al darle clic al boton
			}
		});
		panel_7.add(btnbotonAceptar);

		btnbotonSalir = new JButton("Salir");
		btnbotonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnbotonSalir.setBounds(668, 194, 129, 38);
		panel_1.add(btnbotonSalir);

		btnbotonCrearCuenta = new JButton("Crear Cuenta");
		btnbotonCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CrearCuenta crearCuenta = new CrearCuenta();
				crearCuenta.setVisible(true);
			}
		});
		btnbotonCrearCuenta.setBounds(669, 138, 128, 38);
		panel_1.add(btnbotonCrearCuenta);

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
		panel_4.setBounds(26, 72, 498, 216);
		panel_5.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(210, 255, 204));
		panel_6.setBounds(10, 41, 478, 163);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Por favor ingrese sus datos:");
		lblNewLabel_1.setBounds(10, 11, 241, 14);
		panel_4.add(lblNewLabel_1);

		lblbotonNumUsuario = new JLabel("Número de usuario");
		lblbotonNumUsuario.setBounds(20, 11, 191, 14);
		panel_6.add(lblbotonNumUsuario);

		lblbotonPin = new JLabel("Contraseña");
		lblbotonPin.setBounds(20, 57, 104, 14);
		panel_6.add(lblbotonPin);

		// TEXTFIELD NUSUARIO
		textField_numUsuario = new JTextField(); // Escribir número usuario
		textField_numUsuario.setBounds(54, 32, 356, 14);
		textField_numUsuario.addMouseListener(new MouseAdapter() {
			// Método que se ejecuta cuando se hace clic en el primer JTextField
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = textField_numUsuario; // textField_numUsuario será igual al activo textFieldActivo
			}
		});
		// Agregar el primer JTextField al JFrame
		panel_6.add(textField_numUsuario);

		// TEXTFIELD PIN
		textField_pin = new JPasswordField(); // Escribir pin
		textField_pin.setBounds(54, 73, 356, 14);
		textField_pin.addMouseListener(new MouseAdapter() {
			// Método que se ejecuta cuando se hace clic en el primer JTextField
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = textField_pin; // Asignar el primer JTextField como activo
			}
		});
		// Agregar el primer JTextField al JFrame
		panel_6.add(textField_pin);

		lblbienvenido = new JLabel("BIENVENIDO"); // "Bienvenido o Welcome"Le pasamos el label y la variable que
													// almacena su dato
		lblbienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		lblbienvenido.setForeground(Color.LIGHT_GRAY);
		lblbienvenido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblbienvenido.setBackground(Color.LIGHT_GRAY);
		lblbienvenido.setBounds(26, 21, 498, 40);
		panel_5.add(lblbienvenido);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 807, 59);
		panel.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);

		lblcajeroAutm = new JLabel("CAJERO AUTOMATICO"); // "CAJERO AUTOMATICO O ATM"
		lblcajeroAutm.setBackground(new Color(192, 192, 192));
		lblcajeroAutm.setHorizontalAlignment(SwingConstants.CENTER);
		lblcajeroAutm.setForeground(new Color(192, 192, 192));
		lblcajeroAutm.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblcajeroAutm.setBounds(97, 11, 633, 40);
		panel_2.add(lblcajeroAutm);

		// BOTONES DE SELECCIÓN
		JLabel lblbotonPin_1 = new JLabel("Ingrese la cuenta que desea:");
		lblbotonPin_1.setBounds(20, 98, 207, 14);
		ButtonGroup group = new ButtonGroup();

		// 3. Establecer la posición y el tamaño del botón de radio.
		// Los parámetros (323, 116) especifican la posición (x, y) del botón en el
		// contenedor.
		// Los parámetros (87, 40) especifican el tamaño (ancho, alto) del botón.

		rbtnBolivianos = new JRadioButton("Bolivianos");
		rbtnBolivianos.setBackground(new Color(210, 255, 204));
		rbtnBolivianos.setBounds(20, 116, 87, 40);

		rbtnDolares = new JRadioButton("Dolares");
		rbtnDolares.setBackground(new Color(210, 255, 204));
		rbtnDolares.setBounds(173, 116, 87, 40);

		rbtnEuros = new JRadioButton("Euros");
		rbtnEuros.setBackground(new Color(210, 255, 204));
		rbtnEuros.setBounds(323, 116, 87, 40);

		group.add(rbtnBolivianos);
		group.add(rbtnDolares);
		group.add(rbtnEuros);
		panel_6.add(rbtnEuros);
		panel_6.add(rbtnDolares);
		panel_6.add(rbtnBolivianos);// Esta línea añade el JRadioButton al JPanel, lo que permite que el botón de
									// radio sea visible y funcional dentro del panel.

		panel_6.add(lblbotonPin_1);// Esta línea añade el JLabel al JPanel, lo que permite que la etiqueta sea
									// visible dentro del panel.

		// Añadir ActionListener a cada JRadioButton
		rbtnBolivianos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se seleccionó Bolivianos");
				eleccionCuenta = 1;
			}
		});

		rbtnDolares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se seleccionó Dolares");
				eleccionCuenta = 2;
			}
		});

		rbtnEuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se seleccionó Euros");
				eleccionCuenta = 3;
			}
		});
	}

	/**
	 * Método para escribir un número en el JTextField que seleccionemos de los 2
	 * que hay
	 * 
	 * @param numero
	 */
	private void escribirNumero(String numero) { // txt_saldo es el JTextField de saldo para mostrar los números
		if (textFieldActivo != null) {
			textFieldActivo.setText(textFieldActivo.getText() + numero); // Agrega "4" al JTextField activo
			/*
			 * String textoActual = textField_numUsuario.getText(); // Obtenemos el texto
			 * actual del JTextField textField_numUsuario.setText(textoActual + numero); //
			 * Concatenamos el número presionado al texto actual y lo seteamos en el
			 * JTextField
			 */
		}
	}

	/**
	 * El método borrarNumero se activa si presionas el botón "Borrar" Si el
	 * JTextField en el que estes escribiendo es diferente de vacio obtiene la
	 * cadena que contiene el JTextField sin el último carácter y le reasigna ese
	 * valor
	 */
	private void borrarNumero() {
		String textoActual = textFieldActivo.getText();
		if (textFieldActivo != null) {
			if (textoActual.length() > 0) {
				String textoNuevo = textoActual.substring(0, textoActual.length() - 1);
				textFieldActivo.setText(textoNuevo);
			}
		}
	}

	/**
	 * El método borrarTodo se activa si presionas el botón "Cancelar" Borra el
	 * contenido de JTextField pin y numUsuario
	 */
	private void borrarTodo() {
		textField_pin.setText(""); // Establecer el nuevo texto en el JTextField mandandole un String vacio (nada)
		textField_numUsuario.setText("");
	}

	/**
	 * El método faltanDatos se activa si presionas el botón "Aceptar". Verifica si
	 * faltan datos en los campos de texto JTextField numUsuario y pin y muestra un
	 * mensaje si es así. Si los textField numUsuario y pin están vacíos, o ninguno
	 * de los rbtn (botones de elección de cuenta) estan seleccionados se bora un
	 * mensaje que pide que completemos los datos. De lo contrario se llama al
	 * método RevisarCredenciales()
	 */
	private void faltanDatos() {
		if (textField_numUsuario.getText().isEmpty() || textField_pin.getText().isEmpty()
				|| (!rbtnBolivianos.isSelected() && !rbtnDolares.isSelected() && !rbtnEuros.isSelected())) {
			mensajeLabel.setText("Por favor, complete todos los campos.");
			JOptionPane.showMessageDialog(null, mensajeLabel.getText());
		} else {

			RevisarCredenciales();
		}
	}

	/**
	 * El método RevisarCredenciales compara los datos ingresados en
	 * textField_numUsuario y textField_pin con los datos que hay en cada archivo de
	 * un usuario, revisa hasata que no quede ninguno, en caso de que no quede
	 * ninguno pues el usuario no esta registrado, pero en caso de que si
	 * iniciaremos sesion con los datos respectivos del usuario entonces abriremos
	 * el usuario correspondiente a los TextField e iremos a otro frame. No sin
	 * antes ver el valor de eleccionCuenta, si es 1 se va al frame de Bs, si es 2
	 * se va al frame de $, si vale 3 se ira al frame de E. Una vez se registre
	 * correctamente el usuario se creara un archivo registrarIniSesion donde se
	 * registrara el momento exacto en que inicio sesión
	 * 
	 * @throws IOException
	 */
	private void RevisarCredenciales() { // Aqui
		numeroUsuarios = (LeerNumArchivo() - 1); // Aqui conseguimos la cantidad de usuario
		int cont = 1;
		String nombreArchivo;
		String registrarIniSesion;
		String numUsuario = textField_numUsuario.getText();
		String pin = textField_pin.getText();
		usuarioCorrespondiente = "usuarioCorrespondiente.txt"; // IMPORTANTE, nombre del archivo que tiene almacenado el
																// numero de usuario que inicia sesión
		// System.out.println("RevisarCredenciales()");

		boolean datosCorrectos = false;

		while (cont <= numeroUsuarios) {
			nombreArchivo = "usuario" + cont + ".txt";
			registrarIniSesion = "movimientos" + cont + ".txt";
			String linea; // Declara una variable para almacenar cada línea leída del archivo
			// textField_numUsuario.getText().isEmpty() || textField_pin.getText().isEmpty()

			try {
				// Abre el archivo para lectura
				BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

				boolean usuarioEncontrado = false;
				boolean pinEncontrado = false;

				// Lee cada línea del archivo hasta llegar al final o hasta encontrar las
				// coincidencias
				while ((linea = reader.readLine()) != null && !linea.isEmpty()) {
					if (linea.equals(numUsuario)) {
						usuarioEncontrado = true;
					}
					if (linea.equals(pin)) {
						pinEncontrado = true;
					}
				}

				// Verifica si ambos datos fueron encontrados
				if (usuarioEncontrado && pinEncontrado) {
					// Obtener la fecha y hora actuales
					LocalDateTime fechaHoraActual = LocalDateTime.now();
					// Formatear la fecha y hora
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String fechaHoraFormateada = null;

					// COLOCAR ESO EN TODOS LOS FRAMES PARA REGISTRAR LOS MOVIMIENTOS
					fechaHoraFormateada = fechaHoraActual.format(formatter);
					String mensaje = "Se inicio sesion el: " + fechaHoraFormateada;
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(registrarIniSesion, true))) {
						writer.write(mensaje);
						writer.newLine(); // Escribir una nueva línea después del mensaje
					} catch (IOException e) {
						e.printStackTrace();
					}

					datosCorrectos = true;
					while ((linea = reader.readLine()) != null) {
						System.out.println(linea);
					}
					try {
						FileWriter writer = new FileWriter(usuarioCorrespondiente); // Abre el archivo para escribir, si
																					// no existe, lo crea
						// Escribe el número en el archivo
						writer.write(String.valueOf(cont + "\n" + eleccionIdioma)); // Convierte el número a una cadena
																					// y lo escribe en el archivo siendo
																					// cont el número de usuario y
																					// eleccion el tipo de cuenta, 1 bs,
																					// 2 $, 3 E

						// Cierra el FileWriter para asegurar que los datos se escriban correctamente en
						// el archivo
						writer.close(); // Cierra el archivo para asegurarse de que los datos se escriban correctamente
					} catch (IOException e) {
						// Maneja cualquier excepción de entrada/salida que pueda ocurrir
						System.out.println("Error al crear el archivo: " + e.getMessage());
					}

					if (eleccionCuenta == 1) {
						setVisible(false);
						BolivianosFrame vent = new BolivianosFrame();
						vent.setVisible(true);
						System.out.println("1");
					}

					if (eleccionCuenta == 2) {
						setVisible(false);
						DolaresFrame vent = new DolaresFrame();
						vent.setVisible(true);
						System.out.println("2");
					}

					if (eleccionCuenta == 3) {
						setVisible(false);
						EuroFrame vent = new EuroFrame();
						vent.setVisible(true);
						System.out.println("3");
					} else {
						setVisible(false);
					}

					break; // Sal del bucle ya que las credenciales son correctas

				}

				// Cierra el BufferedReader después de leer
				reader.close();

			} catch (IOException e) {
				// Maneja cualquier excepción de entrada/salida que pueda ocurrir
				System.out.println("Error al leer el archivo: " + e.getMessage());
			}

			cont++;
		}
		if (!datosCorrectos) {
			mensajeLabel.setText("Datos incorrectos");
			JOptionPane.showMessageDialog(null, mensajeLabel.getText());
			setVisible(false);
		}
		System.out.println("UserCorres" + usuarioCorrespondiente);

	}

	/**
	 * El método LeerNumArchivo abre el archivo "contador.txt" que se encarga de
	 * registrar la cantidad de usuarios que hay en ese momento almacenandolos en el
	 * String linea Si linea no esta vacia retorna cantidadUsuarios que almacena
	 * linea convertido a entero
	 * 
	 * @return si el archivo puede leerse retorna cantidadUsuarios, en caso de no
	 *         leer el archivo retorna 0
	 * @throws IOException e imprime en pantalla que hubo un error al leer el
	 *                     archivo. NumberFormatException e imprime en consola que
	 *                     el contenido del archivo no es valido
	 */
	private int LeerNumArchivo() {
		int cantidadUsuarios = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo)); // rutaArchivo = "contador.txt";
			String linea = reader.readLine();
			reader.close();
			if (linea != null) {
				cantidadUsuarios = Integer.parseInt(linea);
				// System.out.println("La cantidad de Usuarios es de " + (cantidadUsuarios -
				// 1));
			}
			// Retorno del número leído
			return cantidadUsuarios;

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
	 * Método main donde crearemos una instancia de nuestra clase, asignaremos su
	 * tamaño, cuando el usuario hace clic en el botón de cerrar la ventana la
	 * aplicación Java se terminará completamente, y la haremos visible
	 * @param args permite a tu programa recibir argumentos desde la línea de comandos cuando se ejecuta
	 */
	public static void main(String[] args) {
		Registro miVentana = new Registro();
		miVentana.setSize(900, 800);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}
