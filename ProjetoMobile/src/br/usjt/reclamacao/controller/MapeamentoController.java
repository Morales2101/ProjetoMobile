package br.usjt.reclamacao.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Secretaria;
import br.usjt.reclamacao.service.ReclamacaoService;
import br.usjt.reclamacao.service.SecretariaService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class MapeamentoController {
	private ReclamacaoService rs;
	private UsuarioService us;
	private SecretariaService secs;
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	public MapeamentoController(ReclamacaoService rs, UsuarioService us, SecretariaService secs) {
		this.rs = rs;
		this.us = us;
		this.secs = secs;
	}
	
	@RequestMapping("cadastrosolucionador")
	public String cadastrosolucionador() {
		return "adm/cadastrosolucionador";
	}
	
	@RequestMapping("cadastrouser")
	public String cadastro(Secretaria secretaria, Model model) {
		try{
		model.addAttribute("secretaria", secs.listarSecretaria());
		return "cadastrouser";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("index")
	public String home() {
		return "redirect:loginForm";
	}
}