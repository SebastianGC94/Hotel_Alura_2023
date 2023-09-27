package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/iconoPlay040px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(false);

		Panel panel = new Panel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 900, 537);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel imgMenu = new JLabel("");
		imgMenu.setBounds(-50, 0, 732, 501);
		imgMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/imgMenu500px.png")));
		panel.add(imgMenu);

		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(692, 47, 198, 189);
		imgLogo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/imgHotel200px.png")));
		panel.add(imgLogo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 910, 37);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAutor = new JLabel("Desarrollado por Sebastián GC  ©  2023");
		lblAutor.setBackground(Color.BLACK);
		lblAutor.setBounds(10, 11, 549, 19);
		lblAutor.setForeground(Color.BLACK);
		lblAutor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		panel_1.add(lblAutor);

		// Barra para controlar la ventana
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		header.setBackground(Color.WHITE);
		panel.add(header);

		// Botón Login
		JPanel btnEmpezar = new JPanel();
		btnEmpezar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEmpezar.setBounds(692, 359, 198, 73);
		btnEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnEmpezar.setLayout(null);
		btnEmpezar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEmpezar.setBackground(Color.WHITE);
		panel.add(btnEmpezar);

		JLabel imgEmpezar = new JLabel("");
		imgEmpezar.setBounds(0, 0, 198, 70);
		btnEmpezar.add(imgEmpezar);
		imgEmpezar.setHorizontalAlignment(SwingConstants.CENTER);
		imgEmpezar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/iconoEntrar50px.png")));

		JLabel lblEstoyListo = new JLabel("¡Estoy Listo!");
		lblEstoyListo.setBounds(692, 324, 198, 24);
		lblEstoyListo.setBackground(SystemColor.window);
		panel.add(lblEstoyListo);
		lblEstoyListo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoyListo.setForeground(Color.BLACK);
		lblEstoyListo.setFont(new Font("Roboto Light", Font.BOLD, 20));
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
