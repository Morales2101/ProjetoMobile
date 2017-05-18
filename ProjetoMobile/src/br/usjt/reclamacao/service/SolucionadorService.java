package br.usjt.reclamacao.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.reclamacao.dao.SolucionadorDAO;
import br.usjt.reclamacao.model.Reclamacao;
import br.usjt.reclamacao.model.Solucionador;

@Service
public class SolucionadorService {
	SolucionadorDAO dao;
	
	@Autowired
	public SolucionadorService(SolucionadorDAO dao){
		this.dao = dao;
	}

	public boolean validar(Solucionador solucionador) throws IOException{
		return dao.validar(solucionador);
	}
	
	public Solucionador mostrar(Solucionador solucionador) throws IOException{
		return dao.selecionar(solucionador.getEmail());
	}

	public void remover(Reclamacao reclamacao) throws IOException {
			dao.excluir(reclamacao);
		}
	}

