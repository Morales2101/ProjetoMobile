package br.usjt.reclamacao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Secretaria;
import br.usjt.reclamacao.model.Usuario;
import br.usjt.reclamacao.service.ReclamacaoService;
import br.usjt.reclamacao.service.SecretariaService;
import br.usjt.reclamacao.service.SolucionadorService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class AdmController {
	private ReclamacaoService rs;
	private UsuarioService us;
	private SolucionadorService ss;
	private SecretariaService secs;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	public AdmController(ReclamacaoService rs, UsuarioService us, SolucionadorService ss, SecretariaService secs) {
		this.rs = rs;
		this.us = us;
		this.ss = ss;
		this.secs = secs;
	}

	@RequestMapping("listar_adm")
	public String listagemadm(Model model, String chave) {
		try {
			if (chave == null || chave.equals("id")) {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
			} else {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
			}
			return "adm/reclamacaolistaradm";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("listar_sla")
	public String listagemsla(Model model, String chave) {
		try {
			if (chave == null || chave.equals("id")) {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
				model.addAttribute("usuario", us.listarCadastro());
				model.addAttribute("secretaria", secs.listarSecretaria());
			} else {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
				model.addAttribute("usuario", us.listarCadastro());
				model.addAttribute("secretaria", secs.listarSecretaria());
			}
			return "adm/reclamacaosla";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("mostrar_reclamacaoadm")
	public String mostrar(Reclamacao reclamacao, Model model) {
		try {
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "adm/reclamacaomostraradm";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	
	@RequestMapping("alterar_reclamacaoadm")
	public String formAlterar(Model model, Reclamacao reclamacao) {
		try {
			model.addAttribute("reclamacao", rs.mostrar(reclamacao));
			return "adm/reclamacaoalteraradm";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("atualizar_reclamacaoadm")
	public String atualizar(Reclamacao reclamacao, BindingResult result, Model model) {
		try {
			if (!result.hasErrors()) {
				rs.atualizar(reclamacao);
				return "redirect:listar_sla";
			} else {
				model.addAttribute("reclamacao", rs.mostrar(reclamacao));
				return "adm/reclamacaoalteraradm";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("removersla_adm")
	public String removerslaAdm(Reclamacao reclamacao, Model model) {
		try {
			rs.remover(reclamacao);
			return "redirect:listar_sla";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	
	@RequestMapping("cadastrarsolucionador")
	public String cadastrar(Model model, Usuario usuario, HttpSession criar) {

		try {
			ss.criar(usuario);
			criar.setAttribute(LoginController.att, usuario);
			return "redirect:listar_adm";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	
	@RequestMapping("novo_departamento")
	public String form(Model model) {

		try {
			List<Secretaria> secretaria = secs.listarSecretaria();
			model.addAttribute("secretaria", secretaria);
			return "adm/departamentocriar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	@RequestMapping("incluir_departamento")
	public String inclusao(Secretaria secretaria, Model model) {
		try {
			secs.criar(secretaria);
			return "redirect:listar_adm";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	@RequestMapping("listar_fila")
	public String listagemfila(Model model, String chave) {
		try {
			if (chave == null || chave.equals("id")) {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
			} else {
				model.addAttribute("reclamacao", rs.listarReclamacoes());
			}
			return "adm/reclamacaolistarfila";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

}