package br.usjt.reclamacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.reclamacao.model.Reclamacao;

@Repository
public class ReclamacaoDAO {
	
	@PersistenceContext
	EntityManager manager;

	public void criar(Reclamacao reclamacao){
		manager.persist(reclamacao);
	}
	
	public void atualizar(Reclamacao reclamacao){
		manager.merge(reclamacao);
	}
		
	public void excluir(Reclamacao reclamacao){
		manager.remove(manager.find(Reclamacao.class, reclamacao.getId()));
	}
	
	public Reclamacao selecionar(int id){
		return manager.find(Reclamacao.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reclamacao> listarReclamacoes(){
		return manager.createQuery("SELECT r FROM Reclamacao r").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Reclamacao> listarReclamacoes(String chave){
		String jpql = "select r from Reclamacao r where r.titulo like :parte";
		Query query = manager.createQuery(jpql);
		query.setParameter("parte", "%"+chave+"%");
		List<Reclamacao> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reclamacao> listarReclamacoesFilhas(String reclamaPai){
		String textoQuery = "SELECT r FROM Reclamacao r WHERE reclamaPai = :idReclama";
		Query query = manager.createQuery(textoQuery);
		query.setParameter("idReclama", "%"+reclamaPai+"%");
		List<Reclamacao> resultado = query.getResultList();
		return resultado;
	}
	
	public List<Reclamacao> listarReclamacoesPorUsuario(int id){
		String textoQuery = "SELECT r FROM Reclamacao r WHERE r.cidadao.id = :cidadao";
		TypedQuery<Reclamacao> query = manager.createQuery(textoQuery,Reclamacao.class);
		query.setParameter("cidadao", id );
		List<Reclamacao> resultado = query.getResultList();
		return resultado;
	}
	
	

}