package com.fabio.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.petshop.domain.Pesquisa;

@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Integer>{

}
