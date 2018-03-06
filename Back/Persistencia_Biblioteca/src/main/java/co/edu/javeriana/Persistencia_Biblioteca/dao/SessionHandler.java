package co.edu.javeriana.Persistencia_Biblioteca.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 
 * @author henry salazar
 * @version 1.0.0
 * Clase Singleton para el manejo de la sesion con base de datos
 */
public class SessionHandler {
	private static SessionHandler instance;
	final SessionFactory factory;
	public static SessionHandler getInstance() {
		if (instance == null) {
			instance = new SessionHandler();
		}
		return instance;
	}
	
	protected SessionHandler(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public SessionFactory getFactory() {
		return factory;
	}
	
}

