package co.edu.javeriana.restApp;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import co.edu.javeriana.resource.LibroService;;

public class RestletApplication extends Application {
		
	public synchronized Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/libro/{id}", LibroService.class);
		return router;
	}
}