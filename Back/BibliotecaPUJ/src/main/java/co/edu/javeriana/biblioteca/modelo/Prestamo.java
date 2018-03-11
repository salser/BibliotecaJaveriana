package co.edu.javeriana.biblioteca.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idPrestamo")
	private long idPrestamo;
	
	@Column(name = "fechaPrestamo")
	private Date fechaPrestamo;
	
	@Column(name = "fechaVencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "fechaDevolucion")
	private Date fechaDevolucion;
	
	@ManyToOne
	private Libro libro;
	
	@ManyToOne
	private Usuario usuario;
	
	

	public Prestamo() {
		super();
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
