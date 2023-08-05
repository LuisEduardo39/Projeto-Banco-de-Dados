package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Selva implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private int numeroArbustros;
	private boolean nevoaBatalha;
	private boolean invasao;

}
