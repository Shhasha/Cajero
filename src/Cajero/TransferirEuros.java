package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * La clase TransferirDolares implementa una interfase que ayuda al usuario con
 * el transferir dolares a cualquier otra cuenta (incluyendo dolares) de otro
 * usuario. Al ser un extends JFRAME se utiliza para crear una ventana con
 * características estándar de una ventana de aplicación gráfica (GUI).
 */
public class TransferirEuros extends JFrame {

	// --------------------------------------------------------
	// Atributos
	// --------------------------------------------------------
	private static String usuarioCorrespondiente; // IMPORTANTE, DATO GLOBAL usuarioCorrespondiente que es el numero de
													// archivo que contiene usuarioX.txt que ayudara a abrir otro
													// archivo mostrando los datos de ese usuario
	private int eleccionCuenta; // puede ser 1, 2 o 3
	private String eleccionIdioma;
	private static JTextField montoDeposito;
	private static JTextField numCuentaDeposito;
	private JTextField textFieldActivo;
	private static String usuario;
	private static String numCuenta;
	private static String PIN;
	private static String ci;
	private static String Bolivianos;
	private static String Dolares;
	private static String Euros;
	private static JLabel lblNewLabel_saldo;
	private static JTextField mensajeLabel = new JTextField();
	private int numeroUsuarios = 0;
	private String rutaArchivo = "contador.txt";
	private static String OtherUser;
	private static String MovOtherUser;
	private static String MovOtherUserIng;
	private JRadioButton rbtnBolivianos;// 1
	private JRadioButton rbtnEuros;// 2
	private JRadioButton rbtnDolares;// 3

	/**
	 * Dentro del método constructor creamos toda la parte gráfica del programa que
	 * contiene: JLabels para enseñar textos, un JTextField para que el usuario
	 * ingrese el monto de transferencia y el numero de usuario al que quiere
	 * transferir, rbtn botones de eseleccion para las cuentas . Un teclado con
	 * botones que contienen números del 0 al 9 los cuales funcionan al tener
	 * contacto con ellos se escribe en el JTextField que selecciones. Botones para
	 * "Aceptar", "Borrar", "Cancelar" y "Volver"
	 */
	public TransferirEuros() {
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

		// BOTON 1
		JButton btn_1 = new JButton("1"); // Creamos un botón con el texto "1"
		btn_1.setBounds(27, 11, 89, 38); // Configuración de la posición y tamaño del botón
		btn_1.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "1"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_1);

