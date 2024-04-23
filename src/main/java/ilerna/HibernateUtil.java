package ilerna;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	static SessionFactory sessionFactory = null;
	
	public HibernateUtil() {	
		System.out.println("INICIO DEL PROGRAMA..");
		
		//PARA INDICAR QUE QUEREMOS USAR HIBERNATE DEFINIMOS LAS INTERFACES
		Configuration cfg = new Configuration().configure();
		
		//UNICA INSTANCIA DE SESSIONFACTORY EN NUESTRA SESIÓN
		sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
				
		System.out.println("CONFIGURACIÓN REALIZADA");
	}
	
	public  SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

