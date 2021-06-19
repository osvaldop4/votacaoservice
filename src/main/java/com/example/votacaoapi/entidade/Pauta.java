package com.example.votacaoapi.entidade;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pauta extends AbstractEntity {
	
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPauta;
	@OneToOne(mappedBy = "pauta", fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional=true )
	@JoinColumn(name="idSessaoFk")
	private Sessao sessao;
	@Column(nullable = false)
	private String descricaoPauta;
	@OneToOne(mappedBy = "pauta",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Voto voto;

	public Pauta() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(int idPauta) {
		this.idPauta = idPauta;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}

	public void setDescricaoPauta(String descricaoPauta) {
		this.descricaoPauta = descricaoPauta;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Pauta) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Long getResourceId() {
		return this.id;
	}
	
	

}
