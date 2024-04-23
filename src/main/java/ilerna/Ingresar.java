package ilerna;

public class Ingresar {
	 private Lector lector;
	 private Libro libro;
	 
	 public Ingresar(Lector lector, Libro libro) {
		 this.lector = lector;
		 this.libro = libro;
	 }
	 
	 public Lector getLector() {
		 return lector;
	 }
	 
	 public Libro getLibro() {
		 return libro;
	 }
	 
	 public void setLector(Lector lector) {
		 this.lector = lector;
	 }
	 
	 public void setLibro(Libro libro) {
		 this.libro = libro;
	 }
}
