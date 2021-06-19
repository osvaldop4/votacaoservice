package com.example.votacaoapi.entidade;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.votacaoapi.entidade.AbstractEntity;
@Entity
public class Associado extends AbstractEntity {
	
	@Id
	@Column(nullable = false, updatable = false)	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAssociado;
	@Column(nullable = false)	
	private String nome;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="associado",cascade=CascadeType.ALL,orphanRemoval=true)	
	private Voto voto;
	@Column(nullable=false,unique=true)
	private String cpf;
	
	
	public Associado() {
		
	}


	public int getIdAssociado() {
		return idAssociado;
	}


	public void setIdAssociado(int idAssociado) {
		this.idAssociado = idAssociado;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Voto getVoto() {
		return voto;
	}


	public void setVoto(Voto voto) {
		this.voto = voto;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Long getResourceId() {
		return this.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Associado) obj).id);
	}
}
