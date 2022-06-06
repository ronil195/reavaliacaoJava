package com.fabio.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.petshop.domain.ServicoPesquisa;

@Repository
public interface ServicoPesquisaRepository extends JpaRepository<ServicoPesquisa, Integer>{

}
