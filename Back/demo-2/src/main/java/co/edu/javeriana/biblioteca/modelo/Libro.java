package co.edu.javeriana.biblioteca.modelo;

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
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idLibro")
	private Long idLibro;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "autores")
	private String autores;
	
	/*@OneToMany(mappedBy = "libro")
	private List<Prestamo> prestamos;*/

	public Libro() {
	}


	public Long getIdLibro() {
		return idLibro;
	}


	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String iSBN) {
		this.isbn = iSBN;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	/*public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}*/
}