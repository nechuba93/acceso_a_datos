package presentacion;

import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.DatabaseDAO;
import servicios.DepartamentosBDService;
import servicios.DepartamentosServiceInterface;
import utilidades.Departamento;

public class MainDepartamentos {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DepartamentosServiceInterface MysqlService = new DepartamentosBDService(new DatabaseDAO(1));
		
		DepartamentosServiceInterface HsqldbService = new DepartamentosBDService(new DatabaseDAO(2));
		
		//Funciona recuperar datos de Mysql y meter en Hsqldb
		//ArrayList<Departamento> departamentos = MysqlService.obtenerDepartamentos();
		//HsqldbService.insertarDepartamentos(departamentos);
		//System.out.println("Traspaso de datos completado");
		
		//Funciona borrar departamento
		//HsqldbService.borrarDepartamento(4);
		
		//Funciona actualizar departamento
		//Departamento dep = new Departamento("Psicologia");
		//HsqldbService.actualizarDepartamento(3, dep);
		
		//Funciona mostrar departamentos
		//HsqldbService.mostrarDepartamento(3);
		//System.out.println();
		//HsqldbService.mostrarDepartamentos();
	}

}
