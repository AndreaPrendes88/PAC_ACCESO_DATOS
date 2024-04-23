package ilerna;

import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private int idLibro;
	private int idLector;	
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	
	
	public Prestamo() {
			
	}
		
	public Prestamo (int idPrestamo, Date fechaPrestamo, Date fechaDevolucion, int idLibro, int idLector) {
		super();
		this.idPrestamo = idPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.idLibro = idLibro;
		this.idLector = idLector;
			
	}
		
	//CREAMOS LOS GETTER
		
	public int getIdPrestamo() {
		return idPrestamo;
	}
		
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
		
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
		
	public int getIdLibro() {
		return idLibro;
	}
		
	public int getIdLector() {
		return idLector;
	}
		
	//CREAMOS LOS SETTER
		
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
		
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
		
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
		
	public void setIdLibro(int libro) {
		this.idLibro = libro;
	}
		
	public void setIdLector(int lector) {
		this.idLector = lector;
	}
}

