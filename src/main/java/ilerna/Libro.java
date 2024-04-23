package ilerna;

import java.util.Date;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo ="libro")

public class Libro {

	private int idLibro;
	private String libroTitulo;
	private String libroAutor;
	private Date libroPublicacion;
	private boolean libroDisponible;
	
		
	public Libro() {
			
	}
	
	public Libro (String libroTitulo, String libroAutor, Date libroPublicacion, boolean libroDisponible) {
		super();
		this.libroTitulo = libroTitulo;
		this.libroAutor = libroAutor;
		this.libroPublicacion = libroPublicacion;
		this.libroDisponible = libroDisponible;
			
	}
		
	//CREAMOS LOS GETTER
		
	public int getIdLibro() {
		return idLibro;
	}
		
	public String getLibroTitulo() {
		return libroTitulo;
	}
		
	public String getLibroAutor() {
		return libroAutor;
	}
		
	public Date getLibroPublicacion() {
		return libroPublicacion;
	}
		
	public boolean getLibroDisponible() {
		return libroDisponible;
	}
		
	//CREAMOS LOS SETTER
		
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
		
	public void setLibroTitulo(String libroTitulo) {
		this.libroTitulo = libroTitulo;
	}
		
	public void setLibroAutor(String libroAutor) {
		this.libroAutor = libroAutor;
	}
		
	public void setLibroPublicacion(Date libroPublicacion) {
		this.libroPublicacion = libroPublicacion;
	}
		
	public void setLibroDisponible(boolean libroDiponible) {
		this.libroDisponible = true;
	}
}



