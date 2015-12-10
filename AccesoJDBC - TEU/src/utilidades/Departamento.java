package utilidades;

public class Departamento {

	int id;
	String nombre;
	
	public Departamento(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
