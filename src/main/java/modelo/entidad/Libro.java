package modelo.entidad;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private double precio;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_id_editorial", referencedColumnName = "id")    
    private Editorial editorial;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "libreria_libro", joinColumns = @JoinColumn(name = "fk_id_libro", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fk_id_libreria", referencedColumnName = "id"))
	private List<Libreria> librerias;


	public Libro(String titulo, double precio) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.librerias=new ArrayList<>();
	}


	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_libro() {
		return id;
	}


	public void setId_libro(int id_libro) {
		this.id = id_libro;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public List<Libreria> getLibrerias() {
		return librerias;
	}


	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}


	@Override
	public String toString() {
		return "Libro [id_libro=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial
				+ ", autor=" + autor + ", librerias=" + librerias + "]";
	}
	

	
	
}
