package co.edu.javeriana.biblioteca.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.javeriana.biblioteca.modelo.User;
import co.edu.javeriana.biblioteca.modelo.Usuario;
import co.edu.javeriana.biblioteca.modelo.UsuarioRepository;


@Service
public class RESTUserDetailsService implements UserDetailsService {
	Map<String, User> users = new HashMap<>();
	@Autowired
	private UsuarioRepository repository;

	public RESTUserDetailsService() {
		super();
		
	}
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO En este método debería recuperarlse la info del usuario desde la base de datos
		Iterable<Usuario> usersAux = repository.findAll();
		Usuario usu = new Usuario();
		usu.setIdUsuario(-1);
		for (Usuario user : usersAux) {
			if(user.getUsuario().equals(username)) {
				usu = user;
			}
		}
		User auth = null;
		
		
		if(-1 != usu.getIdUsuario()) {
			if(usu.getRol().equals("usuario")) {
				auth = new User(usu.getUsuario(), usu.getContrasena(), "ROLE_USUARIO");
			}else {
				auth = new User(usu.getUsuario(), usu.getContrasena(), "ROLE_BIBLIO");
			}
		}
		System.out.println("*** Retrieving user");
		return auth;
	}	

}
