package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ClienteJpaDAO;
import model.Cliente;

public class Vendas extends JFrame {
	JLabel lblCliente = new JLabel("Selecione o cliente:");
	JComboBox cboCliente = new JComboBox();
	JLabel lblData = new JLabel("Data:");
	JFormattedTextField txtData = new JFormattedTextField();
	JLabel lblValorTotal = new JLabel("Valor Total");
	JTextField txtValorTotal = new JTextField();
	JLabel lblDesconto = new JLabel("Desconto");
	JTextField txtDesconto = new JTextField();
	JLabel lblValorPago = new JLabel("Valor Pago");
	JTextField txtValorPago = new JTextField();
	JButton btnCadastrarVenda = new JButton("Cadastrar Venda");

	public Vendas() {
		super("Sistema - Cadastro de Vendas");

		Container paine = this.getContentPane();
		paine.setLayout(null);

		lblCliente.setBounds(20, 20, 150, 20);
		paine.add(lblCliente);

		cboCliente.setBounds(160, 20, 150, 20);
		paine.add(cboCliente);

		cboCliente.addItem("");

		try {
		
			 ClienteJpaDAO instance = ClienteJpaDAO.getInstance();
			 List<Cliente> findAll = instance.findAll();
			 for(int i = 0; i < findAll.size(); i++) {				 
				 cboCliente.addItem(findAll.get(i).getId_cliente());
			 }

		} catch (Exception e) {
			e.printStackTrace();
		}

		lblData.setBounds(20, 50, 150, 20);
		paine.add(lblData);

		txtData.setBounds(160, 50, 150, 20);
		paine.add(txtData);

		lblValorTotal.setBounds(20, 80, 150, 20);
		paine.add(lblValorTotal);

		txtValorTotal.setBounds(160, 80, 150, 20);
		paine.add(txtValorTotal);

		lblValorPago.setBounds(20, 110, 150, 20);
		paine.add(lblValorPago);

		txtValorPago.setBounds(160, 110, 150, 20);
		paine.add(txtValorPago);

		lblDesconto.setBounds(20, 140, 150, 20);
		paine.add(lblDesconto);

		txtDesconto.setBounds(160, 140, 150, 20);
		paine.add(txtDesconto);

		btnCadastrarVenda.setBounds(100, 180, 150, 50);
		paine.add(btnCadastrarVenda);
		btnCadastrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {

					/*VendasJpaDAO instance = VendasJpaDAO.getInstance();

					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

					Date date = formatter.parse(txtData.getText());
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					vendas.setData(sqlDate);

					vendas.setDesconto(Double.parseDouble(txtDesconto.getText()));
					//vendas.setId_cliente(Integer.parseInt(cboCliente.getSelectedItem().toString()));
					vendas.setVlr_pago(Double.parseDouble(txtValorPago.getText()));
					vendas.setVlr_total(Double.parseDouble(txtValorTotal.getText()));

					instance.persist(vendas);*/
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 300);
	}
	
	public static void main(String[] args) {
		Vendas vendas = new Vendas();
	}
}
