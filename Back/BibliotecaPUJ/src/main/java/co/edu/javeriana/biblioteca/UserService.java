package co.edu.javeriana.biblioteca;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.biblioteca.modelo.User;
import co.edu.javeriana.biblioteca.modelo.Usuario;
import co.edu.javeriana.biblioteca.modelo.UsuarioRepository;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class UserService {

	@Autowired
	private UsuarioRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/current-user")
    @ResponseBody
    public User currentUserName(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user;
    }
	
	@PreAuthorize("hasRole('ROLE_BIBLIO') OR hasRole('ROLE_USUARIO')")
	@RequestMapping(value = "/user/{username}", produces = "application/json")
	Optional<Usuario> find(@PathVariable("username") String username) {
		Iterable<Usuario> users = repository.findAll();
		Optional<Usuario> thisUser = null;
		for (Usuario user : users) {
			if(user.getUsuario().equals(username)){
				thisUser = repository.findById(user.getIdUsuario());
			}
		}
		return thisUser;
	}
	
	@PreAuthorize("hasRole('ROLE_BIBLIO') OR hasRole('ROLE_USUARIO')")
	@RequestMapping(value = "/userId/{id}", produces = "application/json")
	Optional<Usuario> findById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_BIBLIO') OR hasRole('ROLE_USUARIO')")
	@RequestMapping(value = "/users")
	Iterable<Usuario> findAll() {
		return repository.findAll();
	}
}
