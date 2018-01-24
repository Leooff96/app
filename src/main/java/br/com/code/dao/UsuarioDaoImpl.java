package br.com.code.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.code.domain.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		entityManager.refresh(usuario);
	}

	@Override
	public void excluir(Long id) {
		
	}

	@Override
	public Usuario getId(Long id) {
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getTodos() {
		String jpql = "from Usuario u";
		return entityManager.createQuery(jpql,Usuario.class).getResultList();
	}
	

}
