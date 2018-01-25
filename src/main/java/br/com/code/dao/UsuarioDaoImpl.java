package br.com.code.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.code.domain.TipoSexo;
import br.com.code.domain.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public void salvar(Usuario usuario) {
		ur.save(usuario);
		/*entityManager.persist(usuario);
		entityManager.flush();
		*/
	}

	@Override
	public void editar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public void excluir(Long id) {
		entityManager.remove(entityManager.getReference(Usuario.class, id));
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario getId(Long id) {
		return entityManager.createQuery(
				"from Usuario u where u.id= :id",Usuario.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getTodos() {
		String jpql = "from Usuario u";
		return entityManager.createQuery(jpql,Usuario.class).getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getBySexo(TipoSexo ts) {
		return entityManager.createQuery("from Usuario u where u.sexo = :sexo",Usuario.class)
		.setParameter("sexo", ts).getResultList();
	}
	

}
