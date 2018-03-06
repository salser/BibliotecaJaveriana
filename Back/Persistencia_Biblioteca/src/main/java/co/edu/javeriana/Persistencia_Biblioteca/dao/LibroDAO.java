/**
 * 
 */
package co.edu.javeriana.Persistencia_Biblioteca.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.javeriana.Persistencia_Biblioteca.bo.LibroBO;

/**
 * @author hsalazar
 *
 */
public class LibroDAO extends AbstractDAO {
	private static LibroDAO instance;
	final SessionFactory factory;

	public static LibroDAO getInstance() {
		if (instance == null) {
			instance = new LibroDAO();
		}
		return instance;
	}

	protected LibroDAO() {
		this.factory = SessionHandler.getInstance().getFactory();
		super.setFactory(this.factory);
	}

	public boolean insertarLibro(String nombre, String ISBN, String autores) {

		boolean result = false;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = " from " + LibroBO.class.getName() + " where ISBN = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", ISBN);
			Object row = query.uniqueResult();
			boolean flag = row == null;

			if (flag) {
				LibroBO libro = new LibroBO();
				libro.setNombre(nombre);
				libro.setISBN(ISBN);
				libro.setAutores(autores);
				session.save(libro);
				tx.commit();
				result = true;
			} else {
				//error
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			try {
				session.flush();
				session.close();
			} catch (NullPointerException e) {
				//error cerrando conexión
			}
		}
		return result;
	}
	
	public boolean eliminarLibro(String ISBN) {

		boolean result = false;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = " from " + LibroBO.class.getName() + " where ISBN = '"+ ISBN +"'";
			Query query = session.createQuery(hql);
			Object row = query.uniqueResult();
			boolean flag = row != null;

			if (flag) {
				session.delete(row);
				tx.commit();
				result = true;
			} else {
				//error
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			try {
				session.flush();
				session.close();
			} catch (NullPointerException e) {
				//error cerrando conexión
			}
		}
		return result;
	}
	
	public boolean actualizarLibro(String ISBN, String nombre, String autores) {

		boolean result = false;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = " from " + LibroBO.class.getName() + " where ISBN = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", ISBN);
			Object row = query.uniqueResult();
			boolean flag = row != null;

			if (flag) {
				LibroBO libro = (LibroBO) row;
				libro.setAutores(autores);
				libro.setNombre(nombre);
				session.update(libro);
				tx.commit();
				result = true;
			} else {
				//error
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			try {
				session.flush();
				session.close();
			} catch (NullPointerException e) {
				//error cerrando conexión
			}
		}
		return result;
	}

}