		// BOTON 4
		JButton btn_4 = new JButton("4");
		btn_4.setBounds(27, 60, 89, 38);
		btn_4.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "4"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_4);

		// BOTON 7
		JButton btn_7 = new JButton("7");
		btn_7.setBounds(27, 109, 89, 38);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "7"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_7);

		// BOTON 2
		JButton btn_2 = new JButton("2");
		btn_2.setBounds(126, 11, 89, 38);
		btn_2.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "2"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_2);

		// BOTON 5
		JButton btn_5 = new JButton("5");
		btn_5.setBounds(126, 60, 89, 38);
		btn_5.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "5"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_5);

		// BOTON 8
		JButton btn_8 = new JButton("8");
		btn_8.setBounds(126, 109, 89, 38);
		btn_8.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "8"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_8);

		// BOTON 3
		JButton btn_3 = new JButton("3");
		btn_3.setBounds(225, 11, 89, 38);
		btn_3.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "3"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_3);

		// BOTON 6
		JButton btn_6 = new JButton("6");
		btn_6.setBounds(225, 60, 89, 38);
		btn_6.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "6"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_6);

		// BOTON 9
		JButton btn_9 = new JButton("9");
		btn_9.setBounds(225, 109, 89, 38);
		btn_9.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "9"); // Agrega "4" al JTextField activo
				}
			}
		});
		panel_7.add(btn_9);

		// BOTON 0
		JButton btn_0 = new JButton("0");
		btn_0.setBounds(126, 158, 89, 38);
		btn_0.addActionListener(new ActionListener() { // Añadimos un ActionListener al botón para manejar su acción
			public void actionPerformed(ActionEvent e) { // Método que se ejecutará al presionar el botón
				if (textFieldActivo != null) {
					textFieldActivo.setText(textFieldActivo.getText() + "0"); // Agrega "4" al JTextField activo
				}
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
				if (verificarOtroUsuario()) {
					restar();

				} else if (Double.parseDouble(Bolivianos) == 0 && verificarOtroUsuario() == false) {
					mensajeLabel.setText(
							"No es posible realizar la transferencia debido a que no tiene saldo suficiente y la cuenta que ingreso no existe.");
					JOptionPane.showMessageDialog(null, mensajeLabel.getText());
				} else if (verificarOtroUsuario() == false) {
					mensajeLabel.setText(
							"No es posible realizar la transferencia debido a que no se encontro el otro usuario.");
					JOptionPane.showMessageDialog(null, mensajeLabel.getText());
				} else {
					mensajeLabel
							.setText("No es posible realizar la transferencia debido a que no cuenta con ese saldo.");
					JOptionPane.showMessageDialog(null, mensajeLabel.getText());
				}
			}
		});
		panel_7.add(btn_aceptar);

		JButton btn_ingresar = new JButton("Volver");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EuroFrame frameVentana = new EuroFrame();
				frameVentana.setVisible(true);
			}
		});
		btn_ingresar.setBounds(668, 194, 129, 38);
		panel_1.add(btn_ingresar);

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

		JLabel lblNewLabel_4 = new JLabel("€");
		lblNewLabel_4.setBounds(49, 36, 25, 14);
		panel_6.add(lblNewLabel_4);

		JPanel panel_opcione = new JPanel();
		panel_opcione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_opcione.setForeground(new Color(120, 171, 165));
		panel_opcione.setBackground(new Color(210, 255, 204));
		panel_opcione.setBounds(20, 50, 436, 120);
		panel_6.add(panel_opcione);
		panel_opcione.setLayout(null);

		JLabel txt_cantidad = new JLabel("Monto de transferencia");
		txt_cantidad.setBounds(10, 11, 189, 14);
		panel_opcione.add(txt_cantidad);

		montoDeposito = new JTextField(); /// ESCRIBIR
		montoDeposito.setBounds(89, 28, 272, 14);
		// Agregar un MouseListener al primer JTextField para detectar clics de ratón
		montoDeposito.addMouseListener(new MouseAdapter() {
			// Método que se ejecuta cuando se hace clic en el primer JTextField
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = montoDeposito; // Asignar el primer JTextField como activo
			}
		});
		// Agregar el primer JTextField al JFrame
		// add(textField1);
		panel_opcione.add(montoDeposito);

		JLabel lblNewLabel_4_1 = new JLabel("€");
		lblNewLabel_4_1.setBounds(67, 28, 29, 14);
		panel_opcione.add(lblNewLabel_4_1);

		JLabel txt_cantidad_1 = new JLabel("Cuenta de transferencia (numero)");
		txt_cantidad_1.setBounds(10, 47, 287, 14);
		panel_opcione.add(txt_cantidad_1);

		numCuentaDeposito = new JTextField(); /// ESCRIBIR
		numCuentaDeposito.setBounds(89, 64, 272, 14);
		numCuentaDeposito.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldActivo = numCuentaDeposito; // Selecciona textField2 cuando se hace clic en él
			}
		});
		// add(numCuentaDeposito); // Agrega textField2 al JFrame

		panel_opcione.add(numCuentaDeposito);

		JLabel lblNewLabel_nameUsuario = new JLabel(usuario);
		lblNewLabel_nameUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_nameUsuario.setBounds(71, 11, 280, 14);
		panel_6.add(lblNewLabel_nameUsuario);

		lblNewLabel_saldo = new JLabel(Euros);
		lblNewLabel_saldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_saldo.setBounds(71, 36, 280, 14);
		panel_6.add(lblNewLabel_saldo);

		JLabel lblDepositar = new JLabel("TRANSFERIR EUROS");
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

		JLabel lblbotonPin_1 = new JLabel("Ingrese la cuenta que desea:");
		lblbotonPin_1.setBounds(10, 81, 287, 14);
		panel_opcione.add(lblbotonPin_1);

		ButtonGroup group = new ButtonGroup();

		rbtnBolivianos = new JRadioButton("Bolivianos");
		rbtnBolivianos.setBounds(10, 102, 130, 14);
		panel_opcione.add(rbtnBolivianos);
		rbtnBolivianos.setBackground(new Color(210, 255, 204));
		group.add(rbtnBolivianos);

		rbtnBolivianos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se seleccionó Bolivianos");
				eleccionCuenta = 1;
			}
		});

		rbtnDolares = new JRadioButton("Dolares");
		rbtnDolares.setBounds(157, 102, 130, 14);
		panel_opcione.add(rbtnDolares);
		rbtnDolares.setBackground(new Color(210, 255, 204));
		group.add(rbtnDolares);

		rbtnDolares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se seleccionó Dolares");
				eleccionCuenta = 2;
			}
		});

		rbtnEuros = new JRadioButton("Euros");
		rbtnEuros.setBounds(300, 102, 130, 14);
		panel_opcione.add(rbtnEuros);
		rbtnEuros.setBackground(new Color(210, 255, 204));
		group.add(rbtnEuros);

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
		String textoActual = montoDeposito.getText(); // Obtenemos el texto actual del JTextField
		montoDeposito.setText(textoActual + numero); // Concatenamos el número presionado al texto actual y lo seteamos
														// en el JTextField
	}

	/**
	 * El método borrarNumero se activa si presionas el botón "Borrar" Si el
	 * JTextField en el que estes escribiendo es diferente de vacio obtiene la
	 * cadena que contiene el JTextField sin el último carácter y le reasigna ese
	 * valor
	 */
	private void borrarNumero() {
		String textoActual = textFieldActivo.getText();
		if (textoActual.length() > 0) {
			String textoNuevo = textoActual.substring(0, textoActual.length() - 1);
			textFieldActivo.setText(textoNuevo);
		}
	}

	/**
	 * El método borrarTodo se activa si presionas el botón "Cancelar" Borra el
	 * contenido de JTextField pin y numUsuario
	 */
	private void borrarTodo() {
		montoDeposito.setText(""); // Establecer el nuevo texto en el JTextField mandandole un String vacio (nada)
		numCuentaDeposito.setText("");
	}

	/**
	 * Abre el txt que tiene el usuario correspondiente que inicio sesion
	 * 
	 * @return numUsuariotxt en caso de que el archivo se abra sin problemas, sino
	 *         retorna 0
	 */ /// Abre el txt que tiene el numero GLOBAL del usuario que inicio sesion
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
	 * 
	 */
	private static void devuelveDatosUsuario() {
		int numUsuario;// número de usuario que inicio sesion
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo = "usuario" + numUsuario + ".txt";
		String[] lineas = new String[7];
		try {
			// Abre un BufferedReader para leer desde el archivo
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

			// Variable para almacenar cada línea leída del archivo
			String linea;

			// Indice para controlar el número de líneas leídas
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

		usuario = lineas[0];
		numCuenta = lineas[1];
		PIN = lineas[2];
		ci = lineas[3];
		Bolivianos = lineas[4];
		Dolares = lineas[5];
		Euros = lineas[6];
		System.out.println(usuario);
		System.out.println(numCuenta);
		System.out.println(PIN);

	}

	/**
	 * Método que comprueba que ambos JTextField esten llenos si montoDeposito esta
	 * vacio y numCuentaDeposito tambien esta vacio entonces nos saldra un mensaje
	 * diciendo que se llenen los datos, de lo contrario se llama al método
	 * verificarOtroUsuario()
	 */
	private void faltanDatos() {
		if (montoDeposito.getText().isEmpty() || numCuentaDeposito.getText().isEmpty()
				|| (!rbtnEuros.isSelected() && !rbtnDolares.isSelected() && !rbtnBolivianos.isSelected())) {
			mensajeLabel.setText("Por favor, complete todos los campos.");
			JOptionPane.showMessageDialog(null, mensajeLabel.getText());
		}

		else {
			verificarOtroUsuario();
		}

	}

	/**
	 * // Este metodo lee la cantidad de usuarios que tenemos, crea un
	 * BufferedReader que nos ayuda con la lectura de contador.txt y los guarda en
	 * una linea String
	 * 
	 * @return se nos retorna la cantidad de usuarios, en caso de que ocurra algun
	 *         error se retorna 0
	 * @throws IOException NumberFormatException en ambos casos me bota un mensaje
	 *                     de error
	 */
	private int LeerNumArchivo() {
		System.out.println("LeerNumArchivo()");
		int cantidadUsuarios = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));// rutaArchivo = "contador.txt";
			String linea = reader.readLine();
			reader.close();
			if (linea != null) {
				cantidadUsuarios = Integer.parseInt(linea);
				System.out.println("La cantidad de Usuarios es de " + (cantidadUsuarios - 1));
			}
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
	 * Berificamos que el JTextField numCuentaDeposito del otro usuario concuerde
	 * con alguno de los datos de los archivos txt de usuarios registrados,
	 * obtenemos el nmero de usuarios y con un contador vamos aumentando de posicion
	 * hast aencontrar algun archivo que concuerde con la cuenta a la que queremos
	 * depositar. Crea "usuario" + cont + ".txt", "movimientos" + cont + ".txt" y
	 * "Transactions" + cont + ".txt"; si se nos devuelve nombrArchivoEncontrado
	 * como true entonces podemos seguir con el proceso de transferencia
	 * 
	 * @return true o false
	 */
	public boolean verificarOtroUsuario() {
		int numeroUsuarios = LeerNumArchivo() - 1; // Aquí conseguimos la cantidad de usuarios
		int cont = 1;
		String OtroUsuarioNCuenta = numCuentaDeposito.getText();
		String nombreArchivo, transfOtroUs;
		String MovOtherUserIng1;
		System.out.println("RevisarCredenciales()");

		while (cont <= numeroUsuarios) { // Revisamos entre cada archivo de usuario: usuario1.txt, usuario2.txt, etc.
			nombreArchivo = "usuario" + cont + ".txt";
			transfOtroUs = "movimientos" + cont + ".txt";
			MovOtherUserIng1 = "Transactions" + cont + ".txt";
			String linea;

			try {
				// Abre el archivo para lectura
				BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
				boolean nombrArchivoEncontrado = false;

				// Lee cada línea del archivo hasta llegar al final o hasta encontrar las
				// coincidencias
				while ((linea = reader.readLine()) != null && !linea.isEmpty()) {
					if (linea.equals(OtroUsuarioNCuenta)) {
						nombrArchivoEncontrado = true;
						OtherUser = nombreArchivo;
						MovOtherUser = transfOtroUs;
						MovOtherUserIng = MovOtherUserIng1;
						break;
					}
				}

				// Cierra el BufferedReader después de leer
				reader.close();

				// Verifica si el dato fue encontrado
				if (nombrArchivoEncontrado) {
					System.out.println("Los datos se encontraron con éxito.");
					return true; // Retorna true si el usuario es encontrado
				}

			} catch (IOException e) {
				// Maneja cualquier excepción de entrada/salida que pueda ocurrir
				System.out.println("Error al leer el archivo: " + e.getMessage());
			}

			cont++;
		}
		return false; // Retorna false si no se encuentra el usuario
	}

	/**
	 * Método que ve el tipo de transferencia que queremos realizar, si
	 * rbtnBolivianos es seleccionado se mandara (nombreArchivo, linea te txt en que
	 * esta los euros que es por el frame en que trabajamos 6 = euros 5 = dolares, 4
	 * = bolivianos, numero de línea que es el tipo de cuenta a la que queremos
	 * mandar la transferencia, saldo a restar y saldo a sumar que en si son lo
	 * mismo)
	 */
	private void restar() {
		int numUsuario; // Número de usuario que inició sesión
		double saldoRestar;
		double saldoSumar;
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo = "usuario" + numUsuario + ".txt";

		saldoRestar = Double.parseDouble(montoDeposito.getText()); // Usuario que transfiere
		saldoSumar = Double.parseDouble(montoDeposito.getText()); // Usuario que recibe transferencia

		if (rbtnBolivianos.isSelected()) {
			actualizarLinea(nombreArchivo, OtherUser, 6, 4, saldoRestar, saldoSumar);
		} else if (rbtnDolares.isSelected()) {
			actualizarLinea(nombreArchivo, OtherUser, 6, 5, saldoRestar, saldoSumar);
		} else if (rbtnEuros.isSelected()) {
			actualizarLinea(nombreArchivo, OtherUser, 6, 6, saldoRestar, saldoSumar);
		} else {
			System.out.println("No se pudo realizar la resta");
		}

	}

	/**
	 * En este método depende mucho del cuarto parametro "numeroLineaRecibe" qur
	 * damos, si es 4 (Bolivianos) y el archivo del usuario que hace la
	 * transferencia "nombreArchivo" y si el que recibe la transferencia "OtherUser"
	 * corresponde a un numero de lineas existente en el .txt de ambos entonces Si
	 * el numeroLineaRecibe es 4 entonces haremos la converion de euros a Bolivianos
	 * y hacemos el registro correcto para la transferencia. Si el numeroLineaRecibe
	 * es 5 entonces haremos la converion de euros a Dolares y hacemos el registro
	 * correcto para la transferencia. Si el numeroLineaRecibe es 6 entonces no
	 * haremos ninguna converion de euros a Dolares y hacemos el registro correcto
	 * para la transferencia. Luego tambien se crea un String que anota la
	 * transferencia que hizo el usuario nombreArchivo al otro usuario OtherUser. Se
	 * llama al metodo registroMovimientosCuentaEspañol(m1, m2); y se le pasa las
	 * cadenas creadas para ambos usuarios m1, y m2 respectivamente
	 * 
	 * @param nombreArchivo     nombre del archivo del usuario que transfiere
	 * @param OtherUser         nombre del archivo del usuario que recibe la
	 *                          transferencia
	 * @param numeroLineaDa     numero de linea de archivo del usuario que
	 *                          transfiere
	 * @param numeroLineaRecibe numero de linea de archivo del usuario que recibe la
	 *                          transferencia
	 * @param montoARestar      monto que se resta al usuario que transfiere
	 * @param montoASumar       monto que se suma al usuario que recibe la
	 *                          transferencia
	 */
	public static void actualizarLinea(String nombreArchivo, String OtherUser, int numeroLineaDa, int numeroLineaRecibe,
			double montoARestar, double montoASumar) {
		// Crea listas para almacenar las líneas de los archivos
		boolean exitoso = false;
		double nuevoValor = 0;
		double nuevoValorOtroUsuario = 0;
		double transfBol = 0, transfDol = 0;
		// Obtener la fecha y hora actuales
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		// Formatear la fecha y hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fechaHoraFormateada = null;

		String almnontDepos = "";
		String almNumCuenta = "";
		List<String> lineas = new ArrayList<>();
		List<String> lineasOtroUsuario = new ArrayList<>();

		// Leer el archivo del primer usuario
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				lineas.add(linea); // Añade cada línea leída a la lista
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo del primer usuario: " + e.getMessage());
			return;
		}

		// Leer el archivo del otro usuario
		try (BufferedReader reader = new BufferedReader(new FileReader(OtherUser))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				lineasOtroUsuario.add(linea); // Añade cada línea leída a la lista
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo del segundo usuario: " + e.getMessage());
			return;
		}

		// Verifica si el índice de la línea a modificar es válido
		if (numeroLineaDa < lineas.size() && numeroLineaRecibe < lineasOtroUsuario.size()) {
			try {
				// Intenta convertir el contenido de la línea a un valor double
				double valorActual = Double.parseDouble(lineas.get(numeroLineaDa));
				double valorActualOtroUsuario = Double.parseDouble(lineasOtroUsuario.get(numeroLineaRecibe));

				if (montoARestar <= valorActual) {
					// Resta el monto especificado al valor actual del primer usuario
					nuevoValor = valorActual - montoARestar;
					// Suma el monto especificado al valor actual del otro usuario
					// nuevoValorOtroUsuario=0;
					double tipoCambioEurosABolivianos = 8.16; // 1 EUR = 8.16 BOB
					double tipoCambioEurosADolares = 1.10; // 1 EUR = 1.10 USD

					if (numeroLineaRecibe == 4) { // otra cuenta = Bolivianos, montoASumar = € -> Bs
						transfBol = montoASumar * tipoCambioEurosABolivianos; // montoEnEuros *
																				// tipoCambioEurosABolivianos;
						transfBol = Math.round(transfBol * 100.0) / 100.0;
						nuevoValorOtroUsuario = valorActualOtroUsuario + transfBol;
						nuevoValorOtroUsuario = Math.round(nuevoValorOtroUsuario * 100.0) / 100.0;
					} else if (numeroLineaRecibe == 5) { // otra cuenta = Dolares, montoASumar = € -> $
						transfDol = montoASumar * tipoCambioEurosADolares; // montoEnEuros * tipoCambioEurosADolares;
						transfDol = Math.round(transfDol * 100.0) / 100.0;
						nuevoValorOtroUsuario = valorActualOtroUsuario + transfDol;
						nuevoValorOtroUsuario = Math.round(nuevoValorOtroUsuario * 100.0) / 100.0;
					} else if (numeroLineaRecibe == 6) { // otra cuenta = Euros, montoASumar = € -> €
						nuevoValorOtroUsuario = valorActualOtroUsuario + montoASumar;
						nuevoValorOtroUsuario = Math.round(nuevoValorOtroUsuario * 100.0) / 100.0;
					}

					// Actualiza la línea en las listas con los nuevos valores
					lineas.set(numeroLineaDa, String.valueOf(nuevoValor));
					lineasOtroUsuario.set(numeroLineaRecibe, String.valueOf(nuevoValorOtroUsuario));

					mensajeLabel.setText("Transferencia exitosa.");
					JOptionPane.showMessageDialog(null, mensajeLabel.getText());

					// COLOCAR ESO EN TODOS LOS FRAMES PARA REGISTRAR LOS MOVIMIENTOS
					fechaHoraFormateada = fechaHoraActual.format(formatter);

					// COLOCAR ESO EN TODOS LOS FRAMES PARA REGISTRAR LOS MOVIMIENTOS

					// Actualiza el saldo en la ventana existente

					almnontDepos = montoDeposito.getText();
					almNumCuenta = numCuentaDeposito.getText();
					lblNewLabel_saldo.setText(String.valueOf(nuevoValor));
					montoDeposito.setText("");
					numCuentaDeposito.setText("");
					exitoso = true;

				} else {
					mensajeLabel
							.setText("No es posible realizar la transferencia debido a que no cuentas con ese saldo.");
					JOptionPane.showMessageDialog(null, mensajeLabel.getText());
				}

			} catch (NumberFormatException e) {
				System.out.println(
						"La línea " + (numeroLineaDa + 1) + " no contiene un número válido: " + e.getMessage());
				return;
			}
		} else {
			System.out.println("El archivo no tiene suficientes líneas.");
			return;
		}

		// Escribir el archivo del primer usuario con el contenido actualizado
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
			for (String linea : lineas) {
				writer.write(linea);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo del primer usuario: " + e.getMessage());
		}

		// Escribir el archivo del otro usuario con el contenido actualizado
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(OtherUser))) {
			for (String linea : lineasOtroUsuario) {
				writer.write(linea);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo del segundo usuario: " + e.getMessage());
		}

		// PARA LLAMAR AL MÉTODO QUE REGISTRA MOVIMIENTOS
		if (exitoso) {

			int numUsuario; // Número de usuario que inició sesión
			numUsuario = abrirUsuarioCorrespondiente();
			String nombreArchivo1 = "usuario" + numUsuario + ".txt"; // Movimientos de usuario 1

			List<String> lineas1 = new ArrayList<>();
			List<String> lineasOtroUsuario2 = new ArrayList<>();
			String resultadoPrimerUsuario = "";
			String resultadoOtroUsuario = "";

			try (BufferedReader reader1 = new BufferedReader(new FileReader(nombreArchivo1))) {
				String linea1;
				while ((linea1 = reader1.readLine()) != null) {
					lineas1.add(linea1); // Añade cada línea leída a la lista
				}
			} catch (IOException e) {
				System.out.println("Error al leer el archivo del primer usuario: " + e.getMessage());

			}

			// Leer el archivo del otro usuario
			try (BufferedReader reader2 = new BufferedReader(new FileReader(OtherUser))) {
				String linea2;
				while ((linea2 = reader2.readLine()) != null) {
					lineasOtroUsuario2.add(linea2); // Añade cada línea leída a la lista
				}
			} catch (IOException e) {
				System.out.println("Error al leer el archivo del segundo usuario: " + e.getMessage());

			}

			// Verifica si el índice de la línea es válido
			if (numeroLineaDa < lineas.size() && numeroLineaRecibe < lineasOtroUsuario.size()) {
				try {
					// Obtener el contenido de la línea como valor double
					double valorActual = Double.parseDouble(lineas.get(numeroLineaDa));
					double valorActualOtroUsuario = Double.parseDouble(lineasOtroUsuario.get(numeroLineaRecibe));

					// Retorna los valores de las líneas
					resultadoPrimerUsuario = String.valueOf(valorActual);
					resultadoOtroUsuario = String.valueOf(valorActualOtroUsuario);

				} catch (NumberFormatException e) {
					System.out.println(
							"La línea " + (numeroLineaDa + 1) + " no contiene un número válido: " + e.getMessage());

				}
			} else {
				System.out.println("El archivo no tiene suficientes líneas.");

			}

			String m1, m2;
			// nuevoValor nuevoValorOtroUsuario

			if (numeroLineaRecibe == 4) { // otra cuenta = Bolivianos
				m1 = "La transferencia de " + almnontDepos + " €. se realizo con éxito a la cuenta " + almNumCuenta
						+ " , su saldo actual es de: " + nuevoValor + " €. " + fechaHoraFormateada;
				m2 = "La cuenta " + numCuenta + " realizo una transferencia de " + almnontDepos
						+ " €. que en bolivianos es: " + transfBol + " Bs. Su saldo actual es de: "
						+ nuevoValorOtroUsuario + " Bs. " + fechaHoraFormateada;
				registroMovimientos(m1, m2);

			} else if (numeroLineaRecibe == 5) { // otra cuenta = Dolares
				m1 = "La transferencia de " + almnontDepos + " €. se realizo con éxito a la cuenta " + almNumCuenta
						+ " , su saldo actual es de: " + nuevoValor + " €. " + fechaHoraFormateada;
				m2 = "La cuenta " + numCuenta + " realizo una transferencia de " + almnontDepos
						+ " €. que en dolares es: " + transfDol + " $. Su saldo actual es de: " + nuevoValorOtroUsuario
						+ " $. " + fechaHoraFormateada;
				registroMovimientos(m1, m2);

			} else if (numeroLineaRecibe == 6) { // otra cuenta = Euros
				m1 = "La transferencia de " + almnontDepos + " €. se realizo con éxito a la cuenta " + almNumCuenta
						+ " , su saldo actual es de: " + nuevoValor + " €. " + fechaHoraFormateada;
				m2 = "La cuenta " + numCuenta + " realizo una transferencia de " + almnontDepos
						+ " €. Su saldo actual es de: " + nuevoValorOtroUsuario + " €. " + fechaHoraFormateada;
				registroMovimientos(m1, m2);

			}
		}
	}

	/**
	 * Metodo quee al ser llamado solicita 2 parametros, una vez los tiene abre el
	 * archivo para el usuario que transfirio y almacena el mensaje uno. Luego abre
	 * el archivo de registro de movimientos o historial del usuario al que se hace
	 * la transferencia y lo registra
	 * 
	 * @param contenidoUser1 datos que usaremos del archivo del usuario que
	 *                       transfiere
	 * @param contenidoUser2 datos que usaremos del archivo del usuario que recibe
	 *                       la transferencia
	 */
	public static void registroMovimientos(String contenidoUser1, String contenidoUser2) {
		int numUsuario; // Número de usuario que inició sesión
		numUsuario = abrirUsuarioCorrespondiente();
		String nombreArchivo1 = "movimientos" + numUsuario + ".txt"; // Movimientos de usuario 1

		// Movimientos de usuario 2 ya está registrado en: MovOtherUser

		// Escribir contenido para el usuario 1, añadiendo al final del archivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo1, true))) {
			writer.write(contenidoUser1);
			writer.newLine(); // Añadir una nueva línea después del contenido
			System.out.println("El contenido ha sido añadido al archivo " + nombreArchivo1);
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo " + nombreArchivo1 + ": " + e.getMessage());
		}

		// Escribir contenido para el usuario 2, añadiendo al final del archivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(MovOtherUser, true))) {
			writer.write(contenidoUser2);
			writer.newLine(); // Añadir una nueva línea después del contenido
			System.out.println("El contenido ha sido añadido al archivo " + MovOtherUser);
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo " + MovOtherUser + ": " + e.getMessage());
		}
	}

	/**
	 * Método main donde crearemos una instancia de nuestra clase, asignaremos su
	 * tamaño, cuando el usuario hace clic en el botón de cerrar la ventana la
	 * aplicación Java se terminará completamente, y la haremos visible
	 * 
	 * @param args permite a tu programa recibir argumentos desde la línea de comandos cuando se ejecuta
	 */
	public static void main(String[] args) {
		TransferirEuros miVentana = new TransferirEuros();
		miVentana.setSize(900, 800);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}