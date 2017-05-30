package br.usjt.reclamacao.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String CIDADAO = "cidadao";

	public static final String SOLUCIONADOR = "solucionador";

	public static final String ADMINISTRADOR = "adm";

	private String tipo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String cpf;
	private String email;

	@NotNull
	@Size(max = 100)
	private String senha;
		
	@ManyToOne
	@JoinColumn(name = "idCargo")
	private Secretaria idcargo;
	
	
	// @ManyToOne
	// @JoinColumn(nullable = true, name="idSecretaria")
	// private Secretaria secretaria;

	public Usuario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Secretaria getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(Secretaria idcargo) {
		this.idcargo = idcargo;
	}

	
	
//	@Override
//	public String toString() {
//		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
//				+ ", cargo=" + cargo + "]";
//	}
}