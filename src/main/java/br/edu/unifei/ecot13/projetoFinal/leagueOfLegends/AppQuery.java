package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class AppQuery {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeagueOfLegendsBD");
        EntityManager em  = emf.createEntityManager();
        
        /*
        Item i = (Item)em.createQuery(
                "select i "
                + "from Item i"
                + "where i.nome='Sedenta por Sangue'"
                ).getSingleResult();
                System.out.println(i.getNome());
                
        }
        List<Item> l1 = em.createQuery(
        	"select i" 
	        + "from Item i "
	        ).getResultList();
	        for(Item i : l1) {
	        	System.out.println(i.getNome());
	        }*/
	        
	}
	
}
