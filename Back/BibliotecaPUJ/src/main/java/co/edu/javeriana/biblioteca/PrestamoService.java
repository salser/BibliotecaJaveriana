/**
 * 
 */
package co.edu.javeriana.biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.biblioteca.modelo.Libro;
import co.edu.javeriana.biblioteca.modelo.LibroRepository;
import co.edu.javeriana.biblioteca.modelo.Prestamo;
import co.edu.javeriana.biblioteca.modelo.PrestamosRepository;
import co.edu.javeriana.biblioteca.modelo.Usuario;
import co.edu.javeriana.biblioteca.modelo.UsuarioRepository;

/**
 * @author hsalazar
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrestamoService {

	@Autowired
	private PrestamosRepository prestamoRepository;

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PreAuthorize("hasRole('ROLE_USUARIO')")
	@RequestMapping("/prestamos")
	Iterable<Prestamo> findAll() {
		return prestamoRepository.findAll();
	}

	@PreAuthorize("hasRole('ROLE_USUARIO')")
	@RequestMapping("/prestamos/{id}")
	Optional<Prestamo> find(@PathVariable("id") Long id) {
		return prestamoRepository.findById(id);
	}

	@PreAuthorize("hasRole('ROLE_USUARIO')")
	@RequestMapping("/prestamos/devolucion/{id}/")
	void updateById(@PathVariable("id") Long id) {
		Prestamo prestamo = prestamoRepository.findById(id).get();;
		prestamo.setFechaDevolucion(Calendar.getInstance().getTime());
		prestamoRepository.save(prestamo);

	}

	@PreAuthorize("hasRole('ROLE_USUARIO')")
	@RequestMapping("/prestamos/insertar/{idLibro}/{idUsuario}")
	void insert(@PathVariable("idLibro") Long idLibro, @PathVariable("idUsuario") String usuario) {
		Libro libro = libroRepository.findById(idLibro).get();
		Iterable<Usuario> users = usuarioRepository.findAll();
		Usuario usu = null;
		for (Usuario user : users) {
			if (user.getUsuario().equals(usuario)) {
				usu = user;
			}
		}

		if (null != usu) {
			Date actual = Calendar.getInstance().getTime();
			Date fechaVencimiento = actual;
			Calendar calendarVenc = Calendar.getInstance();
			calendarVenc.setTime(fechaVencimiento);
			calendarVenc.add(Calendar.DATE, 7);
			fechaVencimiento = calendarVenc.getTime();
			Date fechaPrestamo = actual;
			Date fechaDevolución = null;

			Prestamo prestamo = new Prestamo();
			prestamo.setFechaPrestamo(fechaPrestamo);
			prestamo.setLibro(libro);
			prestamo.setUsuario(usu);
			prestamo.setFechaVencimiento(fechaVencimiento);
			prestamo.setFechaDevolucion(fechaDevolución);

			prestamoRepository.save(prestamo);

		}

	}
}
