package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Huespedes;

public class HuespedCRUD {

	private Connection conexion;

	public HuespedCRUD(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Huespedes huesped) {
		try {
			String sql = "INSERT INTO huespedes (nombre,apellido,identificacion,nacionalidad,telefono,id_reserva) VALUES(?,?,?,?,?,?)";
			try (PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, huesped.getNombre());
				pstm.setString(2, huesped.getApellido());
				pstm.setString(3, huesped.getIdentificacion());
				pstm.setString(4, huesped.getNacionalidad());
				pstm.setString(5, huesped.getTelefono());
				pstm.setInt(6, huesped.getIdReserva());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						huesped.setId(rst.getInt(1));
					}
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> buscar() {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre , apellido, identificacion, nacionalidad,telefono, id_reserva FROM huespedes";

			try (PreparedStatement pstm = conexion.prepareStatement(sql)) {

				pstm.execute();

				transFormarResultSetEnReserva(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> buscarId(String id) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre , apellido, identificacion,nacionalidad, telefono, id_reserva FROM huespedes WHERE id_reserva=?";

			try (PreparedStatement pstm = conexion.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transFormarResultSetEnReserva(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Eliminar(Integer id) {
		try (PreparedStatement stm = conexion.prepareStatement("DELETE FROM huespedes WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void actualizar(String nombre, String apellido, String identificacion, String nacionalidad, String telefono,
			Integer id_reserva, Integer id) {
		try (PreparedStatement stm = conexion.prepareStatement(
				"UPDATE huespedes SET nombre=? , apellido=?, identificacion=?, nacionalidad=?, telefono=?, id_reserva=? WHERE  id= ?")) {

			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setString(3, identificacion);
			stm.setString(4, nacionalidad);
			stm.setString(5, telefono);
			stm.setInt(6, id_reserva);
			stm.setInt(7, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transFormarResultSetEnReserva(List<Huespedes> huespedes, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Huespedes producto = new Huespedes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getInt(7));
				huespedes.add(producto);
			}
		}
	}

}
