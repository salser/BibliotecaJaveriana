/**
 * 
 */
package co.edu.javeriana.Persistencia_Biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author hsalazar
 *
 */
public class AbstractDAO {
	SessionFactory factory;
	


	public boolean insert(Object registro) {
		Transaction tx = null;
		Session session = factory.getCurrentSession();
		boolean realizado = false;
		try {
			tx = session.beginTransaction();
			session.save(registro);
			
			realizado = true;
		}catch(Exception e) {
			//ERROR
		}
		
		return realizado;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Object> get(String className) {
		Transaction tx = null;
		Session session = factory.getCurrentSession();
		List<Object> result = new ArrayList<Object>();
		try {
			tx = session.beginTransaction();
			
			String sql = " from " + className;
			Query query = session.createQuery(sql);
			List<Object> resultSet = query.list();

			if (!resultSet.isEmpty()) {
				result.addAll(resultSet);
			} else {
				//ERROR
			}
		}catch(Exception e) {
			//ERROR
		}
		
		return result;
	}

	public boolean delete(Object registro) {
		Transaction tx = null;
		Session session = factory.getCurrentSession();
		boolean realizado = false;
		try {
			tx = session.beginTransaction();
			session.delete(registro);
			
			realizado = true;
		}catch(Exception e) {
			//ERROR
		}
		
		return realizado;
	}

	public boolean update(Object registro) {
		Transaction tx = null;
		Session session = factory.getCurrentSession();
		boolean realizado = false;
		try {
			tx = session.beginTransaction();
			session.update(registro);
			
			realizado = true;
		}catch(Exception e) {
			//ERROR
		}
		return realizado;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}

