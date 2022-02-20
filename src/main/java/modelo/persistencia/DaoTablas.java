package modelo.persistencia;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;


public class DaoTablas {

	public void crearTablas() {
		

		DaoAutorMySql daoAutor = new DaoAutorMySql();
		DaoLibroMySql daoLibro = new DaoLibroMySql();
		DaoEditorialMySql daoEditorial = new DaoEditorialMySql();
		DaoLibreriaMySql daoLibreria = new DaoLibreriaMySql();
		
		
		@SuppressWarnings("deprecation")
		Autor michael = new Autor("Michael", "Ende", new Date(29, 10,12));
		@SuppressWarnings("deprecation")
		Autor carlos = new Autor ("Carlos", "Ruiz Zafón", new Date(64, 8,25));
		@SuppressWarnings("deprecation")
		Autor brandon = new Autor ("Brandon", "Sanderson", new Date(75, 11,19));
		
		Libro laHistoria = new Libro("La Historia Interminable",12.50);
		List<Libro> librosMichael = new ArrayList<>();
		librosMichael.add(laHistoria);
		laHistoria.setAutor(michael);
		michael.setLibros(librosMichael);
		
		Libro laSombra = new Libro("La Sombra del viento",20.20);
		laSombra.setAutor(carlos);
		Libro elPrisionero = new Libro("El Prisionero del Cielo",22.50);
		elPrisionero.setAutor(carlos);
		Libro elJuego = new Libro("El Juego del Angel",21.00);
		elJuego.setAutor(carlos);
		Libro elLaberinto = new Libro("El Laberinto de los Espíritus",19.80);
		elLaberinto.setAutor(carlos);
		List<Libro> librosCarlos = new ArrayList<>();
		librosCarlos.add(laSombra);
		librosCarlos.add(elPrisionero);
		librosCarlos.add(elJuego);
		librosCarlos.add(elLaberinto);
		carlos.setLibros(librosCarlos);
		
		Libro elantris = new Libro("Elantris",23.30);
		Libro elCamino = new Libro("El Camino de los Reyes",17.50);
		Libro elImperio = new Libro("El Imperio Final",22.10);
		List<Libro> librosBrandon = new ArrayList<>();
		librosBrandon.add(elantris);
		librosBrandon.add(elCamino);
		librosBrandon.add(elImperio);
		elantris.setAutor(brandon);
		elCamino.setAutor(brandon);
		elImperio.setAutor(brandon);
		brandon.setLibros(librosBrandon);
		
		
		Libreria cementerio = new Libreria("Cementerio de los Libros Olvidados", "Daniel Sempere", "Calle Arco del Teatro");
		List<Libro> librosCementerio = new ArrayList<>();
		librosCementerio.add(laSombra);
		librosCementerio.add(elPrisionero);
		librosCementerio.add(elJuego);
		librosCementerio.add(elLaberinto);
		librosCementerio.add(elantris);
		cementerio.setLibros(librosCementerio);
		
		Libreria koreander = new Libreria("Libreria Koreander", "Karl Konrad Koreander", "Calle Fujur");
		List<Libro> librosKoreander = new ArrayList<>();
		librosKoreander.add(laHistoria);
		librosKoreander.add(elantris);
		librosKoreander.add(elCamino);
		librosKoreander.add(elImperio);
		librosKoreander.add(elLaberinto);
		koreander.setLibros(librosKoreander);
		
		Editorial alfa = new Editorial("Alfaguara","Calle Alfaguara");
		List<Libro> librosAlfa = new ArrayList<>();
		librosAlfa.add(laHistoria);
		laHistoria.setEditorial(alfa);
		librosAlfa.add(elantris);
		elantris.setEditorial(alfa);
		alfa.setLibros(librosAlfa);

		Editorial planeta = new Editorial("Planeta ","Av. Diagonal, 662-664");
		List<Libro> librosPlaneta = new ArrayList<>();
		librosPlaneta.add(elCamino);
		elCamino.setEditorial(planeta);
		librosPlaneta.add(elImperio);
		elImperio.setEditorial(planeta);
		librosPlaneta.add(elLaberinto);
		elLaberinto.setEditorial(planeta);
		librosPlaneta.add(laSombra);
		laSombra.setEditorial(planeta);
		librosPlaneta.add(elJuego);
		elJuego.setEditorial(planeta);
		librosPlaneta.add(elPrisionero);
		elPrisionero.setEditorial(planeta);
		planeta.setLibros(librosPlaneta);
		
		
		daoAutor.insertar(brandon);
		daoAutor.insertar(carlos);
		daoAutor.insertar(michael);
		
		daoLibro.insertar(elImperio);
		daoLibro.insertar(elantris);
		daoLibro.insertar(elCamino);
		daoLibro.insertar(elJuego);
		daoLibro.insertar(elPrisionero);
		daoLibro.insertar(elLaberinto);
		daoLibro.insertar(laHistoria);
		daoLibro.insertar(laSombra);
		
		daoLibreria.insertar(koreander);
		daoLibreria.insertar(cementerio);
		
		daoEditorial.insertar(planeta);
		daoEditorial.insertar(alfa);
		
	}
	
}
