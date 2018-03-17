package co.edu.javeriana.biblioteca;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/public")
public class PublicTestService {
	@RequestMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{'value': 'ok'}";
	}
}
