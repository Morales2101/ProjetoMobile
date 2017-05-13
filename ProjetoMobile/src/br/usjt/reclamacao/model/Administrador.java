package br.usjt.reclamacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name="administrador")
public class Administrador implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@NotNull
	private String adm;
	
	@NotNull
	private String senha;
	
	public Administrador(){
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Administrador [adm=" + adm + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adm == null) ? 0 : adm.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (adm == null) {
			if (other.adm != null)
				return false;
		} else if (!adm.equals(other.adm))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}	
}
