package co.edu.javeriana.Persistencia_Biblioteca.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad que modela un libro
 * @author hsalazar
 *
 */

@Entity
public class LibroBO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idLibro")
	private int idLibro;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ISBN")
	private String ISBN;
	
	@Column(name = "autores")
	private String autores;

	public LibroBO() {
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
}
