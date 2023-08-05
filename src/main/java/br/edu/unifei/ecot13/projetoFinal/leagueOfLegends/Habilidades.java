package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Habilidades implements Serializable{

	@Id
	private String nome;
	
	private String descricao;
	private double tempoRecaga;
	private int custoMana;
	
}
