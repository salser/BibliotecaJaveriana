/**
 * 
 */
package co.edu.javeriana.biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	

	@RequestMapping("/prestamos")
	Iterable<Prestamo> findAll() {
		return prestamoRepository.findAll();
	}

	@RequestMapping("/prestamos/{id}")
	Optional<Prestamo> find(@PathVariable("id") Long id) {
		return prestamoRepository.findById(id);
	}

	@RequestMapping("/prestamos/devolucion/{id}/{fechadevolucion}")
	void updateById(@PathVariable("id") Long id, @PathVariable("fechadevolucion") String fechaDevolucion) {
		Prestamo prestamo = prestamoRepository.findById(id).get();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date fechaDevDate;
		try {
			fechaDevDate = sdf.parse(fechaDevolucion);
			prestamo.setFechaDevolucion(fechaDevDate);
			prestamoRepository.save(prestamo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@RequestMapping("/prestamos/insertar/{idLibro}/{idUsuario}")
	void insert(@PathVariable("idLibro") Long idLibro, @PathVariable("idUsuario") Long idUsuario) {
		Libro libro = libroRepository.findById(idLibro).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
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
		prestamo.setUsuario(usuario);
		prestamo.setFechaVencimiento(fechaVencimiento);
		prestamo.setFechaDevolucion(fechaDevolución);
		
		prestamoRepository.save(prestamo);
		
	}
}
