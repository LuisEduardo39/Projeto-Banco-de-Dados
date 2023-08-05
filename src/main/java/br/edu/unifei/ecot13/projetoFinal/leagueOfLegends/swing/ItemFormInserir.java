package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.projetoFinal.leagueOfLegends.Item;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemFormInserir extends JFrame {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeagueOfLegendsBD");
    EntityManager em  = emf.createEntityManager();
	private Item item;

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemFormInserir frame = new ItemFormInserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ItemFormInserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 32, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(10, 113, 46, 14);
		contentPane.add(lblPreco);
		
		txtNome = new JTextField();
		txtNome.setBounds(86, 29, 169, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JSpinner spnPreco = new JSpinner();
		spnPreco.setBounds(86, 110, 93, 20);
		contentPane.add(spnPreco);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item=new Item();
				item.setNome(txtNome.getText());
				item.setDescricao(textDescricao.getText());
				item.setPreco((Integer)spnPreco.getValue());
				em.getTransaction().begin();
				em.persist(item);
				em.getTransaction().commit();
			}
		});
		btnInserir.setBounds(180, 110, 89, 23);
		contentPane.add(btnInserir);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(86, 61, 169, 23);
		contentPane.add(textDescricao);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(10, 69, 66, 14);
		contentPane.add(lblDescricao);
	}
}
