package br.usjt.reclamacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.reclamacao.model.Administrador;

@Repository
public class AdministradorDAO {
	@PersistenceContext
	EntityManager managerAdm;
	
	public void criar(Administrador administrador){
		managerAdm.persist(administrador);
	}
	
	public void atualizar(Administrador administrador){
		managerAdm.merge(managerAdm.find(Administrador.class, administrador.getAdm()));
	}
	
	public void excluir(Administrador administrador){
		managerAdm.remove(managerAdm.find(Administrador.class, administrador.getAdm()));
	}

	public Administrador selecionar(String i){
		return managerAdm.find(Administrador.class, i);
	}
	
	@SuppressWarnings("unchecked")
	public List<Administrador> selecionarTodos(){
		return managerAdm.createQuery("select a from administrador a").getResultList();
	}
	
	
	public boolean validar(Administrador administrador){
		String jpql = "SELECT a FROM Administrador a WHERE a.adm = :adm AND a.senha = :senha";
		TypedQuery<Administrador> query = managerAdm.createQuery(jpql,Administrador.class);
		query.setParameter("adm", administrador.getAdm());
		query.setParameter("senha", administrador.getSenha());
		List<Administrador> lista = query.getResultList();
		boolean flag = (lista != null && lista.size() == 1);
		
		if(flag){
			administrador.setAdm(lista.get(0).getAdm());
			
		}
		return flag;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Administrador> listarCadastro(){
		return managerAdm.createQuery("SELECT a FROM Administrador a").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> listarCadastro(String chave){
		String jpql = "select a from Administrador a where a.adm ";
		Query query = managerAdm.createQuery(jpql);
		query.setParameter("parte", "%"+chave+"%");
		List<Administrador> result = query.getResultList();
		return result;
	}	
}
