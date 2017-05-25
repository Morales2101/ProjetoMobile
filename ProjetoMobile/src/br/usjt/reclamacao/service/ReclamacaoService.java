package br.usjt.reclamacao.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.reclamacao.dao.ReclamacaoDAO;
import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Secretaria;
import br.usjt.reclamacao.model.Usuario;


@Service
public class ReclamacaoService{
	private ReclamacaoDAO reclamacaoDAO;
	private UsuarioService usuarioService;
	private SecretariaService secretariaService;
	
	
	@Autowired
	public ReclamacaoService(ReclamacaoDAO reclamacaoDAO , UsuarioService usuarioService, SecretariaService secretariaService){
		this.reclamacaoDAO = reclamacaoDAO;
		this.usuarioService = usuarioService;
		this.secretariaService = secretariaService;
	}
	
	public void criar(Reclamacao reclamacao) throws IOException{
		Usuario u = usuarioService.mostrar(reclamacao.getCidadao());
		reclamacao.setCidadao(u);
		reclamacaoDAO.criar(reclamacao);
	}

	public void remover(ServletContext servletContext, Reclamacao reclamacao) throws IOException{
		reclamacaoDAO.excluir(reclamacao);
	}
	
	public List<Reclamacao> listarReclamacoesPorUsuario(int id) throws IOException {
		System.out.println(id);
		return this.reclamacaoDAO.listarReclamacoesPorUsuario(id);
	}
	
	public void atualizar(Reclamacao reclamacao) throws IOException{
		System.out.println("Fechou aqui? " + reclamacao);
		
		Reclamacao variavel = reclamacaoDAO.selecionar(reclamacao.getId());
		variavel.setTitulo(reclamacao.getTitulo());
		variavel.setSecretaria(reclamacao.getSecretaria());
		variavel.setDescricao(reclamacao.getDescricao());
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
	
	public void gravarImagem(ServletContext servletContext, Reclamacao reclamacao, MultipartFile file)
			throws IOException {
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file
					.getBytes()));
			String path = servletContext.getRealPath(servletContext	.getContextPath());
			path = path.substring(0, path.lastIndexOf('/'));
			String nomeArquivo = "img"+reclamacao.getId()+".jpg";
			reclamacao.setFotoAnexa(nomeArquivo);
			atualizar(reclamacao);
			File destination = new File(path + File.separatorChar + "img" + File.separatorChar + nomeArquivo);
			if(destination.exists()){
				destination.delete();
			}
			ImageIO.write(src, "jpg", destination);
		}
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