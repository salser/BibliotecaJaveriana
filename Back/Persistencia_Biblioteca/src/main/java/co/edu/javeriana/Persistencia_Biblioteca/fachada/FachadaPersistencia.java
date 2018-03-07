package co.edu.javeriana.Persistencia_Biblioteca.fachada;

import co.edu.javeriana.Persistencia_Biblioteca.bo.LibroBO;
import co.edu.javeriana.Persistencia_Biblioteca.dao.LibroDAO;
import co.edu.javeriana.Persistencia_Biblioteca.dto.LibroDTO;

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
	
	public LibroDTO getLibroById(int id) {
		LibroBO bo = LibroDAO.getInstance().getLibroById(id);
		LibroDTO dto = null;
		if(null != bo) {
			dto = new LibroDTO();
			dto.cloneFromBO(bo);
		}
		return dto;
	}
}
