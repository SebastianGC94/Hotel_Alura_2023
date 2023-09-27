package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.conexionBase;

public class Huespedes {

	private Integer id;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String nacionalidad;
	private String telefono;
	private Integer idReserva;

	public Huespedes(Integer id, String nombre, String apellido, String identificacion, String nacionalidad,
			String telefono, Integer idReserva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public static boolean validarHuesped(String nombre, String apellido, String identificacion, String nacionalidad,
			String telefono) {
		conexionBase conexion = new conexionBase();
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connection = conexion.recuperarConexion();
			state = connection.prepareStatement(
					"SELECT * FROM huespedes WHERE nombre = ? AND apellido = ? identificacion = ? AND nacionalidad = ? telefono = ? ");
			state.setString(1, nombre);
			state.setString(2, apellido);
			state.setString(3, identificacion);
			state.setString(4, nacionalidad);
			state.setString(5, telefono);
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