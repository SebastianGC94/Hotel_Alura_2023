package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel lblReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/iconoMenu240px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(false);

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

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 37, 257, 533);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel imgHotel = new JLabel("");
		imgHotel.setHorizontalAlignment(SwingConstants.CENTER);
		imgHotel.setBounds(10, 11, 237, 197);
		panelMenu.add(imgHotel);
		imgHotel.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/imgHotel200px.png")));

		JPanel btnReserva = new JPanel();
		btnReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReserva.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnReserva.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnReserva.setBounds(10, 255, 237, 56);
		btnReserva.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnReserva);
		btnReserva.setLayout(null);

		lblReserva = new JLabel("Reservar");
		lblReserva.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/iconoReservar20px.png")));
		lblReserva.setForeground(SystemColor.text);
		lblReserva.setBounds(25, 11, 205, 34);
		lblReserva.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblReserva.setHorizontalAlignment(SwingConstants.LEFT);
		btnReserva.add(lblReserva);

		JPanel btnBusqueda = new JPanel();
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setBounds(10, 312, 237, 56);
		btnBusqueda.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);

		JLabel lblBusqueda = new JLabel("Buscar");
		lblBusqueda.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/iconoBuscarU20px.png")));
		lblBusqueda.setBounds(27, 11, 200, 34);
		lblBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusqueda.setForeground(Color.WHITE);
		lblBusqueda.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBusqueda.add(lblBusqueda);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);

		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(12, 138, 199));
		panelFecha.setBounds(256, 37, 662, 121);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);

		JLabel lblTituloMenu = new JLabel("MENÚ DE USUARIO");
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 30, 662, 42);
		panelFecha.add(lblTituloMenu);
		lblTituloMenu.setForeground(Color.BLACK);
		lblTituloMenu.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel lblFecha = new JLabel("New label");
		lblFecha.setBounds(10, 74, 129, 36);
		panelFecha.add(lblFecha);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 15));
		Date fechaActual = new Date(); // fecha y hora actual
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); // formatear la fecha en una cadena
		lblFecha.setText("Hoy es " + fecha); // setear la representacion en cadena de la fecha

		JLabel lblBienvenido = new JLabel("¡Bienvenido!");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 29));
		lblBienvenido.setBounds(256, 208, 662, 46);
		contentPane.add(lblBienvenido);

		JLabel lblDescripcion = new JLabel(
				"<html><body>Gestione y visualice de forma sencilla la información correspondiente a los húespedes y sus reservaciones.</body></html>");
		lblDescripcion.setFont(new Font("Roboto", Font.PLAIN, 17));

		lblDescripcion.setBounds(312, 265, 598, 66);
		contentPane.add(lblDescripcion);

		JLabel lblDescripcion2 = new JLabel(
				"<html><body> Esta herramienta le permitirá realizar tareas específicas como:</body></html>");
		lblDescripcion2.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblDescripcion2.setBounds(312, 328, 569, 66);
		contentPane.add(lblDescripcion2);

		JLabel lblItem1 = new JLabel("- Crear usuarios.");
		lblItem1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblItem1.setBounds(312, 405, 373, 27);
		contentPane.add(lblItem1);

		JLabel lblItem2 = new JLabel("- Visualizar detalles de los registros de reservas y húespedes.");
		lblItem2.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblItem2.setBounds(312, 481, 542, 27);
		contentPane.add(lblItem2);

		JLabel lblItem3 = new JLabel("- Editar y eliminar registros.");
		lblItem3.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblItem3.setBounds(312, 519, 295, 27);
		contentPane.add(lblItem3);

		JLabel lblRegistrarReservas = new JLabel("- Registrar reservas.");
		lblRegistrarReservas.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRegistrarReservas.setBounds(312, 443, 373, 27);
		contentPane.add(lblRegistrarReservas);
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
}
