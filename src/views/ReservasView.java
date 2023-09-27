package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controladores.ReservaControlador;
import modelo.Reservas;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValorReserva;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<Format> txtFormaPago;
	int xMouse, yMouse;
	private JLabel lblSignoPeso;
	private JLabel lblVolver;

	private ReservaControlador reservasCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
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
	public ReservasView() {
		super("reserva");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ReservasView.class.getResource("/imagenes/iconoReservar240px.png")));
		setTitle("");
		this.reservasCon = new ReservaControlador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(false);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 900, 521);
		contentPane.add(panel);
		panel.setLayout(null);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);

		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton()
				.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/iconoLlegada30px.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtFechaEntrada);

		lblSignoPeso = new JLabel("$");
		lblSignoPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignoPeso.setVisible(true);
		lblSignoPeso.setBounds(326, 336, 31, 25);
		lblSignoPeso.setForeground(Color.BLACK);
		lblSignoPeso.setFont(new Font("Roboto", Font.BOLD, 17));

		panel.add(lblSignoPeso);

		JLabel lblLlegada = new JLabel("FECHA DE CHECK IN");
		lblLlegada.setHorizontalAlignment(SwingConstants.CENTER);
		lblLlegada.setForeground(Color.BLACK);
		lblLlegada.setBounds(68, 136, 289, 14);
		lblLlegada.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblLlegada);

		JLabel lblSalida = new JLabel("FECHA DE CHECK OUT");
		lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida.setForeground(Color.BLACK);
		lblSalida.setBounds(68, 221, 289, 14);
		lblSalida.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblSalida);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton()
				.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/iconoSalida30px.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(txtFechaEntrada, txtFechaSalida);
			}
		});
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);

		JLabel lblValorReserva = new JLabel("COSTO DE LA RESERVACIÓN");
		lblValorReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorReserva.setForeground(Color.BLACK);
		lblValorReserva.setBounds(72, 303, 285, 18);
		lblValorReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValorReserva);

		txtValorReserva = new JTextField();
		txtValorReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtValorReserva.setBackground(SystemColor.text);
		txtValorReserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorReserva.setForeground(Color.BLACK);
		txtValorReserva.setBounds(68, 328, 230, 33);
		txtValorReserva.setEditable(false);
		txtValorReserva.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValorReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtValorReserva.setColumns(10);
		panel.add(txtValorReserva);

		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new CompoundBorder());
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago
				.setModel(new DefaultComboBoxModel(new String[] { "Tarjeta Crédito", "Tarjeta Débito", "Efectivo" }));
		panel.add(txtFormaPago);

		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setHorizontalAlignment(SwingConstants.LEFT);
		lblFormaPago.setForeground(Color.BLACK);
		lblFormaPago.setBounds(68, 382, 289, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);

		JLabel lblTitulo = new JLabel("NUEVO REGISTRO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 60, 429, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 35, 462, 525);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel imgCalendario = new JLabel("");
		imgCalendario.setHorizontalAlignment(SwingConstants.CENTER);
		imgCalendario.setBounds(0, 0, 457, 485);
		panel_1.add(imgCalendario);
		imgCalendario.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/iconoReserva.png")));

		JPanel header = new JPanel();
		header.setBounds(0, 0, 890, 36);
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

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);

		JPanel btnSiguiente = new JPanel();
		btnSiguiente.setForeground(Color.CYAN);
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {

					guardarReserva();
				} else {
					JOptionPane.showMessageDialog(null, "Campos sin diligenciar");
				}
			}
		});
		btnSiguiente.setLayout(null);
		btnSiguiente.setBackground(Color.GREEN);
		btnSiguiente.setBounds(159, 475, 122, 35);
		panel.add(btnSiguiente);
		btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setBackground(Color.BLACK);
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.BLACK);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);
		btnSiguiente.add(lblSiguiente);
	}

	public void guardarReserva() {
		try {
			String fechaEntrada = ((JTextField) txtFechaEntrada.getDateEditor().getUiComponent()).getText();
			String fechaSalida = ((JTextField) txtFechaSalida.getDateEditor().getUiComponent()).getText();
			// Acá se castea el campo que está en String (valor) para que pueda mostrarse en
			// double
			double valor = Double.parseDouble(txtValorReserva.getText());

			Reservas res = new Reservas(java.sql.Date.valueOf(fechaEntrada), java.sql.Date.valueOf(fechaSalida), valor,
					txtFormaPago.getSelectedItem().toString());
			reservasCon.guardar(res);

			RegistroHuesped registro = new RegistroHuesped(res.getId());
			registro.setVisible(true);
			dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Error:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void calcularValor(JDateChooser fechaEntrada, JDateChooser fechaSalida) {
		if (fechaEntrada.getDate() != null && fechaSalida.getDate() != null) {
			if ((fechaEntrada.getDate().after(fechaSalida.getDate()))) {
				JOptionPane.showMessageDialog(null, "La fecha de llegada no puede ser posterior a la fecha de salida");

			}
			Calendar inicio = fechaEntrada.getCalendar();
			Calendar fin = fechaSalida.getCalendar();

			int dias = -1; // Contar desde el día siguiente
			int noche = 50000; // costo por día calendario
			double valor;

			while (inicio.before(fin) || inicio.equals(fin)) {
				dias++;
				inicio.add(Calendar.DATE, 1);
			}
			valor = dias * noche;
			// acá se castea el valor string del campo gráfico para poder mostrar el double
			// del campo txtValor
			txtValorReserva.setText(String.valueOf(valor));
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
