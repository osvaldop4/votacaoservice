package com.example.votacaoapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votacaoapi.entidade.Sessao;
import com.example.votacaoapi.repositories.SessaoRepository;

@Service
public class SessaoService {

	@Autowired
	private SessaoRepository sessaoRepository;

	public Sessao find(Integer id) {

		Optional<Sessao> obj = sessaoRepository.findById(id);
		
		return obj.orElse(null);

	}
	
	public Sessao insert(Sessao obj) {
		obj.setId(null);
		return sessaoRepository.save(obj);
	}

}
