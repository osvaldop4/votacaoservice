package com.example.votacaoapi.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.votacaoapi.entidade.Voto;
import com.example.votacaoapi.services.VotoService;

@RestController
@RequestMapping(name="/voto")
public class VotoResource {
	
	@Autowired
	private VotoService votoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Voto> listar(){
		
		List<Voto> lista =new ArrayList<Voto>();
		Voto voto = new Voto();
		lista.add(voto);		
		return lista;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Voto obj = votoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Voto obj) {
	obj = votoService.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public long countEntities() {
		long countTrue = votoService.getCountVotoTrue();
		long countFalse= votoService.getCountVotoFalse();
		return countTrue + countFalse;
	}

}
