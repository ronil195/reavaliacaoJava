package com.fabio.petshop.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.petshop.domain.ServicoPesquisa;
import com.fabio.petshop.service.ServicoPesquisaService;

@RestController
@RequestMapping(value = "/servicospesquisa")
public class ServicoPesquisaResource {
	
	@Autowired
	ServicoPesquisaService servicePesquisaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		ServicoPesquisa obj = servicePesquisaService.find(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody ServicoPesquisa obj) {			
		obj = servicePesquisaService.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPesquisa()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ServicoPesquisa obj, @PathVariable Integer id) {
		obj.setIdPesquisa(id);
		obj = servicePesquisaService.update(obj);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {				
		servicePesquisaService.delete(id);		
		return ResponseEntity.noContent().build();
	}

}
