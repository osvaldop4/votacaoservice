package com.example.votacaoapi.services;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.stereotype.Service;

import com.example.votacaoapi.entidade.Pauta;
import com.example.votacaoapi.entidade.Sessao;
import com.example.votacaoapi.repositories.PautaRepository;

@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private Sessao sessao;
	
	private ZonedDateTime agora = ZonedDateTime.now();
	
	public Pauta find(Integer id) {

		Optional<Pauta> obj = pautaRepository.findById(id);
		
		return obj.orElse(null);

	}
	
	public Pauta insert(Pauta obj) {		
		
		if(agora.compareTo(sessao.getFimSessao()) > 0) {
			 
			RecoverableDataAccessException exception = new RecoverableDataAccessException("Sessão finalizada");	
			exception.getMessage();
		}				
		obj.setId(null);
		return pautaRepository.save(obj);
	}	

}
