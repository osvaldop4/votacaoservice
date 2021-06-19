package com.example.votacaoapi.entidade;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

public class AbstractEntity {
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	@JsonIgnore
	@CreationTimestamp
	@Column(updatable = false)
	protected Instant created;
	

	public AbstractEntity() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getCreated() {
		return created;
	}


	public void setCreated(Instant created) {
		this.created = created;
	}

}
