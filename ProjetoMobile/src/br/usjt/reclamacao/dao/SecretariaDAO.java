package br.usjt.reclamacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Secretaria;
import br.usjt.reclamacao.model.Usuario;

@Repository
public class SecretariaDAO {
	@PersistenceContext
	EntityManager manager;

	public void criar(Secretaria secretaria) {
		manager.persist(secretaria);
	}

	public void atualizar(Secretaria secretaria) {
		manager.merge(manager.find(Secretaria.class, secretaria.getId()));
	}

	public void excluir(Secretaria secretaria) {
		manager.remove(manager.find(Secretaria.class, secretaria.getId()));
	}

	public Secretaria selecionar(int i) {
		return manager.find(Secretaria.class, i);
	}

	@SuppressWarnings("unchecked")
	public List<Secretaria> selecionarTodos() {
		return manager.createQuery("select s from Secretaria s").getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Secretaria> listarFila(){
		return manager.createQuery("SELECT s FROM Secretaria r order by s.sla").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Secretaria> listarCadastro() {
		return manager.createQuery("SELECT s FROM Secretaria s").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Secretaria> listarCadastro(String chave) {
		String jpql = "select s from Secretaria s where s.id ";
		Query query = manager.createQuery(jpql);
		query.setParameter("parte", "%" + chave + "%");
		List<Secretaria> result = query.getResultList();
		return result;
	}
}