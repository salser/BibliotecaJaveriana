/**
 * 
 */
package co.edu.javeriana.Persistencia_Biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
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
		Session session = factory.openSession();
		Transaction tx = null; 
		boolean realizado = false;
		try{
			tx = session.beginTransaction();
			session.save(registro);
			tx.commit();
			realizado = true;
		}catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
		}finally{
			try{
				session.close();
			}catch(Exception e){
			}
		}
		return realizado;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Object> get(String className){
		Session session = factory.openSession();
		List<Object> result = new ArrayList<Object>();
		try{
			String sql = " from " + className;
			Query query = session.createQuery(sql);
			List<Object> resultSet = query.list();

			if (!resultSet.isEmpty()) {
				result.addAll(resultSet);
			} else {
				result = null;
			}
		}catch(HibernateException e){
		}finally{
			try{
				session.flush();
				session.close();
			}catch(NullPointerException e){
			}
		}
		return result;
	}
	
	public boolean delete(Object registro){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		boolean realizado = false;
		try{
			session.delete(registro);
			realizado = true;
			tx.commit();
		}catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
		}finally{
			try{
				session.close();
			}catch(Exception e){
			}
		}
		return realizado;
	}
	
	public boolean update(Object registro){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		boolean realizado = false;
		try{
			session.update(registro);
			realizado = true;
			tx.commit();
		}catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
		}finally{
			try{
				session.close();
			}catch(Exception e){
			}
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

