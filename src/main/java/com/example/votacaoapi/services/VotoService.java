package com.example.votacaoapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.votacaoapi.entidade.Voto;
import com.example.votacaoapi.repositories.VotoRepository;

@Service
public class VotoService {
	
	private long totalTrue;
	private long totalFalse;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private Voto voto;
	
	public Voto find(Integer id) {
		
		Optional<Voto> obj = votoRepository.findById(id);
		
		return  obj.orElse(null);
	}
	
	public Voto insert(Voto obj) {
		obj.setId(null);
		return votoRepository.save(obj);
	}
	
	@Transactional(readOnly = true)
	public long getCountVotoTrue(){
		if(voto.isVoto() == true) {
			totalTrue =  votoRepository.count();
		}
		return totalTrue;	
		
	}
	@Transactional(readOnly = true)
	public long getCountVotoFalse(){
		if(voto.isVoto() == false) {
			totalFalse =  votoRepository.count();
		}
		return totalFalse;	
		
	}
}
