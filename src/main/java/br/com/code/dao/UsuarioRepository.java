package br.com.code.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import br.com.code.domain.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
	
}
