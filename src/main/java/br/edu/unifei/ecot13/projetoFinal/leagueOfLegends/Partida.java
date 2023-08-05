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
public class Partida implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	private int tempoFila;
	private EnumPartida modoJogo;
	private boolean duo;

	@OneToOne
	private SummonersRift mapa;
	@OneToMany
	private List<Equipe> equipes = new ArrayList<Equipe>();

}
