package br.usjt.reclamacao.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.SecretariaDAO;
import br.usjt.reclamacao.model.Secretaria;

@Service
public class SecretariaService {
	private SecretariaDAO dao;
	
	@Autowired
	public SecretariaService(SecretariaDAO dao){
		this.dao = dao;
	}
	public List<Secretaria> listarSecretarias() throws IOException{
		return dao.listarSecretarias();
	}
}
