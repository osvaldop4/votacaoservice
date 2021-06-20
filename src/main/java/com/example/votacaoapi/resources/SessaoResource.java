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

import com.example.votacaoapi.entidade.Sessao;
import com.example.votacaoapi.services.SessaoService;

@RestController
@RequestMapping(name="/sessao")
public class SessaoResource {
	
	@Autowired
	private SessaoService sessaoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Sessao> listar(){
		
		List<Sessao> lista =new ArrayList<Sessao>();
		Sessao sessao = new Sessao();
		lista.add(sessao);		
		return lista;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Sessao obj = sessaoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Sessao obj) {
	obj = sessaoService.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}

}
