package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import controladores.ReservaControlador;
import controladores.UsuarioControlador;
import modelo.Usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class RegistroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JLabel lblVolver;
	int xMouse, yMouse;

	private UsuarioControlador controlUsuario;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario frame = new RegistroUsuario();
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
	public RegistroUsuario() {
		new ReservaControlador();
		this.controlUsuario = new UsuarioControlador();

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(RegistroUsuario.class.getResource("/imagenes/iconoUsuario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 634);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(false);
		contentPane.setLayout(null);

		JPanel header = new JPanel();
		header.setForeground(Color.WHITE);
		header.setBounds(0, 0, 885, 36);
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
				Login login = new Login();
				login.setVisible(true);
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

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombreUsuario.setBounds(570, 374, 275, 33);
		txtNombreUsuario.setBackground(Color.WHITE);
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(txtNombreUsuario);

		JLabel lblNombreUsuario = new JLabel("NOMBRE DE USUARIO");
		lblNombreUsuario.setBounds(570, 349, 255, 14);
		lblNombreUsuario.setForeground(Color.BLACK);
		lblNombreUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombreUsuario);

		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setBounds(570, 431, 255, 24);
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblContrasena);

		JLabel lblRegistroU = new JLabel("REGISTRO USUARIOS");
		lblRegistroU.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroU.setBounds(534, 47, 340, 42);
		lblRegistroU.setForeground(new Color(12, 138, 199));
		lblRegistroU.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblRegistroU);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(570, 418, 275, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);

		JPanel btnGuardar = new JPanel();
		btnGuardar.setBounds(649, 538, 122, 35);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarUsuario();
			}
		});
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(Color.GREEN);
		contentPane.add(btnGuardar);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblGuardar = new JLabel("CREAR");
		lblGuardar.setBounds(0, 0, 122, 35);
		btnGuardar.add(lblGuardar);
		lblGuardar.setBackground(Color.BLACK);
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.BLACK);
		lblGuardar.setFont(new Font("Arial Black", Font.BOLD, 12));

		JPanel panel = new JPanel();
		panel.setBounds(0, 35, 489, 560);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel imgRegistro = new JLabel("");
		imgRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		imgRegistro.setBackground(Color.WHITE);
		imgRegistro.setBounds(0, 138, 479, 411);
		panel.add(imgRegistro);
		imgRegistro.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/imgLogin.png")));

		JLabel logoHotel = new JLabel("");
		logoHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		logoHotel.setBounds(0, 42, 157, 139);
		panel.add(logoHotel);
		logoHotel.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/imgHotel150px.png")));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(570, 89, 275, 232);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/iconoCrear240px.png")));
		lblNewLabel.setBounds(10, 0, 240, 222);
		panel_1.add(lblNewLabel);

		JLabel txtContrasenalbl = new JLabel("");
		txtContrasenalbl.setBounds(570, 466, 275, 31);
		contentPane.add(txtContrasenalbl);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(570, 466, 275, 31);
		contentPane.add(txtContrasena);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		separator_1_2_1.setBounds(570, 508, 275, 2);
		contentPane.add(separator_1_2_1);
	}

	@SuppressWarnings({})
	private void guardarUsuario() {
		char[] contrasenaChar = txtContrasena.getPassword();
		String contrasena = new String(contrasenaChar);
		String nombre = txtNombreUsuario.getText();

		if (contrasena.length() > 0 && !nombre.isEmpty()) {

			Usuarios usuario = new Usuarios(xMouse, nombre, contrasena);
			System.out.println("¡Operación Realizada Exitosamente!");
			this.controlUsuario.guardar(usuario);

			Exito exito = new Exito();
			exito.setVisible(true);
			dispose();
		} else {
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

	public void registrarme() {
		RegistroUsuario registroUsuario = new RegistroUsuario(); // Puedes pasar el idReserva que necesites
		registroUsuario.setVisible(true);
	}
}
