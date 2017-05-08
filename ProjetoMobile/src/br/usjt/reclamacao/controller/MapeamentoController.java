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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Usuario;
import br.usjt.reclamacao.service.ReclamacaoService;
import br.usjt.reclamacao.service.SecretariaService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class MapeamentoController {
	private ReclamacaoService rs;
	private SecretariaService ss;
	private UsuarioService us;
	@Autowired
	private ServletContext servletContext;

	@Autowired
	public MapeamentoController(ReclamacaoService rs,SecretariaService ss, UsuarioService us ) {
		this.rs = rs;
		this.ss = ss;
		this.us = us;
	}

	@RequestMapping("index")
	public String home() {
		return "redirect:loginForm";
	}
	
	@RequestMapping("cadastro")
	public String cadastro() {
		return "local/cadastro";
	}
	
	@RequestMapping("cadastrar")
	public String cadastrar(Model model, Usuario usuario, HttpSession criar) {

		try {
			us.criar(usuario);
			criar.setAttribute(LoginController.att, usuario);
			return "redirect:listar_reclamacao";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}


	@RequestMapping("nova_reclamacao")
	public String form(Model model) {

		try {
			List<Reclamacao> reclamacao = rs.listarReclamacoes();
			model.addAttribute("reclamacao", reclamacao);
			return "local/reclamacaocriar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	@RequestMapping("alterar_reclamacao")
	public String formAlterar(Model model, Reclamacao reclamacao) {
		try {
			model.addAttribute("secretarias", ss.listarSecretarias());
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "local/reclamacaoalterar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	@RequestMapping("atualizar_reclamacao")
	public String atualizar(Reclamacao reclamacao, Model model) {
		System.out.println("ALO " + reclamacao.toString());
		try {
			rs.atualizar(reclamacao);
			// rs.gravarImagem(servletContext, reclamacao, file);
			return "redirect:listar_reclamacao";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("incluir_reclamacao")
	public String inclusao(@Valid Reclamacao reclamacao, BindingResult result, Model model,
			@RequestParam("file") MultipartFile file) {
		try {
			if (result.hasErrors()) {
				List<Reclamacao> reclamacao1 = rs.listarReclamacoes();
				model.addAttribute("reclamacao", reclamacao1);
			}
			rs.criar(reclamacao);
			rs.gravarImagem(servletContext, reclamacao, file);
			return "redirect:listar_reclamacao";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("listar_reclamacao")
	public String listagem(Model model , HttpSession session) {
		try {
			Usuario user = (Usuario) session.getAttribute(LoginController.att);
			System.out.println(user);
			model.addAttribute("reclamacao", rs.listarReclamacoesPorUsuario(user));
			
			return "local/reclamacaolistar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("limpar_reclamacao")
	public String limparReclamacao(Model model) {
		model.addAttribute("reclamacao", null);
		return "local/reclamacaolistar";
	}

	@RequestMapping("mostrar_reclamacao")
	public String mostrar(Reclamacao reclamacao, Model model) {
		try {
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "local/reclamacaomostrar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("remover_reclamacao")
	public String remover(Reclamacao reclamacao, Model model) {
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