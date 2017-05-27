package br.usjt.reclamacao.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.ReclamacaoDAO;
import br.usjt.reclamacao.dao.UsuarioDAO;
import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Usuario;

@Service
public class SolucionadorService {
	UsuarioDAO dao;
	ReclamacaoDAO rdao;
	@Autowired
	public SolucionadorService(UsuarioDAO dao, ReclamacaoDAO rdao) {
		this.dao = dao;
		this.rdao = rdao;
	}

	public boolean validar(Usuario usuario) throws IOException{
		return dao.validar(usuario);
	}
	
	public Usuario mostrar(Usuario usuario) throws IOException {
		return dao.selecionar(usuario.getId());
	}
	
	public void criar(Usuario usuario) throws IOException{
		usuario.setTipo(Usuario.SOLUCIONADOR);
		dao.criar(usuario);
	}
	
	
	public void atualizar(Reclamacao reclamacao) throws IOException{
		
		Reclamacao variavel = rdao.selecionar(reclamacao.getId());
		variavel.setResposta(reclamacao.getResposta());
		variavel.setAvaliador(reclamacao.getAvaliador());
		rdao.atualizar(variavel);
	}
	
	
	public List<Usuario>listarCadastro() throws IOException{
		return dao.listarCadastro();
	}
	public List<Usuario> listarCadastro(String chave) throws IOException{
		return dao.listarCadastro(chave);
	}
}
