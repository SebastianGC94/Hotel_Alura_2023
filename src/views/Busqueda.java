package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.ReservaControlador;
import controladores.HuespedControlador;
import modelo.Reservas;
import modelo.Huespedes;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Optional;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tblHuespedes;
	private JTable tblReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private JLabel lblVolver;
	int xMouse, yMouse;

	private ReservaControlador reservasControl;
	private HuespedControlador huespedesControl;

	String reserva;
	String huespedes;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		reservasControl = new ReservaControlador();
		huespedesControl = new HuespedControlador();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/iconoBuscar.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setUndecorated(false);
		new JScrollPane(tblReservas);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(462, 127, 267, 31);
		txtBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblBusqueda = new JLabel("MENÚ BUSCAR");
		lblBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusqueda.setForeground(new Color(0, 0, 0));
		lblBusqueda.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblBusqueda.setBounds(20, 62, 865, 42);
		contentPane.add(lblBusqueda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 169, 865, 261);
		contentPane.add(scrollPane);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));

		tblReservas = new JTable();
		tblReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblReservas.setBackground(Color.WHITE);
		tblReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/iconoReserva20px.png")),
				tblReservas, null);

		modelo = (DefaultTableModel) tblReservas.getModel();
		modelo.addColumn("Número de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Costo");
		modelo.addColumn("Forma de Pago");
		mostrarTablaReservas();

		tblHuespedes = new JTable();
		tblHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/iconoUsuario20px.png")),
				tblHuespedes, null);

		modeloH = (DefaultTableModel) tblHuespedes.getModel();
		modeloH.addColumn("Huésped Id");
		modeloH.addColumn("Nombres");
		modeloH.addColumn("Apellidos");
		modeloH.addColumn("Identificación");
		modeloH.addColumn("País");
		modeloH.addColumn("Teléfono");
		modeloH.addColumn("Número de Reserva");
		mostrarTablaHuespedes();

		JPanel header = new JPanel();
		header.setForeground(new Color(255, 255, 255));
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
		header.setBackground(new Color(255, 255, 255));
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

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				eliminarTabla();

				if (txtBuscar.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un número");
					mostrarTablaHuespedes();
					mostrarTablaReservas();
				} else {

					mostrarTablaHuespedesId();
					mostrarTablaReservasId();
				}
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(0, 0, 0));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBackground(new Color(255, 255, 255));
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tblReservas.getSelectedRow();
				int filaHuespedes = tblHuespedes.getSelectedRow();

				if (filaReservas >= 0) {
					actualizarReserva();
					eliminarTabla();
					mostrarTablaHuespedes();
					mostrarTablaReservas();
				} else if (filaHuespedes >= 0) {
					actualizarHuesped();
					eliminarTabla();
					mostrarTablaHuespedes();
					mostrarTablaReservas();
				}
			}
		});

		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(0, 255, 255));
		btnEditar.setBounds(627, 451, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tblReservas.getSelectedRow();
				int filaHuespedes = tblHuespedes.getSelectedRow();

				if (filaReservas >= 0) {
					reserva = tblReservas.getValueAt(filaReservas, 0).toString();
					int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la reserva?");

					if (confirmar == JOptionPane.YES_OPTION) {
						String valor = tblReservas.getValueAt(filaReservas, 0).toString();
						reservasControl.Eliminar(Integer.valueOf(valor));
						JOptionPane.showMessageDialog(contentPane, "Reserva eliminada satisfactoriamente");
						eliminarTabla();

						mostrarTablaHuespedes();
						mostrarTablaReservas();
					}

				} else if (filaHuespedes >= 0) {

					huespedes = tblHuespedes.getValueAt(filaHuespedes, 0).toString();
					int confirmaH = JOptionPane.showConfirmDialog(null,
							"¿Está seguro de eliminar el registro del húesped?");

					if (confirmaH == JOptionPane.YES_OPTION) {
						String valor = tblHuespedes.getValueAt(filaHuespedes, 0).toString();
						huespedesControl.Eliminar(Integer.valueOf(valor));
						JOptionPane.showMessageDialog(contentPane, "Registro eliminado");
						eliminarTabla();
						mostrarTablaHuespedes();
						mostrarTablaReservas();
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado un elemento");
				}
			}
		});

		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(759, 451, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private List<Reservas> BuscarReservas() {
		return this.reservasControl.buscar();
	}

	private List<Reservas> BuscarReservasId() {
		return this.reservasControl.buscarId(txtBuscar.getText());
	}

	private List<Huespedes> BuscarHuespedes() {
		return this.huespedesControl.buscarHuespedes();
	}

	private List<Huespedes> BuscarHuespedesId() {
		return this.huespedesControl.buscarHuespedesId(txtBuscar.getText());
	}

	private void eliminarTabla() {
		((DefaultTableModel) tblHuespedes.getModel()).setRowCount(0);
		((DefaultTableModel) tblReservas.getModel()).setRowCount(0);
	}

	// fun
	private void mostrarTablaReservas() {
		List<Reservas> reserva = BuscarReservas();
		try {
			for (Reservas res : reserva) {
				modelo.addRow(new Object[] { res.getId(), res.getFechaEntrada(), res.getFechaSalida(), res.getValor(),
						res.getFormaPago() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarTablaReservasId() {
		List<Reservas> reserva = BuscarReservasId();
		try {
			for (Reservas res : reserva) {
				modelo.addRow(new Object[] { res.getId(), res.getFechaEntrada(), res.getFechaSalida(), res.getValor(),
						res.getFormaPago() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarTablaHuespedes() {
		List<Huespedes> huespedes = BuscarHuespedes();

		try {
			for (Huespedes huespedes1 : huespedes) {
				modeloH.addRow(new Object[] { huespedes1.getId(), huespedes1.getNombre(), huespedes1.getApellido(),
						huespedes1.getIdentificacion(), huespedes1.getNacionalidad(), huespedes1.getTelefono(),
						huespedes1.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarTablaHuespedesId() {
		List<Huespedes> huespedes = BuscarHuespedesId();

		try {
			for (Huespedes huespedes1 : huespedes) {
				modeloH.addRow(new Object[] { huespedes1.getId(), huespedes1.getNombre(), huespedes1.getApellido(),
						huespedes1.getIdentificacion(), huespedes1.getNacionalidad(), huespedes1.getTelefono(),
						huespedes1.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void actualizarReserva() {
		Optional.ofNullable(modelo.getValueAt(tblReservas.getSelectedRow(), tblReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Date fechaEntrada = Date.valueOf(modelo.getValueAt(tblReservas.getSelectedRow(), 1).toString());
					Date fechaSalida = Date.valueOf(modelo.getValueAt(tblReservas.getSelectedRow(), 2).toString());
					double valor = (Double) modelo.getValueAt(tblReservas.getSelectedRow(), 3);
					String formaPago = (String) modelo.getValueAt(tblReservas.getSelectedRow(), 4);
					Integer id = Integer.valueOf(modelo.getValueAt(tblReservas.getSelectedRow(), 0).toString());
					this.reservasControl.actualizar(fechaEntrada, fechaSalida, valor, formaPago, id);
					JOptionPane.showMessageDialog(this, String.format("Registro modificado exitosamente"));

				}, () -> JOptionPane.showMessageDialog(this, "Por favor intente nuevamente"));
	}

	private void actualizarHuesped() {
		Optional.ofNullable(modeloH.getValueAt(tblHuespedes.getSelectedRow(), tblHuespedes.getSelectedColumn()))
				.ifPresentOrElse(filaHuespedes -> {

					String nombre = (String) modeloH.getValueAt(tblHuespedes.getSelectedRow(), 1);
					String apellido = (String) modeloH.getValueAt(tblHuespedes.getSelectedRow(), 2);
					String identificacion = (String) modeloH.getValueAt(tblHuespedes.getSelectedRow(), 3);
					String nacionalidad = (String) modeloH.getValueAt(tblHuespedes.getSelectedRow(), 4);
					String telefono = (String) modeloH.getValueAt(tblHuespedes.getSelectedRow(), 5);
					Integer id_reserva = Integer
							.valueOf(modeloH.getValueAt(tblHuespedes.getSelectedRow(), 6).toString());
					Integer id = Integer.valueOf(modeloH.getValueAt(tblHuespedes.getSelectedRow(), 0).toString());

					this.huespedesControl.actualizar(nombre, apellido, identificacion, nacionalidad, telefono,
							id_reserva, id);
					JOptionPane.showMessageDialog(this, String.format("Registro modificado exitosamente"));

				}, () -> JOptionPane.showMessageDialog(this, "Por favor intente nuevamente"));

	}

}
