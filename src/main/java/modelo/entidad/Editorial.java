package modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_editorial;
	private String nombre;
	private String direcion;
	private String libro;
	
	public Editorial() {
		super();
	}

	public Editorial(int id_editorial, String nombre, String direcion, String libro) {
		super();
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.direcion = direcion;
		this.libro = libro;
	}

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Editorial [id_editorial=" + id_editorial + ", nombre=" + nombre + ", direcion=" + direcion + ", libro="
				+ libro + "]";
	}
	
	
	
}
