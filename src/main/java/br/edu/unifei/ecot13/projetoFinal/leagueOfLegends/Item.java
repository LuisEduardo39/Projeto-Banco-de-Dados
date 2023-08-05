package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Item implements Serializable{
	
	@Id
	private String nome;
	
	private int preco;
	private String descricao;
	/*private EnumItem categoria;
	private EnumAtributos atributos;
*/
}
