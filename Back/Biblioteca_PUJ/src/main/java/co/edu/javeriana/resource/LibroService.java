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

/**
 * @author hsalazar
 *
 */
public class LibroService extends ServerResource {

	@Get
	// GEt LIbro by ID
	public String doGet() {
		String id = (String) getRequest().getAttributes().get("id");
		Gson parser = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
		LibroRepresentation libro = new LibroRepresentation();
		libro.setNombre("libroname");
		libro.setISBN("asd");
		libro.setAutores("asd,asd");
		libro.setIdLibro(1);
		return parser.toJson(libro);
		/*FachadaPersistencia fp = new FachadaPersistencia();
		LibroDTO libro = fp.getLibroById(Integer.parseInt(id));

		Gson parser = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();

		if (null != libro) {
			return parser.toJson(libro);
		}else {
			return parser.toJson("error");
		}*/

	}

	@Post
	public String doPost(LibroRepresentation input) {
		Gson parser = new Gson();

		

		return parser.toJson("");
	}

}
