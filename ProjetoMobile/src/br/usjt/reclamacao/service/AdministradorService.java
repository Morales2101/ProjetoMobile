package br.usjt.reclamacao.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.AdministradorDAO;
import br.usjt.reclamacao.model.Administrador;

@Service
public class AdministradorService {
	AdministradorDAO dao;
	
	@Autowired
	public AdministradorService(AdministradorDAO dao){
		this.dao = dao;
	}

	public boolean validar(Administrador administrador) throws IOException{
		return dao.validar(administrador);
	}
	
	public Administrador mostrar(Administrador administrador) throws IOException{
		return dao.selecionar(administrador.getAdm());
	}
}
