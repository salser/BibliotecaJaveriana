package co.edu.javeriana.biblioteca;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.biblioteca.modelo.Libro;
import co.edu.javeriana.biblioteca.modelo.LibroRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LibroService {

	@Autowired
	private LibroRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PreAuthorize("hasRole('ROLE_USUARIO') or hasRole('ROLE_BIBLIO') ") 
	@RequestMapping("/libros")
	Iterable<Libro> findAll() {
		return repository.findAll();
	}

	@RequestMapping("/libros/{id}")
	Optional<Libro> find(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@RequestMapping("/libros/eliminar/{id}")
	void deleteById(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

	@RequestMapping("/libros/actualizar/{id}/{nombre}/{isbn}/{autores}")
	void updateById(@PathVariable("id") Long id, @PathVariable("nombre") String nombre,
			@PathVariable("isbn") String isbn, @PathVariable("autores") String autores) {
		Libro libro = repository.findById(id).get();
		libro.setNombre(nombre);
		libro.setIsbn(isbn);
		libro.setAutores(autores);
		repository.save(libro);
	}
	
	@RequestMapping("/libros/insertar/{nombre}/{isbn}/{autores}")
	void insert(@PathVariable("nombre") String nombre,
			@PathVariable("isbn") String isbn, @PathVariable("autores") String autores) {
		Libro libro = new Libro();
		libro.setNombre(nombre);
		libro.setIsbn(isbn);
		libro.setAutores(autores);
		repository.save(libro);
	}
}
