package br.usjt.reclamacao.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Administrador;
import br.usjt.reclamacao.model.Usuario;
import br.usjt.reclamacao.service.AdministradorService;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class LoginController {
	private final UsuarioService us;
	private final AdministradorService as;

	public static final String att = "usuarioLogado";

	@Autowired
	public LoginController(UsuarioService us, AdministradorService as) {
		this.us = us;
		this.as = as;
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("fazer_login")
	public String efetuaLogin(Usuario usuario, Administrador Adm, HttpSession session, Model model) {
		Administrador adm = new Administrador();

		try {
			if (us.validar(usuario)) {
				session.setAttribute(att, usuario);
				System.out.println(usuario);
				return "redirect:listar_reclamacao";
			} else if (as.validar(Adm)) {
				session.setAttribute(att, Adm);
				System.out.println(Adm);
				return "redirect:listar_adm";
			}else{
				System.out.println(Adm);
				

			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "erro";
		}

		return "redirect:loginForm";
	}

	@RequestMapping("login_adm")
	public String efetuaLogin(Administrador administrador, HttpSession session, Model model) {

		try {
			if (as.validar(administrador)) {
				session.setAttribute(att, administrador);
				System.out.println(administrador);
				return "redirect:listar_chamados";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "erro";
		}

		return "redirect:loginForm";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}