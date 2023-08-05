package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeagueOfLegendsBD");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		 

		Item i = new Item();
		i.setNome("Sedenta por Sangue");
		i.setPreco(3400);
		i.setDescricao("A vida excedente fica armazenada como escudo");
		em.persist(i);

		Partida p = new Partida();
		p.setTempoFila(5);
		p.setModoJogo(EnumPartida.NORMAL);
		p.setDuo(false);
		em.persist(p);
	
		Equipe e = new Equipe();
		e.setLado(EnumLado.AZUL);
		em.persist(e);

		Campeao c = new Campeao();
		c.setFuncao("Carregador");
		c.setCaracteristica("Ficar forte, e ganhar o jogo");
		c.setClasse(EnumClasse.ATIRADOR);
		c.setNome("Ashe");
		c.setFarm(100);
		c.setNivel(10);
		c.setPontosHabilidade(10);
		c.setKda("2/2/2");
		c.setAtributosBase(EnumAtributos.DANO_ACERTO_CRITICO);
		c.setEstoqueOuro(5000);
		c.setBarraXp(0.8);
		em.persist(c);

		Habilidades ha = new Habilidades();
		ha.setNome("Flecha de Cristal Encantada");
		ha.setDescricao(
				"Ashe dispara um projetil dde gelo em linha reta. Se a flecha colidir com um Campeao inimigo,ela causa dano e o atordoa.");
		ha.setCustoMana(100);
		ha.setTempoRecaga(74.07);
		em.persist(ha);

		Loja l = new Loja();
		l.setEstaNaBase(false);
		em.persist(l);

		SummonersRift sr = new SummonersRift();
		sr.setLocalizacao("floresta entre Freljord e as Montanhas Ironspine");
		sr.setEnergiaMagica(150);
		em.persist(sr);
		
		Selva s = new Selva();
		s.setNumeroArbustros(20);
		s.setNevoaBatalha(true);
		s.setInvasao(true);
		em.persist(s);

		Rota ra = new Rota();
		ra.setNome(EnumRota.BOT);
		em.persist(ra);

		Torre t = new Torre();
		t.setAlcance(1095);
		t.setDano(100);
		t.setDefesa(100);
		t.setOuroDado(100);
		t.setVida(4000);
		t.setVisao(775);
		t.setXpDado(50);
		em.persist(t);

		Base b = new Base();
		b.setEstruturasdestruidas(3);
		em.persist(b);


		Inibidor in = new Inibidor();
		in.setVida(400);
		in.setDefesa(20);
		in.setDestruido(false);
		em.persist(in);

		Tropa tr = new Tropa();
		tr.setAlcance(550);
		tr.setArmadura(10);
		tr.setDano(20);
		tr.setOuroDado(30);
		tr.setTipo(EnumTropa.MAGOS);
		tr.setVida(100);
		tr.setVisao(400);
		tr.setXpDado(50);
		em.persist(tr);

		Nexus n = new Nexus();
		n.setDefesa(20);
		n.setDestruido(false);
		n.setInvuneravel(true);
		n.setVida(5500);
		em.persist(n);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
