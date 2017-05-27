package br.usjt.reclamacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.reclamacao.model.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;

//	public UsuarioDAO(EntityManager eManager) {
//		this.manager = eManager;
//	}

	public void criar(Usuario usuario) {
		manager.persist(usuario);
	}

	public void atualizar(Usuario usuario) {
		manager.merge(manager.find(Usuario.class, usuario.getId()));
	}

	public void excluir(Usuario usuario) {
		manager.remove(manager.find(Usuario.class, usuario.getId()));
	}

	public Usuario selecionar(int i) {
		return manager.find(Usuario.class, i);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> selecionarTodos() {
		return manager.createQuery("select u from usuario u").getResultList();
	}

	public boolean validar(Usuario usuario) {
		String jpql = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		List<Usuario> lista = query.getResultList();
		boolean flag = (lista != null && lista.size() == 1);

		if (flag) {
			usuario.setId(lista.get(0).getId());
			usuario.setTipo(lista.get(0).getTipo());
			usuario.setNome(lista.get(0).getTipo());
		}

		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarCadastro() {
		return manager.createQuery("SELECT u FROM Usuario u").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarCadastro(String chave) {
		String jpql = "select u from Usuario u where u.id ";
		Query query = manager.createQuery(jpql);
		query.setParameter("parte", "%" + chave + "%");
		List<Usuario> result = query.getResultList();
		return result;
	}
}