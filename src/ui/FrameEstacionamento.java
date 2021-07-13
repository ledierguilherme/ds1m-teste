package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.EstacionamentoDao;
import model.Cliente;
import util.Util;

public class FrameEstacionamento {

	 private JLabel labelEntrada, labelPlaca, labelModelo, labelSaida, labelPlacaSaida, labelModeloSaida, 
	 						labelDataEntrada, labelHoraEntrada, labelDataSaida, labelHoraSaida, labelTempo, labelValor;
	 
	 private JTextField textPlaca, textModelo, textPlacaSaida, textModeloSaida, textDataEntrada, 
	 						textHoraEntrada, textDataSaida, textHoraSaida, textTempo, textValor;

 	 private JTable tabela;
 	 private DefaultTableModel tabelaModel;
	 private JScrollPane scrollTabela;
	 private JButton buttonEntrar, buttonBuscar, buttonSaida, buttonFechar;
	 
	 
	 
	 
	public void criarTela() {
		
		Font fontTitulos = new Font("Arial", Font.BOLD, 22);
		Font fontSub = new Font("Arial", Font.BOLD, 14);
		Font fontText = new Font("Arial", Font.BOLD, 13);
		Font fontTextValor = new Font("Arial", Font.BOLD, 22);
		

		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Estacionamento");
		tela.setSize(800, 520);
		tela.setLayout(null);
		tela.setResizable(false);
			
		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setBounds(40, 10, 120, 30);
		labelEntrada.setForeground(Color.GREEN.darker());
		labelEntrada.setFont(fontTitulos);
		
		labelPlaca = new JLabel("PLACA:");
		labelPlaca.setBounds(40, 45, 120, 30);
		labelPlaca.setFont(fontSub);
		textPlaca = new JTextField();
		textPlaca.setBounds(40, 75, 260, 30); 
		textPlaca.setFont(fontText);
		
		labelModelo = new JLabel("MODELO:");
		labelModelo.setBounds(340, 45, 120, 30);
		labelModelo.setFont(fontSub);
		textModelo = new JTextField();               
		textModelo.setBounds(340, 75, 255, 30);   
		textModelo.setFont(fontText);
		
		labelSaida = new JLabel("SAÍDA");
		labelSaida.setBounds(40, 250, 120, 30);
		labelSaida.setForeground(Color.GREEN.darker());
		labelSaida.setFont(fontTitulos);
		
		labelPlacaSaida = new JLabel("PLACA:");
		labelPlacaSaida.setBounds(40, 285, 120, 30);
		labelPlacaSaida.setFont(fontSub);
		textPlacaSaida = new JTextField();
		textPlacaSaida.setBounds(40, 315, 120, 30);
		textPlacaSaida.setFont(fontText);
		
		labelModeloSaida = new JLabel("MODELO:");
		labelModeloSaida.setBounds(40, 350, 120, 30);
		labelModeloSaida.setFont(fontSub);
		textModeloSaida = new JTextField();
		textModeloSaida.setBounds(40, 380, 80, 30);
		textModeloSaida.setFont(fontText);
		
		labelDataEntrada = new JLabel("DATA ENTRADA:");
		labelDataEntrada.setBounds(140, 350, 120, 30);
		labelDataEntrada.setFont(fontSub);
		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(140, 380, 120, 30);
		textDataEntrada.setFont(fontText);
		
		labelHoraEntrada = new JLabel("HORA ENTRADA:");
		labelHoraEntrada.setBounds(280, 350, 122, 30);
		labelHoraEntrada.setFont(fontSub);
		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(280, 380, 120, 30);
		textHoraEntrada.setFont(fontText);
		
		labelDataSaida = new JLabel("DATA SAÍDA:");
		labelDataSaida.setBounds(420, 350, 120, 30);
		labelDataSaida.setFont(fontSub);
		textDataSaida = new JTextField();
		textDataSaida.setBounds(420, 380, 120, 30);
		textDataSaida.setFont(fontText);
		
		labelHoraSaida = new JLabel("HORA SAÍDA:");
		labelHoraSaida.setBounds(560, 350, 120, 30);
		labelHoraSaida.setFont(fontSub);
		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(560, 380, 120, 30);
		textHoraSaida.setFont(fontText);
		
		labelTempo = new JLabel("TEMPO:");
		labelTempo.setBounds(700, 350, 120, 30);
		labelTempo.setFont(fontSub);
		textTempo = new JTextField();
		textTempo.setBounds(700, 380, 60, 30);
		textTempo.setFont(fontText);
		
		
		labelValor = new JLabel("VALOR A PAGAR:");
		labelValor.setBounds(40, 440, 130, 30);
		labelValor.setFont(fontSub);
		textValor = new JTextField();
		textValor.setBounds(180, 420, 170, 50);
		textValor.setFont(fontTextValor);
		
		
		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(620, 75, 137, 30);    
		buttonEntrar.setForeground(Color.WHITE);
		buttonEntrar.setBackground(Color.BLUE);
		
		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(180, 315, 137, 30);
		buttonBuscar.setForeground(Color.WHITE);
		buttonBuscar.setBackground(Color.BLUE);
		
		buttonSaida = new JButton("EFETUAR SAÍDA");
		buttonSaida.setBounds(370, 420, 190, 50);
		buttonSaida.setForeground(Color.WHITE);
		buttonSaida.setBackground(Color.BLUE);
		
		buttonFechar = new JButton("FECHAR SISTEMA");
		buttonFechar.setBounds(570, 420, 190, 50);
		buttonFechar.setForeground(Color.WHITE);
		buttonFechar.setBackground(Color.RED);
		
		//Criar colunas 
		tabelaModel = new DefaultTableModel();
		tabelaModel.addColumn("CÓDIGO");
		tabelaModel.addColumn("PLACA");
		tabelaModel.addColumn("MODELO");
		tabelaModel.addColumn("DATA ENTRADA");
		
		EstacionamentoDao estacionamentoDao = new EstacionamentoDao(); 
		ArrayList<Cliente> clientes = estacionamentoDao.buscarCliente();
		
		for (Cliente cliente : clientes) {
			
			String[] vetorCliente = {cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(), cliente.getDataEntrada()};
		
		tabelaModel.addRow (vetorCliente);
		
		}
		
		// criar a tabela 
		tabela = new JTable (tabelaModel);
		
			//largura das colunas
		tabela.getColumnModel().getColumn(0).setPreferredWidth(185);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(185);     // soma das larguras não pode passar de 700
		tabela.getColumnModel().getColumn(2).setPreferredWidth(185);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(185);
				
			//impedir movimentação das colunas
		tabela.getTableHeader().setReorderingAllowed(false);

			// criar o painel de rolagem
		scrollTabela = new JScrollPane (tabela);
		scrollTabela.setBounds (40, 115, 720, 120);
	
	 
		
		
		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlaca);
		tela.getContentPane().add(textPlaca).setForeground(Color.GREEN.darker()) ;
		tela.getContentPane().add(labelModelo);
		tela.getContentPane().add(textModelo).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(textPlacaSaida).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelModeloSaida);
		tela.getContentPane().add(textModeloSaida).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida).setForeground(Color.GREEN.darker());	
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo).setForeground(Color.GREEN.darker());
		tela.getContentPane().add(labelValor);
		tela.getContentPane().add(textValor).setForeground(Color.GREEN.darker());
		
		tela.getContentPane().add(buttonEntrar).setFont(fontSub);
		tela.getContentPane().add(buttonBuscar).setFont(fontSub);
		tela.getContentPane().add(buttonSaida).setFont(fontSub);
		tela.getContentPane().add(buttonFechar).setFont(fontSub);
		tela.getContentPane().add(scrollTabela);
	
		tela.setVisible(true);
		
		// ouvinte do botão entrar
				buttonEntrar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (validarFormulario()) {
							Cliente cliente = new Cliente();
							cliente.setCodigo(Util.gerarCodigo());
							cliente.setPlaca(textPlaca.getText().toUpperCase());
							cliente.setModelo(textModelo.getText().toUpperCase());
							cliente.setDataEntrada(Util.converterData(LocalDate.now()));
							cliente.setHoraEntrada(Util.converterHora(LocalTime.now()));
					

							EstacionamentoDao dao = new EstacionamentoDao(cliente);
							dao.gravar();

							JOptionPane.showMessageDialog(null,
									cliente.getModelo() + " estacionou!");

							textPlaca.setText("");
							textModelo.setText("");

							System.out.println(cliente.toString());

						} else {}
					}
				});
				
				buttonBuscar.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Cliente cliente = new Cliente();
						EstacionamentoDao dao = new EstacionamentoDao();
						cliente = dao.buscarCliente(textPlacaSaida.getText());
						
						
						textModeloSaida.setText(cliente.getModelo());
						textDataEntrada.setText(cliente.getDataEntrada());
						textHoraEntrada.setText(cliente.getHoraEntrada());
						textDataSaida.setText(Util.converterData(LocalDate.now()));
						textHoraSaida.setText(Util.converterHora(LocalTime.now()));
						textTempo.setText(cliente.getTempo());
						textValor.setText((String.valueOf(cliente.getValor())));
						
					}
				});												
	 
	}
	 
		private boolean validarFormulario() {

			boolean valido = true;

			if (textPlaca.getText().trim().length() == 0) {
				labelPlaca.setForeground(Color.RED);
				valido = false;
			} else if (textModelo.getText().trim().length() == 0) {
				labelModelo.setForeground(Color.RED);
				valido = false;
			}
			
			return valido;
		}
	
	 
	 
	 
}
	

	