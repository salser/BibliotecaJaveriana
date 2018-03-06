package co.edu.javeriana.Persistencia_Biblioteca.fachada;

import co.edu.javeriana.Persistencia_Biblioteca.dao.LibroDAO;

/**
 * 
 * @author hsalazar
 *
 */
public class FachadaPersistencia {
	
	public boolean insertarLibro(String nombre, String ISBN, String autores) {
		return LibroDAO.getInstance().insertarLibro(nombre, ISBN, autores);
	}
	
	public boolean eliminarLibro(String ISBN) {
		return LibroDAO.getInstance().eliminarLibro(ISBN);
	}
	
	public boolean actualizarLibro(String ISBN, String nombre, String autores) {
		return LibroDAO.getInstance().actualizarLibro(ISBN, nombre, autores);
	}
}
