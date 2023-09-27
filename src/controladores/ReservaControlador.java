package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import CRUD.ReservaCrud;
import factory.conexionBase;
import modelo.Reservas;

public class ReservaControlador {
	private ReservaCrud reservas;
	
	public ReservaControlador() {
		Connection con = new conexionBase().recuperarConexion();
		this.reservas = new ReservaCrud(con);	
	}
	
	public void guardar (Reservas res) {
		this.reservas.guardar(res);
	}
	
	public List<Reservas> buscar(){
		return this.reservas.buscar();
	}
	public List<Reservas> buscarId(String id){
		return this.reservas.buscarId(id);
	}
		
	public void actualizar(Date fechaEntrada, Date fechaSalida, double valor, String formaPago, Integer id) {
		this.reservas.Actualizar(fechaEntrada, fechaSalida, valor, formaPago, id);
	}
	
	public void Eliminar(Integer id) {
		this.reservas.Eliminar(id);
	}
}
