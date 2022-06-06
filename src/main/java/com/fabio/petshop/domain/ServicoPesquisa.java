package com.fabio.petshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ServicoPesquisa implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_servico")
	Servico servico;
    
    @ManyToOne
	@JoinColumn(name = "id_pesquisa")
	private Pesquisa pesquisa;
	
    private Integer pontos;

	public ServicoPesquisa() {
		
	}
	
	public ServicoPesquisa(Integer id, Servico servico, Pesquisa pesquisa, Integer pontos) {
		super();
		this.id = id;
        this.servico = servico;
		this.pesquisa = pesquisa;
        this.pontos = pontos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoPesquisa other = (ServicoPesquisa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	public Integer getIdPesquisa() {
		return id;
	}

	public void setIdPesquisa(Integer id) {
		this.id = id;
	}

    public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

    public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	
}
