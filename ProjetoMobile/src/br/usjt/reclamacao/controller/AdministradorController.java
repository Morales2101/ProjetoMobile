package br.usjt.reclamacao.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Administrador;
import br.usjt.reclamacao.service.AdministradorService;

public class AdministradorController {
	private final AdministradorService as;

	public static final String att = "usuarioLogado";

	@Autowired
	public AdministradorController(AdministradorService as) {
		this.as = as;
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("login_adm")
	public String efetuaLoginAdm(Administrador administrador, HttpSession session, Model model) {
		try {
			if (as.validar(administrador)) {
				session.setAttribute(att, administrador);
				System.out.println(administrador);
				return "redirect:listar_adm";
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