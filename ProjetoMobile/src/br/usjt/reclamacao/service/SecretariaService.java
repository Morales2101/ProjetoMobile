package br.usjt.reclamacao.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.SecretariaDAO;
import br.usjt.reclamacao.model.Secretaria;
import br.usjt.reclamacao.model.Usuario;

@Service
public class SecretariaService {
	SecretariaDAO dao;
	@Autowired
	public SecretariaService(SecretariaDAO dao) {
		this.dao = dao;
	}
	
	public Secretaria mostrar(Secretaria secretaria) throws IOException {
		return dao.selecionar(secretaria.getId());
	}
	
	public void criar(Secretaria secretaria) throws IOException{
		dao.criar(secretaria);
	}
	
	public List<Secretaria>listarSecretaria() throws IOException{
		return dao.listarCadastro();
	}
	public List<Secretaria> listarSecretaria(String chave) throws IOException{
		return dao.listarCadastro(chave);
	}
}
