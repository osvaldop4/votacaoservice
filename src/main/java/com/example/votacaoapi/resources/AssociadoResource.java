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

import com.example.votacaoapi.entidade.Associado;
import com.example.votacaoapi.services.AssociadoService;

@RestController
@RequestMapping(name="/associado")
public class AssociadoResource {
	
	@Autowired
	private AssociadoService associadoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Associado> listar(){
		
		List<Associado> lista =new ArrayList<Associado>();
		Associado associado = new Associado();
		lista.add(associado);		
		return lista;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Associado obj = associadoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Associado obj) {
	obj = associadoService.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}

}
