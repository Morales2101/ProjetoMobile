package br.usjt.reclamacao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.service.ReclamacaoService;

@RestController
public class MapeamentoRest {
	private ReclamacaoService rs;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	public MapeamentoRest(ReclamacaoService rs) {
		this.rs = rs;
	}

	@RequestMapping(method=RequestMethod.GET, value="rest/locais")
	public @ResponseBody List<Reclamacao> listagem(String chave) {
		List<Reclamacao> lista = null;
		try{
			if(chave == null || chave.equals("")){
				lista = rs.listarReclamacoes();
			} else {
				lista = rs.listarReclamacoes(chave);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/locais/{id}")
	public @ResponseBody Reclamacao listaReclamacao(@PathVariable("id") Long id) {
		Reclamacao local = null, param;
		try{
			param = new Reclamacao();
			param.setId(id.intValue());
			local = rs.mostrar(param);
		} catch(IOException e){
			e.printStackTrace();
		}
		return local;
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="rest/locais")
	public ResponseEntity<Reclamacao> criarReclamacao(@RequestBody Reclamacao reclamacao){
		try{
			
			rs.criar(reclamacao);
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.OK);
		} catch(IOException e){
			e.printStackTrace();
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="rest/locais/{id}")
	public void excluirReclamacao( @PathVariable("id") Long id ){
		Reclamacao reclamacao = new Reclamacao();
		reclamacao.setId( id.intValue() );
		try {
			rs.remover(servletContext,reclamacao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="rest/locais")
	public ResponseEntity<Reclamacao> alterarLocal( @RequestBody Reclamacao reclamacao){
		try{
			rs.atualizar(reclamacao);
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.OK);
		} catch(IOException e){
			e.printStackTrace();
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}