package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.persistencia.DaoAutorMySql;
import modelo.persistencia.DaoEditorialMySql;
import modelo.persistencia.DaoLibreriaMySql;
import modelo.persistencia.DaoLibroMySql;

public class MenuConsola {
	
	static DaoAutorMySql daoAutor = new DaoAutorMySql();
	static DaoLibroMySql daoLibro = new DaoLibroMySql();
	static DaoEditorialMySql daoEditorial = new DaoEditorialMySql();
	static DaoLibreriaMySql daoLibreria = new DaoLibreriaMySql();


	public static void main(String[] args) {
		
		menuPrincipal();
	}

	public static void menuPrincipal() {

		try (Scanner sc = new Scanner(System.in)) {
			boolean continuar = true;
			String opcion;

			while (continuar) {

				System.out.println("\n-----MENÚ PARA LA GESTIÓN DE LIBRERÍAS-----");
				System.out.println("_________________________________________");
				System.out.println("----> 1. Mostrar todos los libros dados de alta, con su editorial y su autor \n" 
						+ "----> 2. Mostrar todos los autores dados de alta, con sus libros asociados \n"
						+ "----> 3. Mostrar todas las librerías, con solamente sus libros asociados \n"
						+ "----> 4. Mostrar todos los libros dados de alta, y en la librería en la que están \n"
						+ "----> 5. Terminar el programa");

				opcion = sc.nextLine();

				switch (opcion) {
				case "1":
					List<Libro> libros = daoLibro.listar();

					for (Libro libro : libros) {
						System.out.println(libro.toString());
					}
					
					break;
				case "2":

					break;
				case "3":

					break;
				case "4":

					break;
				case "5":

					continuar = false;
					break;
			
				default:
					System.out.println("Elige la opción escribiendo un número del menú, por favor \n");
				}
			}
		}
	}
}


