package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import utilidades.Departamento;

public interface DatabaseDAOInterface {

	/**
	 * Método que devuelve un objeto departamento según el número de departamento que le pasemos
	 * @param conexion Conexion que vamos a utilizar
	 * @param numdep Número del departamento que queremos obtener
	 * @return <b>dep</b> Objeto departamento devuelto
	 */
	public Departamento obtenerDepartamento(int numdep);
	
	/**
	 * Método que devuelve una colección de Objetos departamento
	 * @param conexion Conexion que vamos a utilizar
	 * @return <b>departamentos</b> Colección de objetos departamento
	 */
	public ArrayList<Departamento> obtenerDepartamentos ();
	
	/**
	 * Método que muestra los datos de un departamento concreto
	 * @param conexion Conexion a la base de datos
	 * @param numdep Numero del departamento que queremos obtener información
	 */
	public void mostrarDepartamento(int numdep);
	
	/**
	 * Método que muestra los datos de los departamentos 
	 * @param conexion Conexion a la base de datos
	 */
	public void mostrarDepartamentos();
	
	/**
	 * Método que inserta un departamento utilizando la conexión que le pasemos
	 * @param conexion Conexión al SGBD
	 * @param dep Departamento a insertar
	 * @throws SQLException Excepción al no poder realizar la insercción
	 */
	public void insertarDepartamento(Departamento dep) throws SQLException;
	
	/**
	 * Método que inserta una serie de departamentos utilizando la conexión que le pasemos
	 * @param conexion
	 * @param departamentos
	 * @throws SQLException
	 */
	public void insertarDepartamentos(ArrayList<Departamento> departamentos) throws SQLException;
	
	/**
	 * Método que elimina un departamento que corresponda al número introducido
	 * @param conexion Conexion a utilizar
	 * @param numdep Número del departamento a borrar
	 */
	public void borrarDepartamento(int numdep);
	
	/**
	 * Método que actualiza un departamento determinado por un número
	 * @param conexion Conexion que vamos a utilizar
	 * @param numdep Número del departamento que vamos a actualizar
	 * @param dep Departamento con el que vamos a sustituir al anterior
	 */
	public void actualizarDepartamento(int numdep, Departamento dep);
}
