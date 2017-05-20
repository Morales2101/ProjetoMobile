package br.usjt.reclamacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.usjt.reclamacao.model.Secretaria;

@Repository
public class SecretariaDAO {
	
	@PersistenceContext
	EntityManager manager;

	public void criar(Secretaria secretaria){
		manager.persist(secretaria);
	}
	
	public void atualizar(Secretaria secretaria){
		manager.merge(manager.find(Secretaria.class, secretaria.getId()));
	}
	
	public void excluir(Secretaria secretaria){
		manager.remove(manager.find(Secretaria.class, secretaria.getId()));
	}
	
	public Secretaria selecionar(int id){
		return manager.find(Secretaria.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Secretaria> listarSecretarias(){
		return manager.createQuery("SELECT s from Secretaria s").getResultList();
	}

}