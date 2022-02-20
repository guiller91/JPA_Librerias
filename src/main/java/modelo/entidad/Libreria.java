package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String nombre_dueño;
	private String direcion;
	
	@ManyToMany(mappedBy = "librerias", cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)	 
	private List<Libro> libros;
	
	public Libreria() {
		super();
	}

	public Libreria(String nombre, String nombre_dueño, String direcion) {
		super();
		this.nombre = nombre;
		this.nombre_dueño = nombre_dueño;
		this.direcion = direcion;

	}

	public int getId_libreria() {
		return id;
	}

	public void setId_libreria(int id_libreria) {
		this.id = id_libreria;
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
		return "Libreria [id_libreria=" + id + ", nombre=" + nombre + ", nombre_dueño=" + nombre_dueño
				+ ", direcion=" + direcion + ", libros=" + libros + "]";
	}
	
	
	

	
}
