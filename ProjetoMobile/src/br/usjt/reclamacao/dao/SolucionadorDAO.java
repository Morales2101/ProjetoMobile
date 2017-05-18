package br.usjt.reclamacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Solucionador;

@Repository
public class SolucionadorDAO {
	@PersistenceContext
	EntityManager managerSolu;
	
	public void criar(Solucionador solucionador){
		managerSolu.persist(solucionador);
	}
	
	public void atualizar(Solucionador solucionador){
		managerSolu.merge(managerSolu.find(Solucionador.class, solucionador.getEmail()));
	}
	
	public void excluir(Reclamacao reclamacao){
		managerSolu.remove(managerSolu.find(Reclamacao.class, reclamacao.getId()));
	}

	public Solucionador selecionar(String i){
		return managerSolu.find(Solucionador.class, i);
	}
	
	@SuppressWarnings("unchecked")
	public List<Solucionador> selecionarTodos(){
		return managerSolu.createQuery("select a from solucionador a").getResultList();
	}
	
	
	public boolean validar(Solucionador solucionador){
		String jpql = "SELECT a FROM Solucionador a WHERE a.email = :email AND a.senha = :senha";
		TypedQuery<Solucionador> query = managerSolu.createQuery(jpql,Solucionador.class);
		System.out.println(solucionador.getEmail());
		query.setParameter("email",solucionador.getEmail());
		query.setParameter("senha", solucionador.getSenha());
		List<Solucionador> lista = query.getResultList();
		boolean flag = (lista != null && lista.size() == 1);
		
		if(flag){
			solucionador.setEmail(lista.get(0).getEmail());
			
		}
		return flag;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Solucionador> listarCadastro(){
		return managerSolu.createQuery("SELECT a FROM Solucionador a").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Solucionador> listarCadastro(String chave){
		String jpql = "select a from Solucionador a where a.adm ";
		Query query = managerSolu.createQuery(jpql);
		query.setParameter("parte", "%"+chave+"%");
		List<Solucionador> result = query.getResultList();
		return result;
	}	
}
