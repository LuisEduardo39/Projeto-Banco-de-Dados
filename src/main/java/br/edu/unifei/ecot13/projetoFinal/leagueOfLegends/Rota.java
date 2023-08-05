package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Rota implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private EnumRota nome;
	
	@OneToMany
	private List<Torre> torres = new ArrayList<Torre>();
}
