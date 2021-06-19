package com.example.votacaoapi.entidade;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Voto extends AbstractEntity{
	
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVoto;
	@Column(nullable=false,unique=true)
	private boolean voto;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="voto",cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="idPautaFk")
	private Pauta pauta;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="voto",cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="idAssociadoFk")
	private Associado associado;

	public Voto() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}

	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Voto) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Long getResourceId() {
		return this.id;
	}

}
