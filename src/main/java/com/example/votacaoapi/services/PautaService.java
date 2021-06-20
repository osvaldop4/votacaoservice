package com.example.votacaoapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votacaoapi.entidade.Pauta;
import com.example.votacaoapi.repositories.PautaRepository;

@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;

	public Pauta find(Integer id) {

		Optional<Pauta> obj = pautaRepository.findById(id);
		
		return obj.orElse(null);

	}
	
	public Pauta insert(Pauta obj) {
		obj.setId(null);
		return pautaRepository.save(obj);
	}

}
