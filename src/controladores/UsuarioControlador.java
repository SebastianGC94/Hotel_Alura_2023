package controladores;

import java.sql.Connection;
import java.util.List;

import CRUD.UsuarioCRUD;
import factory.conexionBase;
import modelo.Usuarios;
import views.RegistroUsuario;

public class UsuarioControlador {
	private UsuarioCRUD usuarioCrud;

	public UsuarioControlador() {
		Connection connection = new conexionBase().recuperarConexion();
		this.usuarioCrud = new UsuarioCRUD(connection);
	}

	public void guardar(Usuarios usuario) {
		this.usuarioCrud.guardar(usuario);
	}

	public List<Usuarios> buscarUsuarios() {
		return this.usuarioCrud.buscar();
	}

	public List<Usuarios> buscarUsuariosId(Integer id) {
		return this.usuarioCrud.buscarId(id);
	}

	public void actualizar(String nombre, String contrasena) {
		this.usuarioCrud.Actualizar(nombre, contrasena);
	}

	public void Eliminar(Integer id) {
		this.usuarioCrud.Eliminar(id);
	}

	public Object registrarUsuario() {

			RegistroUsuario registro = new RegistroUsuario();
			registro.setVisible(true);
			registro.dispose();
			return registro;
		}

	 public void crearNuevo() {
	        // Lógica para registrar un usuario
	    }
	
}
