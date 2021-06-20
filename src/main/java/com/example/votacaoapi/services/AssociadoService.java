package com.example.votacaoapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votacaoapi.entidade.Associado;
import com.example.votacaoapi.repositories.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;

	public Associado find(Integer id) {

		Optional<Associado> obj = associadoRepository.findById(id);
		
		return obj.orElse(null);

	}
	
	public Associado insert(Associado obj) {
		obj.setId(null);
		return associadoRepository.save(obj);
	}

}
