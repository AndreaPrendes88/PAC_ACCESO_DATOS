package ilerna;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo="lector")
public class Lector{

	private int idLector;
	private String lectorNombre;
	private String lectorApellido;
	private String lectorEmail;
	
	public Lector() {
	}
	
	public Lector (String lectorNombre, String lectorApellido, String lectorEmail) {
		this.lectorNombre = lectorNombre;
		this.lectorApellido = lectorApellido;
		this.lectorEmail = lectorEmail;
	}

	//GETTER
	public int getIdLector(){
		return idLector;
	}
	
	public String getLectorNombre() {
		return lectorNombre;
	}
	
	public String getLectorApellido() {
		return lectorApellido;
	}
	
	public String getLectorEmail() {
		return lectorEmail;
	}


	//SETTER
	public void setIdLector(int idLector) {
		this.idLector = idLector;
	}
	
	public void setLectorNombre(String lectorNombre) {
		this.lectorNombre = lectorNombre;
	}
	
	public void setLectorApellido(String lectorApellido) {
		this.lectorApellido = lectorApellido;
	}
	
	public void setLectorEmail(String lectorEmail) {
		this.lectorEmail = lectorEmail;
	}

}















