package br.com.code.dao;

import java.util.List;

import br.com.code.domain.TipoSexo;
import br.com.code.domain.Usuario;

public interface UsuarioDao {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario getId(Long id);
	
	List<Usuario> getTodos(); 
	
	List<Usuario> getBySexo(TipoSexo ts); 
}
