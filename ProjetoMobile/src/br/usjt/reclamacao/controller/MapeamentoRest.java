package br.usjt.reclamacao.controller;

import java.io.IOException;
import java.util.List;

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
	public MapeamentoRest(ReclamacaoService rs) {
		this.rs = rs;
	}

	@RequestMapping(method = RequestMethod.GET, value = "rest/locais")
	public @ResponseBody List<Reclamacao> listagem(String chave) {
		List<Reclamacao> lista = null;
		try {
			if (chave == null || chave.equals("")) {
				lista = rs.listarReclamacoes();
			} else {
				lista = rs.listarReclamacoes(chave);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@RequestMapping(method = RequestMethod.GET, value = "rest/locais/{id}")
	public @ResponseBody Reclamacao listaReclamacao(@PathVariable("id") Long id) {
		Reclamacao reclamacao = null, param;
		try {
			param = new Reclamacao();
			param.setId(id.intValue());
			reclamacao = rs.mostrar(param);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reclamacao;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "rest/locais")
	public ResponseEntity<Reclamacao> criarChamado(@RequestBody Reclamacao reclamacao) {
		try {
			// System.out.println("id = "+reclamacao);
			// System.out.println("titulo = " + reclamacao.getTitulo());
			// System.out.println("descricao = " + reclamacao.getDescricao());
			// System.out.println("cidadao = " + reclamacao.getCidadao());
			// System.out.println("dataHora = " + reclamacao.getDataHora());
			// System.out.println("secretaria = " + reclamacao.getSecretaria());
			// System.out.println("aprovado = " + reclamacao.isAprovado());
			// System.out.println("avaliador = " + reclamacao.getAvaliador());
			// System.out.println("resposta = " + reclamacao.getResposta());
			// System.out.println("fotoAnexa = " + reclamacao.getFotoAnexa());
			rs.criar(reclamacao);
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "rest/locais")
	public ResponseEntity<Reclamacao> alterarLocal(@RequestBody Reclamacao reclamacao) {
		try {
			rs.atualizar(reclamacao);
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
