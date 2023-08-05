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
public class Campeao implements Serializable{

	@Id
	private String nome;
	
	private String funcao;
	private String caracteristica;
	private EnumClasse classe;
	private int farm;
	private int nivel;
	private int pontosHabilidade;
	private String kda;
	private EnumAtributos atributosBase;
	private int estoqueOuro;
	private double barraXp;

	@OneToMany
	private List<Loja> comprar = new ArrayList<Loja>();
	@OneToMany
	private List<Item> itens = new ArrayList<Item>();
	@OneToMany
	private List<Habilidades> habilidades = new ArrayList<Habilidades>();

}
