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
import javax.swing.JCheckBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemFormExcluir extends JFrame {

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
					ItemFormExcluir frame = new ItemFormExcluir();
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
	public ItemFormExcluir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 9, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(10, 111, 46, 14);
		contentPane.add(lblPreco);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(78, 6, 220, 20);
		contentPane.add(txtNome);
		
		JSpinner spnPreco = new JSpinner();
		spnPreco.setEnabled(false);
		spnPreco.setBounds(91, 108, 93, 20);
		contentPane.add(spnPreco);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setNome(txtNome.getText());
				item.setDescricao(textDescricao.getText());
				textDescricao.setEnabled(false);
				item.setPreco((Integer)spnPreco.getValue());
				spnPreco.setEnabled(false);
				em.getTransaction().begin();
				em.remove(item);
				em.getTransaction().commit();							
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(209, 108, 89, 23);
		contentPane.add(btnExcluir);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item=em.find(Item.class, txtNome.getText());
				if(item!=null) {
					txtNome.setEnabled(true);
					txtNome.setText(item.getNome());
					textDescricao.setEnabled(false);
					textDescricao.setText(item.getDescricao());
					spnPreco.setEnabled(false);
					spnPreco.setValue(item.getPreco());				
					btnExcluir.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Item não existe");
				}
				
				
			}
		});
		
		
		btnBuscar.setBounds(209, 38, 89, 23);
		contentPane.add(btnBuscar);
		
		textDescricao = new JTextField();
		textDescricao.setEditable(false);
		textDescricao.setEnabled(false);
		textDescricao.setColumns(10);
		textDescricao.setBounds(78, 73, 220, 23);
		contentPane.add(textDescricao);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(10, 78, 73, 14);
		contentPane.add(lblDescricao);
	}
}
