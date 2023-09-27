package controladores;

import java.sql.Connection;
import java.util.List;

import CRUD.HuespedCRUD;
import factory.conexionBase;
import modelo.Huespedes;

public class HuespedControlador{
	private HuespedCRUD huespedCrud;
	
	
	public HuespedControlador() {
		Connection connection = new conexionBase().recuperarConexion();
		this.huespedCrud = new HuespedCRUD(connection);
	}
	
	
	public void guardar(Huespedes huesped) {
		this.huespedCrud.guardar(huesped);
	}
	
	public  List<Huespedes> buscarHuespedes(){
		return this.huespedCrud.buscar();
	}
	
	public  List<Huespedes> buscarHuespedesId(String id){
		return this.huespedCrud.buscarId(id);
	}
	
	public void actualizar(String nombre, String apellido, String identificacion, String nacionalidad, String telefono,Integer id_reserva, Integer id) {
		this.huespedCrud.actualizar(nombre, apellido, identificacion, nacionalidad, telefono,id_reserva, id);
	}
	 
	public void Eliminar(Integer id) {
		this.huespedCrud.Eliminar(id);
	}
}
	
