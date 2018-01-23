package br.com.code.ws;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.code.domain.Usuario;

@RestController
@RequestMapping("/ws/serviceWs")
public class ServiceWs {

	@PostMapping(path="/cad")
	public void cadastrarUsuario(@RequestBody Usuario usuario) {
		System.out.println(usuario);
	}
}
