package br.usjt.reclamacao.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reclamacao")
public class Reclamacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Reclamacao other = (Reclamacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String titulo;

	@NotNull
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "idCidadao")
	private Usuario cidadao;

	private Date dataHora;

	// @ManyToOne
	// @JoinColumn(name="idSecretaria")
	// private Secretaria secretaria;

	@Column(nullable = true)
	private boolean aprovado;

	 @ManyToOne
	 @JoinColumn(name="idAvaliador",nullable=true)
	 private Usuario avaliador;
	private String resposta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getCidadao() {
		return cidadao;
	}

	public void setCidadao(Usuario cidadao) {
		this.cidadao = cidadao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	// public Secretaria getSecretaria() {
	// return secretaria;
	// }
	//
	// public void setSecretaria(Secretaria secretaria) {
	// this.secretaria = secretaria;
	// }

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	 public Usuario getAvaliador() {
	 return avaliador;
	 }
	
	 public void setAvaliador(Usuario avaliador) {
	 this.avaliador = avaliador;
	 }

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return "Reclamacao [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", Id.cidadao=" + cidadao
				+ ", dataHora=" + dataHora + ", aprovado=" + aprovado + ", resposta=" + resposta + "]";
	}
}
