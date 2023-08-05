package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Invocador implements Serializable {

	@Id
	private String nome;
	
	private int idade;
	private int qi;

	@OneToOne
	private Campeao campeao = new Campeao();
}
