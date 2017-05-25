package br.usjt.reclamacao.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.SecretariaDAO;
import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Secretaria;
import br.usjt.reclamacao.model.Usuario;

@Service
public class SecretariaService {
	private SecretariaDAO dao;

	@PersistenceContext
	EntityManager manager;

	
	
	@Autowired
	public SecretariaService(SecretariaDAO dao){
		this.dao = dao;
	}
	public List<Secretaria> listarSecretarias() throws IOException{
		return dao.listarSecretarias();
	}

	public void criar(Secretaria secretaria) throws IOException{
		dao.criar(secretaria);
	}
	
	public Secretaria mostrar(Secretaria secretaria) throws IOException {
		return dao.selecionar(secretaria.getId());
	}
}
