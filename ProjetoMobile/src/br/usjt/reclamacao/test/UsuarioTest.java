package br.usjt.reclamacao.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.usjt.reclamacao.model.Usuario;
import br.usjt.reclamacao.service.UsuarioService;




public class UsuarioTest {

		
		@Test
		public void listar() {

			Usuario usuario = new Usuario();
			
		long idTest = 1L;
		String nomeTest = "Test";
		String cpf = "1234";
		String email = "Test@test";
		String senha = "1234";
		String cargo = "Cargo";
			
		usuario.setId(1);
		usuario.setNome("Test");
		usuario.setCpf("1234");
		usuario.setEmail("Test@test");
		usuario.setSenha("1234");
		usuario.setCargo("Cargo");
		
	   
	    
		
		
		String sExp = "ID :" + idTest + " nome : " + nomeTest + " Login :" + email + "Senha"+ senha;
		String sVoltando = "ID :" + usuario.getId() + " nome : " + usuario.getNome() + " Login :" + usuario.getEmail() + "Senha"+ usuario.getSenha();
	 	
		Assert.assertEquals("Teste :", sExp, sVoltando);
			
		}

	/*@Autowired
	UsuarioService service;
	
	private Usuario usuario, copia;
		
	
	static Long id = new Long(1L);
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		usuario = new Usuario();
		
		usuario.setCargo("Cargo");
		usuario.setCpf("1234");
		usuario.setNome("Lucas");
		
		usuario.setEmail("test@test");;
		usuario.setSenha("1234");
		
		copia = new Usuario();
		copia.setCargo("Cargo");
		copia.setCpf("1234");
		copia.setNome("Lucas");
		
		copia.setEmail("test@test");;
		copia.setSenha("1234");
	}

	
	@Ignore
	@Test
	public void testCriar()  {
		service.criar(usuario);
		id = (long) usuario.getId();
		copia = service.consultar(id);
		System.out.println("Usuario "+usuario.toString());
		System.out.println("Copia "+copia.toString());
		
		
		assertEquals("Teste criar usuario",usuario,copia);
		
	}
	
	@Ignore
	@Test
	public void testAtualizar()   {
		usuario.setCargo("Supervisor");
		copia.setCargo("Supervisor");
		
		System.out.println("Usuario "+usuario.toString());
		System.out.println("Copia "+copia.toString());
		
		
		assertEquals("Teste atualizar usuario",usuario,copia);
		
	}
	*/
	

}
