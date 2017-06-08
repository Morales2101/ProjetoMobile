package br.usjt.reclamacao.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import br.usjt.reclamacao.model.Usuario;

public class UsuarioTest {

	@Test
	public void testUsuario(){
	Usuario uUsuario = new Usuario();
	int sId = 2;
	String sCpf = "11223344";
	String sEmail = "renan@usuario.com";
	String sNome = "renan";
	String sSenha = "teste";
	String sTipo = "cidadao";
	
uUsuario.setId(2);
uUsuario.setCpf("11223344");
uUsuario.setEmail("renan@usuario.com");
uUsuario.setNome("renan");
uUsuario.setSenha("teste");
uUsuario.setTipo("cidadao");


String sFraseget = "Usuario [" + uUsuario.getId() + uUsuario.getCpf() + uUsuario.getEmail() + uUsuario.getNome()
						+ uUsuario.getSenha() + uUsuario.getTipo();
 
String sFraseCompare = "Usuario [" + sId + sCpf+ sEmail + sNome + sSenha + sTipo;
	
assertEquals("Test Usuario", sFraseget, sFraseCompare);

	
	}
}