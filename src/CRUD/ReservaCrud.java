package CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reservas;

public class ReservaCrud {
	private Connection conexion;

	public ReservaCrud(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Reservas reserva) {
		String sql = "INSERT INTO reservas (fecha_entrada,fecha_salida,valor,forma_pago)" + "VALUES(?,?,?,?)";
		try (PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setDate(1, reserva.getFechaEntrada());
			pstm.setDate(2, reserva.getFechaSalida());
			pstm.setDouble(3, reserva.getValor());
			pstm.setString(4, reserva.getFormaPago());

			pstm.executeUpdate();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> buscar() {
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor,forma_pago FROM reservas";

			try (PreparedStatement pstm = conexion.prepareStatement(sql)) {
				pstm.execute();

				transFormarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> buscarId(String id) {
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor,forma_pago FROM reservas WHERE  id= ?";

			try (PreparedStatement pstm = conexion.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transFormarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Eliminar(Integer id) {
		try (PreparedStatement stm = conexion.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Actualizar(Date fechaEntrada, Date fechaSalida, double valor, String formaPago, Integer id) {
		try (PreparedStatement stm = conexion.prepareStatement(
				"UPDATE reservas SET fecha_entrada=?, fecha_salida=?, valor=?,forma_pago=? WHERE  id= ?")) {
			stm.setDate(1, fechaEntrada);
			stm.setDate(2, fechaSalida);
			stm.setDouble(3, valor);
			stm.setString(4, formaPago);
			stm.setInt(5, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transFormarResultSetEnReserva(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reservas producto = new Reservas(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getDouble(4),
						rst.getString(5));
				reservas.add(producto);
			}
		}
	}

}
