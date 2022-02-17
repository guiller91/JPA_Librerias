package modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_libreria;
	private String nombre;
	private String nombre_dueño;
	private String direcion;
	private List<Libro> libros;
	
	public Libreria() {
		super();
	}

	public Libreria(int id_libreria, String nombre, String nombre_dueño, String direcion, List<Libro> libros) {
		super();
		this.id_libreria = id_libreria;
		this.nombre = nombre;
		this.nombre_dueño = nombre_dueño;
		this.direcion = direcion;
		this.libros = libros;
	}

	public int getId_libreria() {
		return id_libreria;
	}

	public void setId_libreria(int id_libreria) {
		this.id_libreria = id_libreria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_dueño() {
		return nombre_dueño;
	}

	public void setNombre_dueño(String nombre_dueño) {
		this.nombre_dueño = nombre_dueño;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [id_libreria=" + id_libreria + ", nombre=" + nombre + ", nombre_dueño=" + nombre_dueño
				+ ", direcion=" + direcion + ", libros=" + libros + "]";
	}
	
	
	

	
}
