package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;


public class DaoAutorMySql {
	
	private EntityManager entityManager ;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("jpa_libreria");
			entityManager = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion(){
		try {
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int insertar(Autor autor) {
		if(!abrirConexion()) {
			return 0;
		}
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(autor);
		entityTransaction.commit();
		cerrarConexion();
		//una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return autor.getId_autor();
	}

	public Autor modificar(Autor autor) {
		if(!abrirConexion()) {
			return null;
		}
		//merge sincroninza la bd con el objeto
		//tambien puede servir para dar de alta
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		autor = entityManager.merge(autor);
		et.commit();
		cerrarConexion();
		return autor;
	}

	public int borrar(int id) {
		if(!abrirConexion()) {
			return 0;
		}
		//JPA solo trabaja con objetos dentro del contexto de persistencia
		//por lo que no vale con borrarlo directamente primero tenemos que meter el objeto en el contexto
		//de persistencia de jpa y luego ya podemos borrarlo pero el objeto pasado y el devuelto no son el mismo 
		//objeto, aunque tengan los mismos valores
		Autor autorAux = buscar(id);
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.remove(autorAux);
		et.commit();
		cerrarConexion();
		return autorAux.getId_autor();
	}
	
	public Autor buscar(int id) {
		if(!abrirConexion()) {
			return null;
		}
		return entityManager.find(Autor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Autor> listar() {
		if(!abrirConexion()) {
			return null;
		}		
		//para hacer la consulta debemos de usar JPQL
		Query query = entityManager.createQuery("select a from autor a");
		List<Autor> listaAutores = query.getResultList();
		return listaAutores;
	}

}


