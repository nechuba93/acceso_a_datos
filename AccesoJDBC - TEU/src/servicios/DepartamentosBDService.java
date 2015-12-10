package servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.DatabaseDAOInterface;
import utilidades.Departamento;

public class DepartamentosBDService implements DepartamentosServiceInterface{

	private DatabaseDAOInterface daoInterface;
	
	public DepartamentosBDService(DatabaseDAOInterface dao){
		this.daoInterface = dao;
	}
	
	public Departamento obtenerDepartamento(int numdep){
		return daoInterface.obtenerDepartamento(numdep);
	}
	
	public ArrayList<Departamento> obtenerDepartamentos (){
		return daoInterface.obtenerDepartamentos();
	}
	
	public void mostrarDepartamento(int numdep){
		daoInterface.mostrarDepartamento(numdep);
	}
	
	public void mostrarDepartamentos(){
		daoInterface.mostrarDepartamentos();
	}
	
	public void insertarDepartamento(Departamento dep) throws SQLException {
		daoInterface.insertarDepartamento(dep);
	}
	
	public void insertarDepartamentos(ArrayList<Departamento> departamentos) throws SQLException{
		daoInterface.insertarDepartamentos(departamentos);
	}
	
	public void borrarDepartamento(int numdep){
		daoInterface.borrarDepartamento(numdep);
	}
	
	public void actualizarDepartamento(int numdep, Departamento dep){
		daoInterface.actualizarDepartamento(numdep, dep);
	}
	
	
	
}
