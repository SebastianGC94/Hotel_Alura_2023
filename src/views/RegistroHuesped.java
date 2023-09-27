package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import controladores.*;
import modelo.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtIdReserva;
	private JComboBox<Format> txtNacionalidad;
	private JLabel lblVolver;
	int xMouse, yMouse;

	private HuespedControlador controlHuesped;
	private JTextField txtIdentificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public RegistroHuesped(int idReserva) {
		new ReservaControlador();
		this.controlHuesped = new HuespedControlador();

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/iconoHotel.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(false);
		contentPane.setLayout(null);

		JPanel header = new JPanel();
		header.setForeground(Color.WHITE);
		header.setBounds(0, 0, 674, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				lblVolver.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				lblVolver.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 91, 36);
		header.add(btnAtras);

		lblVolver = new JLabel("Regresar ");
		lblVolver.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/iconoVolver25px.png")));
		lblVolver.setBackground(new Color(255, 255, 255));
		lblVolver.setForeground(new Color(0, 0, 128));
		lblVolver.setHorizontalAlignment(SwingConstants.LEFT);
		lblVolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblVolver.setBounds(0, 0, 91, 36);
		btnAtras.add(lblVolver);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);

		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] { "Colombia", "Afganistán", "Albania",
				"Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina",
				"Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin",
				"Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania (Myanmar)", "Bolivia", "Bosnia y Herzegovina",
				"Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya",
				"Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Colombia", "Comoras",
				"Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca",
				"Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia",
				"Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Fiyi", "Filipinas", "Finlandia",
				"Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guinea",
				"Guinea-Bisáu", "Guinea Ecuatorial", "Guyana", "Haití", "Honduras", "Hungría", "India", "Indonesia",
				"Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica",
				"Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto",
				"Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo",
				"Macedonia del Norte", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos",
				"Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro",
				"Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda",
				"Omán", "Países Bajos", "Pakistán", "Palaos", "Palestina", "Panamá", "Papúa Nueva Guinea", "Paraguay",
				"Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa",
				"República del Congo", "República Democrática del Congo", "República Dominicana", "Ruanda", "Rumania",
				"Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía",
				"Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria",
				"Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia", "Suiza",
				"Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga",
				"Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay",
				"Uzbekistán", "Vanuatu", "Vaticano", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia",
				"Zimbabue" }));
		contentPane.add(txtNacionalidad);

		JLabel lblNombres = new JLabel("NOMBRES");
		lblNombres.setBounds(560, 108, 253, 38);
		lblNombres.setForeground(SystemColor.textInactiveText);
		lblNombres.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombres);

		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(560, 189, 255, 14);
		lblApellidos.setForeground(SystemColor.textInactiveText);
		lblApellidos.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellidos);

		JLabel lblIdentificacion = new JLabel("IDENTIFICACIÓN");
		lblIdentificacion.setBounds(560, 256, 255, 14);
		lblIdentificacion.setForeground(SystemColor.textInactiveText);
		lblIdentificacion.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblIdentificacion);

		JLabel lblNacionalidad = new JLabel("SELECCIONE SU PAIS");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);

		JLabel lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(562, 406, 253, 24);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);

		JLabel lblRegistroH = new JLabel("REGISTRO HUÉSPEDES");
		lblRegistroH.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroH.setBounds(560, 55, 338, 42);
		lblRegistroH.setForeground(new Color(12, 138, 199));
		lblRegistroH.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblRegistroH);

		JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
		lblNumeroReserva.setBounds(560, 474, 253, 24);
		lblNumeroReserva.setForeground(SystemColor.textInactiveText);
		lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNumeroReserva);

		txtIdReserva = new JTextField();
		txtIdReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtIdReserva.setBounds(560, 495, 285, 33);
		txtIdReserva.setColumns(10);
		txtIdReserva.setBackground(Color.WHITE);
		txtIdReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtIdReserva.setEditable(false);

		String id = String.valueOf(idReserva);
		txtIdReserva.setText(id);
		contentPane.add(txtIdReserva);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);

		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 315, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);

		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);

		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);

		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);

		JPanel btnGuardar = new JPanel();
		btnGuardar.setBounds(654, 549, 102, 35);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarHuespedes();
			}
		});
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(Color.GREEN);
		contentPane.add(btnGuardar);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblGuardar = new JLabel("GUARDAR");
		lblGuardar.setBackground(Color.BLACK);
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.BLACK);
		lblGuardar.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblGuardar.setBounds(0, 0, 102, 35);
		btnGuardar.add(lblGuardar);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 448, 595);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel imgRegistro = new JLabel("");
		imgRegistro.setBounds(0, 41, 441, 582);
		panel.add(imgRegistro);
		imgRegistro.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/imgRegistro.jpg")));

		JLabel logoHotel = new JLabel("");
		logoHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		logoHotel.setBounds(0, 42, 157, 139);
		panel.add(logoHotel);
		logoHotel.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/imgHotel150px.png")));

		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(560, 281, 289, 36);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
	}

	private void guardarHuespedes() {
		// Verifica que los campos esenciales no estén vacíos
		if (!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtTelefono.getText().isEmpty()) {

			// Convierte el ID de reserva (que se llena automáticamente) a entero
			int idReserva = Integer.parseInt(txtIdReserva.getText());

			// Crea un objeto Huespedes con la información proporcionada por el usuario
			Huespedes huesped = new Huespedes(idReserva, txtNombre.getText(), txtApellido.getText(),
					txtIdentificacion.getText(), txtNacionalidad.getSelectedItem().toString(), txtTelefono.getText(),
					idReserva // Puedes omitir este argumento si no es necesario
			);

			// Imprime un mensaje indicando que la operación se realizó con éxito
			System.out.println("¡Operación Realizada Exitosamente!");

			// Llama al método para guardar la información del huésped
			this.controlHuesped.guardar(huesped);

			// Muestra un mensaje de éxito
			Exito exito = new Exito();
			exito.setVisible(true);
			dispose();
		} else {
			// Muestra un mensaje indicando al usuario que complete todos los campos
			JOptionPane.showMessageDialog(this, "Por favor diligencie todos los campos");
		}
	}

	// Código que permite mover la ventana por la pantalla según la posición de "x"
	// y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

}
