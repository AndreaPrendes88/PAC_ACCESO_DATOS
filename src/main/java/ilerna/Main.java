package ilerna;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static HibernateUtil util;
	private static SessionFactory factory;	
	
		public static void main(String[] args) {
			util = new HibernateUtil();		
			factory = util.getSessionFactory();
			
/**
 * Metodo para mostrar las diferentes opciones
 * @author Andrea
 */ 
			
			int opcion;
		
			do {
				mostrarMenu();
				opcion = sc.nextInt();
				sc.nextLine();
			 
				switch(opcion) {
					case 1:
						IngresarLibro();
						break;
					case 2: 
						IngresarLector();
						break;
					case 3:	
						ListadoLibros();
						break;
					case 4: 
						ListadoLectores();
						break;
					case 5:
						VerLibroID();
						break;
					case 6: 
						VerLectorID();
						break;
					}
				} while (opcion !=7);
		}
			
	/**
	 *  MOSTRAR OPCIONES DE MENU
	 * Esto es lo que verá el usuario
	 * @author Andrea
	 */
		public static void mostrarMenu() {
			System.out.println("---------------------------------- ");
			System.out.println("Realizar una nueva acción: ");
			System.out.println(" (1) Insertar libro");
			System.out.println(" (2) Insertar lector");
			System.out.println(" (3) Listado libros");
			System.out.println(" (4) Listado de lectores");
			System.out.println(" (5) Ver libro por ID");
			System.out.println(" (6) Ver lector por ID");
			System.out.println("---------------------------------");
			System.out.println(" (7) Salir");
		}
		 	
	/**
	 * METODO PARA INSERTAR LIBRO
	 * Con este método podemos insertar un libro en la BD.
	 * @author Andrea
	 * @param libroTitulo, libroAutor, libroPublicacion, libroDisponible
	 */
		public static void IngresarLibro() {
			try {
				Session session = factory.openSession();
				
			//Declaracion variables
				String libroTitulo;
				String libroAutor;
				Date libroPublicacion;
				Boolean libroDisponible;
				Libro libro = new Libro();

			//Salida por pantalla
				System.out.println("1.- Introduce un título.");
				libroTitulo = sc.nextLine();
				System.out.println("2.- Introduce un autor.");
				libroAutor = sc.nextLine();
				System.out.println("3.- Introduce la fecha de publicación (formato: yyyy-MM-dd)");
					//Lee la fecha como una cadena 
					String fechaPublicacion = sc.nextLine();
					//Formateo de la fecha 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						//Convertimos la cadena en una fecha 
						libroPublicacion = sdf.parse(fechaPublicacion);
					} catch(ParseException e) {
						System.out.println("Formato de fecha incorrecto. Por favor, introduce la fecha con el formato yyyy-MM-dd.");
						return;
					}
				System.out.println("4.- ¿Está el libro disponible?. True/False");
					while(true||false) {
						try {
							//Lee el valor directamente del usuario
							libroDisponible = sc.nextBoolean();
							break; 
						} catch (InputMismatchException e) {
							//Notificamos al usuario si la entrada no es correcta
							System.out.println("Entrada incorrecta. Por favor, introduce 'true' o 'false'.");
						}		
					}
			
			//Guardar valores introducidos por pantalla
				libro = new Libro(libroTitulo, libroAutor, libroPublicacion, libroDisponible);
				Transaction transation = session.beginTransaction();
				session.save(libro);
			
				transation.commit();
				session.close();
			
			} catch (HibernateException e) {
				e.printStackTrace();
				} 
		}
		
		/**
		 * METODO PARA INSERTAR LECTOR
		 *  Con este método podemos insertar un libro en la BD.
		 *  @author Andrea
		 *  @param lectorNombre, lectorApellido, lectorEmail
		 */
		public static void IngresarLector() {
			try {
				
				Session session = factory.openSession();  
			//Declaracion variables
				String lectorNombre;
				String lectorApellido;
				String lectorEmail;
				Lector lector = new Lector();
			
			//Salida por pantalla
				System.out.println("1.- Introduce un nombre.");
				lectorNombre = sc.nextLine();
				System.out.println("2.- Introduce un apellido.");
				lectorApellido = sc.nextLine();
				System.out.println("3.- Introduce un email.");
				lectorEmail = sc.nextLine();
			
			//Guardar valores introducidos por pantalla
				lector = new Lector(lectorNombre, lectorApellido, lectorEmail);
				Transaction transation = session.beginTransaction();
			//Salvar esos valores
				session.save(lector);
				transation.commit();
			
			} catch (HibernateException e) {
				e.printStackTrace();
				} 
		}	
		
		/**
		 * METODO PARA MOSTRAR LISTADO DE LIBROS
		 * Con este método conseguimos el listado de todos los libros de la base de datos. 
		 * @author Andrea
		 * @param titulo, autor, disponible.
		 */
		public static void ListadoLibros() {
			Session session = null;
			try {
				session = factory.openSession();  

			//Salida por pantalla 
				System.out.println("LIBROS DE LA BASE DE DATOS");
			//Consulta SQL para obtener el listado de libros
				String sql = "SELECT * FROM libro";
				NativeQuery<Libro> query = session.createNativeQuery(sql, Libro.class);
			// Obtener el resultado de la consulta
				List<Libro> libros = query.getResultList(); 
				
				for (Libro libro2 : libros) {
					String titulo = libro2.getLibroTitulo();
					String autor = libro2.getLibroAutor();
					Boolean disponible = libro2.getLibroDisponible();
					System.out.println("Titulo: "+titulo+"   Autor: "+autor+ "    Disponible: "+disponible);
				}
			}catch (HibernateException e) {
				e.printStackTrace();
				} 
		} 
		
		/**
		 * MÉTODO PARA MOSTRAR LISTADO DE LECTORES
		 * Con este método conseguimos el listado de todos los lectores de la base de datos. 
		 * @author Andrea
		 * @param nombre, apellido
		 */
		public static void ListadoLectores() {
			Session session = null;
			try {
				session = factory.openSession();  
			//Salida por pantalla 
				System.out.println("LECTORES DE LA BASE DE DATOS");
			// Consulta SQL para obtener el listado de lectores
				String sql = "SELECT * FROM lector";
				NativeQuery<Lector> query = session.createNativeQuery(sql, Lector.class);
			// Obtener el resultado de la consulta
				List<Lector> lectores = query.getResultList(); 
				
				for (Lector lector2 : lectores) {
					String nombre = lector2.getLectorNombre();
					String apellido = lector2.getLectorApellido();
					System.out.println("Nombre:  "+nombre + " " + apellido);
				}
			}catch (HibernateException e) {
				e.printStackTrace();
				} 
		} 
		
		/**
		 * MÉTODO PARA VER LIBRO POR ID
		 * Introducimos un ID y nos devuelve el libro al que pertenece.
		 * @author Andrea
		 * @param titulo, autor, disponible
		 */
		public static void VerLibroID() {
			Session session = null;
		    try {
		        session = factory.openSession();  
		    // Salida por pantalla 
		        System.out.println("INFORMACIÓN DEL LIBRO");
		        
		    // Consulta SQL para obtener el libro con el ID especificado
		        String sql = "SELECT * FROM libro WHERE libro_id = :libro_id";
		        NativeQuery<Libro> query = session.createNativeQuery(sql, Libro.class);
				query.setParameter("libro_id", 2); //El 2º parámetro es el num de ID
		        
		    // Obtener el resultado de la consulta
		        List<Libro> libros = query.getResultList(); 
		        
		    // Verificar si se encontró el libro con el ID especificado
		        if (libros.isEmpty()) {
		            System.out.println("No se encontró ningún libro con el ID especificado.");
		        } else {
		    // Mostrar información del libro
		            Libro libro = libros.get(0);
		            String titulo = libro.getLibroTitulo();
		            String autor = libro.getLibroAutor();
		            Boolean disponible = libro.getLibroDisponible();
		            System.out.println("Título: " + titulo + ", Autor: " + autor + ", Disponible: " + disponible);
		        }
		    } catch (HibernateException e) {
		        e.printStackTrace();
		    }
		}
			
		/**
		 * MÉTODO PARA VER LECTOR POR ID
		 * Introducimos un ID y nos devuelve el lector al que pertenece.
		 * @author Andrea
		 * @param nombre, apellido
		 */
		public static void VerLectorID() {
			Session session = null;
			try {
			    session = factory.openSession();  
			        
			// Salida por pantalla 
			    System.out.println("INFORMACIÓN DEL LECTOR");
			        
			// Consulta SQL para obtener el libro con el ID especificado
			    String sql = "SELECT * FROM lector WHERE lector_id = :lector_id";
			    NativeQuery<Lector> query = session.createNativeQuery(sql, Lector.class);
			    query.setParameter("lector_id", 2); //El 2º parámetro es el num de ID
			        
			// Obtener el resultado de la consulta
			    List<Lector> lectores = query.getResultList(); 
			        
			// Verificar si se encontró el libro con el ID especificado
			     if (lectores.isEmpty()) {
			         System.out.println("No se encontró ningún libro con el ID especificado.");
			     } else {
			// Mostrar información del libro
			        Lector lector = lectores.get(0);
			        String nombre = lector.getLectorNombre();
			        String apellido = lector.getLectorApellido();
			        System.out.println("Nombre: " + nombre + " " + apellido);
			     }
			} catch (HibernateException e) {
			    e.printStackTrace();
			}
		}	
}



