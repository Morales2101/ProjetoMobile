package br.usjt.reclamacao.controller;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.service.ReclamacaoService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class MapeamentoController {
	private ReclamacaoService rs;
	private UsuarioService us;
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	public MapeamentoController(ReclamacaoService rs, UsuarioService us) {
		this.rs = rs;
		this.us = us;
	}
	
	@RequestMapping("cadastrosolucionador")
	public String cadastrosolucionador() {
		return "adm/cadastrosolucionador";
	}
	
	@RequestMapping("cadastrouser")
	public String cadastro() {
		return "cadastrouser";
	}

	@RequestMapping("index")
	public String home() {
		return "redirect:loginForm";
	}
}