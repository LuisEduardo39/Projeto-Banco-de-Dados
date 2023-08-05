package br.edu.unifei.ecot13.projetoFinal.leagueOfLegends.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.projetoFinal.leagueOfLegends.Item;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemFormAltera extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeagueOfLegendsBD");
    EntityManager em  = emf.createEntityManager();
	private Item item;
	private JTextField textDescricao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemFormAltera frame = new ItemFormAltera();
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
	public ItemFormAltera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(10, 113, 46, 14);
		contentPane.add(lblPreco);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(88, 8, 197, 20);
		contentPane.add(txtNome);
		
		JSpinner spnPreco = new JSpinner();
		spnPreco.setBounds(88, 110, 93, 20);
		contentPane.add(spnPreco);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setNome(txtNome.getText());
				txtNome.setEnabled(true);
				item.setDescricao(textDescricao.getText());
				textDescricao.setEnabled(true);
				item.setPreco((Integer)spnPreco.getValue());
				spnPreco.setEnabled(true);
				btnAlterar.setEnabled(true);
				em.getTransaction().begin();
				em.merge(item);
				em.getTransaction().commit();			
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(196, 110, 89, 23);
		contentPane.add(btnAlterar);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item=em.find(Item.class, txtNome.getText());
				if(item!=null) {
					txtNome.setEnabled(true);
					txtNome.setText(item.getNome());
					textDescricao.setEnabled(true);
					textDescricao.setText(item.getDescricao());
					spnPreco.setEnabled(true);
					spnPreco.setValue(item.getPreco());
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Item não existe");
				}
				
				
			}
		});
		btnBuscar.setBounds(196, 46, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(10, 74, 66, 14);
		contentPane.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(88, 72, 197, 26);
		contentPane.add(textDescricao);
	}
}
