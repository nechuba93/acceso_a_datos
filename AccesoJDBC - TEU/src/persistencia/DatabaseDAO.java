package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilidades.Departamento;

/**
 * Clase que trata los datos de diferentes SGBD
 * 
 * @author Ignacio
 */

public class DatabaseDAO implements DatabaseDAOInterface{

	public Connection conexion;

	/**
	 * Constructor que recibe un número correspondiente a cual sgbd quieres
	 * utilizar.
	 * 
	 * @param sgbd
	 *            Número según el SGBD
	 *            <ol>
	 *            <li>MYSQL</li>
	 *            <li>HSQLDB</li>
	 *            <li>ACCESS</li>
	 *            </ol>
	 * @throws ClassNotFoundException
	 *             Excepcion lanzada al no encontrar la clase del Driver.
	 * @throws SQLException
	 *             Excepcion lanzada por no poder crear la conexion con la base
	 *             de datos.
	 */
	public DatabaseDAO(int sgbd) throws ClassNotFoundException, SQLException {
		switch (sgbd) {
		case 1:
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establecer conexion con la BD
			//conexion = DriverManager.getConnection("jdbc:mysql://172.16.100.5:3306/ignacio", "ignacio", "ignacio");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ignacio", "root", "toor");
			break;
		case 2:
			// Cargar el driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			// Establecer conexion con la BD
			conexion = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			break;
		case 3:
			// Cargar el driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// Establecer conexion con la BD
			conexion = DriverManager.getConnection("jdbc:odbc:EJEMPLO-ACCESS");
			break;
		}
	}
	
	/**
	 * Método que devuelve un objeto departamento según el número de departamento que le pasemos
	 * @param conexion Conexion que vamos a utilizar
	 * @param numdep Número del departamento que queremos obtener
	 * @return <b>dep</b> Objeto departamento devuelto
	 */
	public Departamento obtenerDepartamento(int numdep){
		PreparedStatement mostrar = null;
		Departamento dep = null;
		try {
			if (mostrar == null) {

				String query = "SELECT * FROM departamentos WHERE id = ?";

				mostrar = conexion.prepareStatement(query);
				mostrar.setInt(1, numdep);

				ResultSet rs = mostrar.executeQuery();
				
				while(rs.next()){
					dep = new Departamento(rs.getInt(1),rs.getString(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dep;
	}
	
	/**
	 * Método que devuelve una colección de Objetos departamento
	 * @param conexion Conexion que vamos a utilizar
	 * @return <b>departamentos</b> Colección de objetos departamento
	 */
	public ArrayList<Departamento> obtenerDepartamentos(){
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		Departamento dep;
		try {

			// Preparar la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos");

			while (resul.next()) {
				dep = new Departamento(resul.getInt(1),resul.getString(2));
				departamentos.add(dep);
			}

			resul.close();
			sentencia.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return departamentos;
	}
	
	/**
	 * Método que muestra los datos de un departamento concreto
	 * @param conexion Conexion a la base de datos
	 * @param numdep Numero del departamento que queremos obtener información
	 */
	public void mostrarDepartamento(int numdep){
		
		PreparedStatement mostrar = null;
		try {
			if (mostrar == null) {

				String query = "SELECT * FROM departamentos WHERE id = ?";

				mostrar = conexion.prepareStatement(query);
				mostrar.setInt(1, numdep);

				ResultSet rs = mostrar.executeQuery();

				System.out.println("ID" + "\t" + "Nombre");
				System.out.println("--" + "\t" + "------------------------");
				
				while(rs.next()){
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Método que muestra los datos de los departamentos 
	 * @param conexion Conexion a la base de datos
	 */
	public void mostrarDepartamentos() {
		try {

			// Preparar la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos");

			System.out.println("ID" + "\t" + "Nombre");
			System.out.println("--" + "\t" + "------------------------");

			while (resul.next()) {
				System.out.println(resul.getInt(1) + "\t" + resul.getString(2));
			}
			System.out.println();
			resul.close();
			sentencia.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que inserta un departamento utilizando la conexión que le pasemos
	 * @param conexion Conexión al SGBD
	 * @param dep Departamento a insertar
	 * @throws SQLException Excepción al no poder realizar la insercción
	 */
	public void insertarDepartamento(Departamento dep) throws SQLException {

		PreparedStatement insertar = null;
		if (insertar == null) {
			insertar = conexion.prepareStatement("INSERT INTO departamentos (nombre) VALUES (?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insertar.setString(1, dep.getNombre());
			insertar.executeUpdate();

			/** Obtener el ID del nuevo departamento
			
			ResultSet rs = insertar.getGeneratedKeys();
			while (rs.next()) {
				int claveGenerada = rs.getInt(1);
				System.out.println("Insertado departamento con ID = " + claveGenerada);
				System.out.println();
			}
			**/
		}
	}
	
	/**
	 * Método que inserta una serie de departamentos utilizando la conexión que le pasemos
	 * @param conexion
	 * @param departamentos
	 * @throws SQLException
	 */
	public void insertarDepartamentos(ArrayList<Departamento> departamentos) throws SQLException{
		Departamento dep;
		for (int i = 0; i < departamentos.size(); i++) {
			dep = departamentos.get(i);
			insertarDepartamento(dep);
		}
	}
	
	/**
	 * Método que elimina un departamento que corresponda al número introducido
	 * @param conexion Conexion a utilizar
	 * @param numdep Número del departamento a borrar
	 */
	public void borrarDepartamento(int numdep){
		PreparedStatement eliminar = null;
		try {
			if (eliminar== null) {

				String query = "DELETE FROM departamentos WHERE id = ?";
				eliminar = conexion.prepareStatement(query);
				eliminar.setInt(1, numdep);
				eliminar.executeUpdate();
				System.out.println("Departamento borrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que actualiza un departamento determinado por un número
	 * @param conexion Conexion que vamos a utilizar
	 * @param numdep Número del departamento que vamos a actualizar
	 * @param dep Departamento con el que vamos a sustituir al anterior
	 */
	public void actualizarDepartamento(int numdep, Departamento dep){
		PreparedStatement actualizar = null;
		try {
			if (actualizar== null) {

				String query = "UPDATE departamentos SET nombre = ? WHERE id = ?";
				actualizar = conexion.prepareStatement(query);
				actualizar.setString(1, dep.getNombre());
				actualizar.setInt(2, numdep);
				actualizar.executeUpdate();
				System.out.println("Departamento actualizado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
