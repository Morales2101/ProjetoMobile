package br.usjt.reclamacao.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.UsuarioDAO;
import br.usjt.reclamacao.model.Usuario;

@Service
public class UsuarioService {
	UsuarioDAO dao;
	@Autowired
	public UsuarioService(UsuarioDAO dao) {
		this.dao = dao;
	}

	public boolean validar(Usuario usuario) throws IOException{
		return dao.validar(usuario);
	}
	
	public Usuario mostrar(Usuario usuario) throws IOException {
		return dao.selecionar(usuario.getId());
	}
	
	public void criar(Usuario usuario) throws IOException{
		usuario.setTipo(Usuario.CIDADAO);
		dao.criar(usuario);
	}
	
	public void criarSolucionador(Usuario usuario) throws IOException{
		usuario.setTipo(Usuario.SOLUCIONADOR);
		dao.criar(usuario);
	}
	
	public List<Usuario>listarCadastro() throws IOException{
		return dao.listarCadastro();
	}
	public List<Usuario> listarCadastro(String chave) throws IOException{
		return dao.listarCadastro(chave);
	}
}
