package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.conexionBase;

public class Usuarios {
	private Integer id;
	private String nombre;
	private String contrasena;

	public Usuarios(Integer id, String nombre, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static boolean validarUsuario(String nombre, String contrasena) {
		conexionBase conexion = new conexionBase();
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connection = conexion.recuperarConexion();
			state = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?");
			state.setString(1, nombre);
			state.setString(2, contrasena);
			result = state.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (result != null)
					result.close();
				if (state != null)
					state.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
