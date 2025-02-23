package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private int id_libreria;
	private String nombre;
	private String nombre_due�o;
	private String direcion;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="libros_en_librerias",
			   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id_libreria") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id_libro")}) 
	private List<Libro> libros;
	
	public Libreria() {
		super();
	}

	public Libreria(String nombre, String nombre_due�o, String direcion) {
		super();
		this.nombre = nombre;
		this.nombre_due�o = nombre_due�o;
		this.direcion = direcion;

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

	public String getNombre_due�o() {
		return nombre_due�o;
	}

	public void setNombre_due�o(String nombre_due�o) {
		this.nombre_due�o = nombre_due�o;
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
		return "Libreria [id_libreria=" + id_libreria + ", nombre=" + nombre + ", nombre_due�o=" + nombre_due�o
				+ ", direcion=" + direcion + ", libros=" + libros + "]";
	}
	
	
	

	
}
