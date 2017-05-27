package br.usjt.reclamacao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Usuario;
import br.usjt.reclamacao.service.ReclamacaoService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class ClienteController {
	private ReclamacaoService rs;
	private UsuarioService us;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	public ClienteController(ReclamacaoService rs, UsuarioService us) {
		this.rs = rs;
		this.us = us;
	}

	@RequestMapping("nova_reclamacao")
	public String form(Model model) {

		try {
			List<Reclamacao> reclamacao = rs.listarReclamacoes();
			model.addAttribute("reclamacao", reclamacao);
			return "cliente/reclamacaocriar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("listar_reclamacao")
	public String listagem(Model model, HttpSession session) {
		try {

			Usuario user = (Usuario) session.getAttribute(LoginController.att);
			model.addAttribute("reclamacao", rs.listarReclamacoesPorUsuario(user.getId()));

			return "cliente/reclamacaolistar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("incluir_reclamacao")
	public String inclusao(Reclamacao reclamacao, Model model) {
		try {
			rs.criar(reclamacao);
			rs.getDataHora();
			return "redirect:listar_reclamacao";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("mostrar_reclamacao")
	public String mostrar(Reclamacao reclamacao, Model model) {
		try {
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "cliente/reclamacaomostrar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("alterar_reclamacao")
	public String formAlterar(Model model, Reclamacao reclamacao) {
		try {
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "cliente/reclamacaoalterar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("atualizar_reclamacao")
	public String atualizar(Reclamacao reclamacao, BindingResult result, Model model) {
		try {
			if (!result.hasErrors()) {
				rs.atualizar(reclamacao);
				return "redirect:listar_reclamacao";
			} else {
				model.addAttribute("reclamacao", rs.mostrar(reclamacao));
				return "cliente/reclamacaoalterar";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("remover_reclamacao")
	public String removerslaAdm(Reclamacao reclamacao, Model model) {
		try {
			rs.remover(reclamacao);
			return "redirect:listar_reclamacao";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

}