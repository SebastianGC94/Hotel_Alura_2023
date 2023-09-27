package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.LoginControlador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import controladores.UsuarioControlador;
import java.awt.Toolkit;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	static int xMouse;
	int yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/iconoUsuario.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 778, 527);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(416, 0, 333, 467);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel imgLoginUsuario = new JLabel("");
		imgLoginUsuario.setBackground(Color.CYAN);
		imgLoginUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		imgLoginUsuario.setBounds(-15, 38, 367, 478);
		panel_1.add(imgLoginUsuario);
		imgLoginUsuario.setIcon(new ImageIcon(Login.class.getResource("/imagenes/imgUsuarioLogin.png")));

		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsuario.getText().equals("Ingrese su usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsuario.getText().isEmpty()) {
					txtUsuario.setForeground(Color.GRAY);
					txtUsuario.setText("Ingrese su nombre de usuario");
				}
			}
		});
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				}

			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(65, 292, 324, 2);
		panel.add(separator);

		JLabel lblInicioSesion = new JLabel("INICIAR SESIÓN");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicioSesion.setForeground(new Color(0, 0, 128));
		lblInicioSesion.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblInicioSesion.setBounds(65, 135, 267, 26);
		panel.add(lblInicioSesion);

		JSeparator separator2 = new JSeparator();
		separator2.setBackground(SystemColor.textHighlight);
		separator2.setBounds(65, 393, 324, 2);
		panel.add(separator2);

		txtContrasena = new JPasswordField();
		txtContrasena.setText("*****");
		txtContrasena.addMouseListener(new MouseAdapter() {

			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtContrasena.getPassword()).equals("*****")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
				}
				if (txtContrasena.getText().isEmpty()) {
					txtContrasena.setText("Ingrese su nombre de usuario");
					txtContrasena.setForeground(Color.gray);
				}
			}
		});
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(65, 353, 324, 32);
		panel.add(txtContrasena);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblUsuario.setBounds(65, 219, 107, 26);
		panel.add(lblUsuario);

		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setForeground(new Color(0, 0, 0));
		lblContrasena.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasena.setBounds(65, 316, 140, 26);
		panel.add(lblContrasena);

		JButton btnLogin = new JButton();
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new LoginControlador(this));
		btnLogin.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Login();
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(65, 431, 123, 36);
		panel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblLogin = new JLabel("Entrar");
		lblLogin.setBackground(Color.GREEN);
		lblLogin.setBounds(0, 0, 122, 44);
		btnLogin.add(lblLogin);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Sitka Text", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/imgHotel100px.png")));
		lblNewLabel_1.setBounds(10, 47, 140, 77);
		panel.add(lblNewLabel_1);

		JPanel header = new JPanel();
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
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 778, 36);
		panel.add(header);
		header.setLayout(null);

		JLabel lblNoSesion = new JLabel("Soy nuevo en esto...");
		lblNoSesion.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblNoSesion.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoSesion.setBounds(253, 418, 153, 14);
		panel.add(lblNoSesion);

		UsuarioControlador usuarioControlador = new UsuarioControlador();

		JButton btnRegistrarme = new JButton();

		btnRegistrarme.addActionListener(e -> {
			// Crear una instancia de la ventana de registro
			RegistroUsuario registroUsuario = new RegistroUsuario();

			// Hacer visible la ventana de registro
			registroUsuario.setVisible(true);

			// Cerrar la ventana de login si es necesario
			this.dispose();
		});

		btnRegistrarme.addActionListener(e -> usuarioControlador.registrarUsuario());
		btnRegistrarme.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrarme.setBackground(new Color(0, 156, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrarme.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnRegistrarme.setBackground(Color.WHITE);
		btnRegistrarme.setBounds(65, 431, 123, 36);
		panel.add(btnRegistrarme);
		btnRegistrarme.setLayout(null);
		btnRegistrarme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblRegistrarme = new JLabel("REGISTRARME");
		lblRegistrarme.setBounds(243, 435, 123, 32);
		lblRegistrarme.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarme.setForeground(Color.BLUE);
		lblRegistrarme.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblRegistrarme.setBackground(Color.white);
		panel.add(lblRegistrarme);

		btnRegistrarme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarme.setBounds(243, 435, 123, 32);
		panel.add(btnRegistrarme);

	}

	private void Login() {

	}

	public void RegistroUsuario() {

		RegistroUsuario registroUsuario = new RegistroUsuario();
		registroUsuario.setVisible(true);
		this.dispose();
	}

	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	public String getNombre() {

		return txtUsuario.getText();
	}

	public String getContrasena() {
		return new String(txtContrasena.getPassword());
	}
}
