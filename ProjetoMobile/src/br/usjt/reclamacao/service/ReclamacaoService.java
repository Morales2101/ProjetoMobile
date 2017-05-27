package br.usjt.reclamacao.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.ReclamacaoDAO;
import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Usuario;


@Service
public class ReclamacaoService{
	private ReclamacaoDAO reclamacaoDAO;
	private UsuarioService usuarioService; 
	
	
	@Autowired
	public ReclamacaoService(ReclamacaoDAO reclamacaoDAO , UsuarioService usuarioService){
		this.reclamacaoDAO = reclamacaoDAO;
		this.usuarioService = usuarioService;
	}
	
	public void criar(Reclamacao reclamacao) throws IOException{
		System.out.println(" ID DO CIDADAO RECLAMACAO: " + reclamacao.getCidadao());
		Usuario u = usuarioService.mostrar(reclamacao.getCidadao());
		reclamacao.setCidadao(u);
		reclamacaoDAO.criar(reclamacao);
	}

	public void remover(Reclamacao reclamacao) throws IOException{
		reclamacaoDAO.excluir(reclamacao);
	}
	
	public List<Reclamacao> listarReclamacoesPorUsuario(int id) throws IOException {
		System.out.println(id);
		return this.reclamacaoDAO.listarReclamacoesPorUsuario(id);
	}
	
	public void atualizar(Reclamacao reclamacao) throws IOException{
		
		Reclamacao variavel = reclamacaoDAO.selecionar(reclamacao.getId());
		variavel.setTitulo(reclamacao.getTitulo());
		variavel.setDescricao(reclamacao.getDescricao());
		variavel.setAprovado(reclamacao.isAprovado());
		reclamacaoDAO.atualizar(variavel);
	}
	public List<Reclamacao> listarReclamacoes() throws IOException{
		return reclamacaoDAO.listarReclamacoes();
	}
	public List<Reclamacao> listarReclamacoes(String chave) throws IOException{
		return reclamacaoDAO.listarReclamacoes(chave);
	}
	
	public List<Reclamacao> listarReclamacoesFilhas(String reclamaPai) throws IOException{
		return reclamacaoDAO.listarReclamacoesFilhas(reclamaPai);
	}
	
	public Reclamacao mostrar(Reclamacao reclamacao) throws IOException {
		return reclamacaoDAO.selecionar(reclamacao.getId());
	}
	
	public static String getDataHora(){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dataHora = Calendar.getInstance().getTime();
		return df.format(dataHora);
	}
	
}