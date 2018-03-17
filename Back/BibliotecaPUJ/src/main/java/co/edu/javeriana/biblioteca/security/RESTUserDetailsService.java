package co.edu.javeriana.biblioteca.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.javeriana.biblioteca.modelo.User;


@Service
public class RESTUserDetailsService implements UserDetailsService {
	Map<String, User> users = new HashMap<>();

	public RESTUserDetailsService() {
		super();
		users.put("user", new User("user", "password", "ROLE_USER"));
		users.put("admin", new User("admin", "password", "ROLE_ADMIN"));

	}
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO En este método debería recuperarlse la info del usuario desde la base de datos
		
		System.out.println("*** Retrieving user");
		return users.get(username);
	}	

}
