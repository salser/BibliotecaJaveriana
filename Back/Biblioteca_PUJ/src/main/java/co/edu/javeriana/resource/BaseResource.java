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
public class BaseResource extends ServerResource {
	
	@Get
	public String doGet() {
		Gson parser = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
		
		return parser.toJson("");
	}

	@Post
	public String doPost(LibroRepresentation input) {
		Gson parser = new Gson();

		String nombre = input.getNombre();

		return parser.toJson("");
	}


}
