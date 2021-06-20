package com.example.votacaoapi.entidade;

import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sessao extends AbstractEntity {
	
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int idSessao;
	private ZonedDateTime inicioSessao;
	private ZonedDateTime fimSessao;
	@JsonManagedReference
	@OneToOne(mappedBy= "sessao",fetch=FetchType.LAZY,cascade=CascadeType.ALL,optional=true)	
	private Pauta pauta;
	

	public Sessao() {
		// TODO Auto-generated constructor stub
	}


	public int getIdSessao() {
		return idSessao;
	}


	public void setIdSessao(int idSessao) {
		this.idSessao = idSessao;
	}


	public ZonedDateTime getInicioSessao() {
		return inicioSessao;
	}


	public void setInicioSessao(ZonedDateTime inicioSessao) {
		this.inicioSessao = inicioSessao;
	}


	public ZonedDateTime getFimSessao() {
		return fimSessao;
	}


	public void setFimSessao(ZonedDateTime fimSessao) {
		this.fimSessao = fimSessao;
	}
	
	public Pauta getPauta() {
		return pauta;
	}


	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}


	public Long getResourceId() {
		return this.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
		
	}@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Sessao) obj).id);
	}
	
	
	
	

}
