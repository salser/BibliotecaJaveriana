package co.edu.javeriana.Persistencia_Biblioteca.dto;

import co.edu.javeriana.Persistencia_Biblioteca.bo.LibroBO;

public class LibroDTO {

	private int idLibro;
	private String nombre;
	private String ISBN;
	private String autores;

	public LibroDTO() {
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	public void cloneFromBO(Object obj) {
		if(obj instanceof LibroBO) {
			LibroBO bo = (LibroBO) obj;
			this.nombre = bo.getNombre();
			this.ISBN = bo.getISBN();
			this.autores = bo.getAutores();
			this.idLibro = bo.getIdLibro();
		}
	}
}
