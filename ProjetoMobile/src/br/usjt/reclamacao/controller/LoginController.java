package br.usjt.reclamacao.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.reclamacao.model.Usuario;
import br.usjt.reclamacao.service.UsuarioService;

@Transactional
@Controller
public class LoginController {
	private final UsuarioService us;

	public static final String att = "usuarioLogado";

	@Autowired
	public LoginController(UsuarioService us) {
		this.us = us;
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("fazer_login")
	public String efetuaLogin(Usuario usuario, HttpSession session, Model model) {
		try {
			if (us.validar(usuario)) {
				session.setAttribute(att, usuario);
				System.out.println(usuario);
				
				if( usuario.getTipo().equals(Usuario.CIDADAO) ){
					return "redirect:listar_reclamacao";
				}else{
					return "redirect:listar_adm";
				}
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