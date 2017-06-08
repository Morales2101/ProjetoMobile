package br.usjt.reclamacao.junit;



import static org.junit.Assert.*;

import org.junit.Test;

import br.usjt.reclamacao.model.Reclamacao;

public class ReclamacaoTest {

	@Test
	public void ReclamaTest() {
		Reclamacao reclama = new Reclamacao();

		int rId = 1;
		boolean rAprova = true;
		String rTitulo = "Chamado";
		String rDescricao = "Impressora";

		reclama.setId(1);
		reclama.setAprovado(true);
		reclama.setTitulo("Chamado");
		reclama.setDescricao("Impressora");

		String fraseGet = "Reclamacao [" + reclama.getId() + reclama.isAprovado() + reclama.getTitulo()
				+ reclama.getDescricao();
		
		String fraseCompara = "Reclamacao [" + rId + rAprova + rTitulo + rDescricao;
		
assertEquals("TestReclamacao ", fraseGet, fraseCompara);

	}

}
