package br.usjt.reclamacao.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import br.usjt.reclamacao.model.Secretaria;

public class SecretariaTest {

	@Test
	public void testSecretaria() {
		Secretaria ss = new Secretaria ();
		
		int sId=1;
		String departamento = "RH";
		int sla = 3;
		
		ss.setId(1);
		ss.setDepartamento("RH");
		ss.setSla(3); 
		
		String fraseGet = " Secretaria [ " + ss.getId() + ss.getDepartamento() + ss.getSla();
		String fraseCompara = " Secretaria [ " + sId + departamento + sla;
		
		assertEquals("TestSecretaria", fraseGet,fraseCompara);
		
		
	}

}
