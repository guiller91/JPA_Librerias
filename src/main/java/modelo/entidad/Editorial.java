package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editorial")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String direcion;
	
	// relación de uno a muchos con Libro
	// Esta anotacion en este extremo es para hacer la relacion bidireccional.
	@OneToMany(mappedBy="editorial", cascade=CascadeType.ALL)
	private List<Libro> libros;
	
	public Editorial() {
		super();
	}

	public Editorial(String nombre, String direcion) {
		super();
		libros=new ArrayList<>();
		this.nombre = nombre;
		this.direcion = direcion;

	}

	public int getId_editorial() {
		return id;
	}

	public void setId_editorial(int id_editorial) {
		this.id = id_editorial;
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

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Editorial [id_editorial=" + id + ", nombre=" + nombre + ", direcion=" + direcion + ", libros="
				+ libros + "]";
	}

	
}
