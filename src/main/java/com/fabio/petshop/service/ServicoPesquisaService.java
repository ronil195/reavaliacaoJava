package com.fabio.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fabio.petshop.domain.ServicoPesquisa;
import com.fabio.petshop.repository.ServicoPesquisaRepository;
import com.fabio.petshop.service.exceptions.DataIntegrityException;
import com.fabio.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoPesquisaService {
	
	@Autowired
	private ServicoPesquisaRepository repo;
	
	public ServicoPesquisa find(Integer id) {
		Optional<ServicoPesquisa> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + ServicoPesquisa.class.getName()));
	}
	
	public ServicoPesquisa insert(ServicoPesquisa obj) {
		obj.setIdPesquisa(null);
		return repo.save(obj);
	}
	
	public ServicoPesquisa update(ServicoPesquisa obj) {
		find(obj.getIdPesquisa());
		return repo.save(obj);
	}	
	
	public void delete(Integer id) {
		find(id);		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pesquisas possui respostas, não é possível deletar!");
		}
		
	}

}
