package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class SummonersRift implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String localizacao;
	private float energiaMagica;

	@OneToMany
	private List<Loja> lojas = new ArrayList<Loja>();
	@OneToMany
	private List<Base> bases = new ArrayList<Base>();
	@OneToMany
	private List<Rota> rotas = new ArrayList<Rota>();
	@OneToOne
	private Selva selva;

}
