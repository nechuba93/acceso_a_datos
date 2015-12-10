package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import utilidades.Departamento;

public interface DatabaseDAOInterface {

	/**
	 * M�todo que devuelve un objeto departamento seg�n el n�mero de departamento que le pasemos
	 * @param conexion Conexion que vamos a utilizar
	 * @param numdep N�mero del departamento que queremos obtener
	 * @return <b>dep</b> Objeto departamento devuelto
	 */
	public Departamento obtenerDepartamento(int numdep);
	
	/**
	 * M�todo que devuelve una colecci�n de Objetos departamento
	 * @param conexion Conexion que vamos a utilizar
	 * @return <b>departamentos</b> Colecci�n de objetos departamento
	 */
	public ArrayList<Departamento> obtenerDepartamentos ();
	
	/**
	 * M�todo que muestra los datos de un departamento concreto
	 * @param conexion Conexion a la base de datos
	 * @param numdep Numero del departamento que queremos obtener informaci�n
	 */
	public void mostrarDepartamento(int numdep);
	
	/**
	 * M�todo que muestra los datos de los departamentos 
	 * @param conexion Conexion a la base de datos
	 */
	public void mostrarDepartamentos();
	
	/**
	 * M�todo que inserta un departamento utilizando la conexi�n que le pasemos
	 * @param conexion Conexi�n al SGBD
	 * @param dep Departamento a insertar
	 * @throws SQLException Excepci�n al no poder realizar la insercci�n
	 */
	public void insertarDepartamento(Departamento dep) throws SQLException;
	
	/**
	 * M�todo que inserta una serie de departamentos utilizando la conexi�n que le pasemos
	 * @param conexion
	 * @param departamentos
	 * @throws SQLException
	 */
	public void insertarDepartamentos(ArrayList<Departamento> departamentos) throws SQLException;
	
	/**
	 * M�todo que elimina un departamento que corresponda al n�mero introducido
	 * @param conexion Conexion a utilizar
	 * @param numdep N�mero del departamento a borrar
	 */
	public void borrarDepartamento(int numdep);
	
	/**
	 * M�todo que actualiza un departamento determinado por un n�mero
	 * @param conexion Conexion que vamos a utilizar
	 * @param numdep N�mero del departamento que vamos a actualizar
	 * @param dep Departamento con el que vamos a sustituir al anterior
	 */
	public void actualizarDepartamento(int numdep, Departamento dep);
}
