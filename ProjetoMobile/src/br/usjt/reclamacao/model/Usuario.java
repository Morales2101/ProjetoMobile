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
	private String cargo;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	// public Secretaria getSecretaria() {
	// return secretaria;
	// }
	//
	// public void setSecretaria(Secretaria secretaria) {
	// this.secretaria = secretaria;
	// }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
//
//	@Override
//	public String toString() {
//		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
//				+ ", cargo=" + cargo + "]";
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
}
//
// @Override
// public boolean equals(Object obj) {
// if (this == obj)
// return true;
// if (obj == null)
// return false;
// if (getClass() != obj.getClass())
// return false;
// Usuario other = (Usuario) obj;
// if (cargo == null) {
// if (other.cargo != null)
// return false;
// } else if (!cargo.equals(other.cargo))
// return false;
// if (cpf == null) {
// if (other.cpf != null)
// return false;
// } else if (!cpf.equals(other.cpf))
// return false;
// if (email == null) {
// if (other.email != null)
// return false;
// } else if (!email.equals(other.email))
// return false;
// if (id != other.id)
// return false;
// if (nome == null) {
// if (other.nome != null)
// return false;
// } else if (!nome.equals(other.nome))
// return false;
// if (secretaria == null) {
// if (other.secretaria != null)
// return false;
// } else if (!secretaria.equals(other.secretaria))
// return false;
// if (senha == null) {
// if (other.senha != null)
// return false;
// } else if (!senha.equals(other.senha))
// return false;
// if (tipo == null) {
// if (other.tipo != null)
// return false;
// } else if (!tipo.equals(other.tipo))
// return false;
// return true;
// }
// }
