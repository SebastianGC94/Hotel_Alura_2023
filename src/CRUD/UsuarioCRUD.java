package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuarios;

public class UsuarioCRUD {

	private Connection conexion;

	public UsuarioCRUD(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Usuarios usuario) {
		try {
			String sql = "INSERT INTO usuarios (nombre,contrasena) VALUES(?,?)";
			try (PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, usuario.getNombre());
				pstm.setString(2, usuario.getContrasena());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						usuario.setId(rst.getInt(1));
					}
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuarios> buscar() {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		try {
			String sql = "SELECT id, nombre , contrasena FROM usuarios";

			try (PreparedStatement pstm = conexion.prepareStatement(sql)) {

				pstm.execute();

				transFormarResultSetEnReserva(usuarios, pstm);
			}
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuarios> buscarId(Integer id) {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		try {
			String sql = "SELECT id, nombre FROM usuarios WHERE id=?";

			try (PreparedStatement pstm = conexion.prepareStatement(sql)) {
				pstm.setInt(1, id);
				pstm.execute();

				transFormarResultSetEnReserva(usuarios, pstm);
			}
			return usuarios;
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

	public void Actualizar(String nombre, String contrasena) {
		try (PreparedStatement stm = conexion
				.prepareStatement("UPDATE huespedes SET id=?, nombre=? , contrasena=? WHERE  id= ?")) {

			stm.setString(1, nombre);
			stm.setString(2, contrasena);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transFormarResultSetEnReserva(List<Usuarios> usuarios, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Usuarios producto = new Usuarios(rst.getInt(1), rst.getString(2), rst.getString(3));
				usuarios.add(producto);
			}
		}
	}

}
