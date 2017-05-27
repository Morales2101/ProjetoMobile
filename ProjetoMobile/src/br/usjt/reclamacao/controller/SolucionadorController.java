package br.usjt.reclamacao.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.service.ReclamacaoService;
import br.usjt.reclamacao.service.SolucionadorService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class SolucionadorController {
	private ReclamacaoService rs;
	private UsuarioService us;
	private SolucionadorService ss;
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	public SolucionadorController(ReclamacaoService rs, UsuarioService us, SolucionadorService ss) {
		this.rs = rs;
		this.us = us;
		this.ss = ss;
	}
		
	
	@RequestMapping("listar_solucionador")
	public String listagemsolucionador(Model model, String chave) {
		try {
			if (chave == null || chave.equals("id")) {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
			} else {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
			}
			return "slc/reclamacaolistarslcr";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	
	@RequestMapping("alterar_reclamacaoslc")
	public String formAlterar(Model model, Reclamacao reclamacao) {
		try {
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "slc/reclamacaoalterarslc";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("atualizar_reclamacaoslc")
	public String atualizar(Reclamacao reclamacao, BindingResult result, Model model) {
		try {
			System.out.println(reclamacao.getAvaliador());
			if (!result.hasErrors()) {
				ss.atualizar(reclamacao);
				return "redirect:listar_solucionador";
			} else {
				model.addAttribute("reclamacao", rs.mostrar(reclamacao));
				return "slc/reclamacaoalterarslc";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	
	
}