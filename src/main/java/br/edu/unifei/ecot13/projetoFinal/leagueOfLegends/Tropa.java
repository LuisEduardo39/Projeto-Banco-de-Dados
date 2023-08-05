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
public class Tropa implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	private int vida;
	private int dano;
	private int alcance;
	private int armadura;
	private int visao;
	private EnumTropa tipo;
	private int ouroDado;
	private int xpDado;

	@OneToOne
	private Inibidor i;
	
	public boolean superTropa(Inibidor i) {
		if(i.isDestruido()) {
			return true;
		}
		return false;
	}

}
