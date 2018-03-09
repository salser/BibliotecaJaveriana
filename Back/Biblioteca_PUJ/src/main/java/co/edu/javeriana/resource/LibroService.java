/**
 * 
 */
package co.edu.javeriana.resource;

import java.text.DateFormat;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.javeriana.Persistencia_Biblioteca.dto.LibroDTO;
import co.edu.javeriana.Persistencia_Biblioteca.fachada.FachadaPersistencia;

/**
 * @author hsalazar
 *
 */
public class LibroService extends ServerResource {

	@Get
	// GEt LIbro by ID
	public String doGet() {
		String id = (String) getRequest().getAttributes().get("id");
		FachadaPersistencia fp = new FachadaPersistencia();
		LibroDTO libro = fp.getLibroById(Integer.parseInt(id));
		

		Gson parser = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();

		if (null != libro) {
			LibroRepresentation representation = new LibroRepresentation();
			representation.setIdLibro(libro.getIdLibro());
			representation.setNombre(libro.getNombre());
			representation.setISBN(libro.getISBN());
			representation.setAutores(libro.getAutores());
			return parser.toJson(representation);
		}else {
			return parser.toJson("error: id " + id);
		}

	}

	@Post
	public String doPost(LibroRepresentation input) {
		Gson parser = new Gson();

		

		return parser.toJson("");
	}

}
