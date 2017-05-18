package br.usjt.reclamacao.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.usjt.reclamacao.model.Reclamacao;

public class ReclamacaoTest {


	
	@Test
	public void testReclama() {
		
		Reclamacao reclamacao = new Reclamacao();
		
		
		long idTestReclamacao = 1L;
		String titulo = "TestTitulo";
		String descricao = "abcd";
	//	Date datahora = "yyyy/mm/dd hh:MM";
		String resposta = "resp";
		
		
	reclamacao.setId(1);
	reclamacao.setTitulo("TestTitulo");
	reclamacao.setDescricao("abcd");
//	reclamacao.setDataHora("yyyy/mm/dd");
	reclamacao.setResposta("resp");
		
	

	
	String sEx1 = "ID :" + idTestReclamacao + " titulo : " + titulo + " descricao :" + descricao + "resposta"+ resposta;
	String sVolta1 = "ID :" + reclamacao.getId() + " titulo : " + reclamacao.getTitulo() + " descricao :" + reclamacao.getDescricao() + "resposta"+ reclamacao.getResposta();
 	
	Assert.assertEquals("Teste :", sEx1, sVolta1);
	}

}
