package co.edu.javeriana.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.biblioteca.modelo.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LibroService {

	@Autowired
	private LibroRepository repository;

	@RequestMapping("/libros")
	Iterable<Libro> findAll() {
		return repository.findAll();
	}

	@RequestMapping("/libros/{id}")
	Optional<Libro> find(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
}
