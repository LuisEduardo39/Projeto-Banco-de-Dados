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
public class Base implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private int estruturasdestruidas;

	@OneToMany
	private List<Torre> torres = new ArrayList<Torre>();
	@OneToMany
	private List<Inibidor> inibidores = new ArrayList<Inibidor>();
	@OneToOne
	private Nexus nexus;

}
