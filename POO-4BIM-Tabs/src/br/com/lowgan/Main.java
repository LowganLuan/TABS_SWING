package br.com.lowgan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;



public class Main extends JFrame {
	
	private static JPanel painelMoeda, painelTemperatura, painelComprimento;
	

	JTextField jTextTemp = new JTextField();
	JTextField jTextTemp2 = new JTextField();
	JComboBox<String> comboBoxTemp;
	JComboBox<String> comboBoxTemp2;
	JLabel labelTemp = new JLabel();
	JLabel labelTemp2 = new JLabel();
	JButton botaoTemp = new JButton();
	JTabbedPane tabPane = new JTabbedPane();
	
	JLabel labelCompr = new JLabel();
	JLabel labelCompr2 = new JLabel();
	JComboBox<String> comboBoxCompr;
	JComboBox<String> comboBoxCompr2;
	JTextField jTextCompr = new JTextField();
	JTextField jTextCompr2 = new JTextField();
	JButton botaoCompr = new JButton();
	
	JLabel labelMoe = new JLabel();
	JLabel labelMoe2 = new JLabel();
	JComboBox<String> comboBoxMoe;
	JComboBox<String> comboBoxMoe2;
	JTextField jTextMoe = new JTextField();
	JTextField jTextMoe2 = new JTextField();
	JButton botaoMoe = new JButton();
	
	public Main() {

		
		JMenuBar menuBar = new JMenuBar();
		
		// Cria o menu Arquivo
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		
		// Cria os itens do menu
		JMenuItem item = new JMenuItem("Sair",KeyEvent.VK_I);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispatchEvent(new WindowEvent(Main.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		
		JMenu subMenu = new JMenu("Novo");
		JMenuItem item1 = new JMenuItem("Projeto",new ImageIcon("assets/imgs/icone_folder.png"));
		JMenuItem item2 = new JMenuItem("Arquivo",new ImageIcon("assets/imgs/icone_novo.png"));


		subMenu.add(item1);
		subMenu.add(item2);
		
		menuArquivo.add(item);
		
		JMenu menuConfigs = new JMenu("Editar");
		JMenuItem checkItem = new JMenuItem("Limpar Campos");
		checkItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jTextCompr.setText("0");
				jTextCompr2.setText("0");
				jTextMoe.setText("0");
				jTextMoe2.setText("0");
				jTextTemp.setText("0");
				jTextTemp2.setText("0");
				
				JOptionPane mess = new JOptionPane();
				mess.showMessageDialog(null,"Campos limpos");
				
			}
		});
		
	
	

		JCheckBoxMenuItem radio1 = new JCheckBoxMenuItem("Exibir Moedas");
		JCheckBoxMenuItem radio2 = new JCheckBoxMenuItem("Exibir Temperaturas");
		JCheckBoxMenuItem radio3 = new JCheckBoxMenuItem("Exibir Comprimentos");
		radio1.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		
		
		menuConfigs.add(checkItem);
		menuConfigs.addSeparator();
		menuConfigs.add(radio1);
		menuConfigs.add(radio2);
		menuConfigs.add(radio3);
		
		
		JMenu menu2 = new JMenu("Ajuda");
		JMenuItem item5 = new JMenuItem("Desenvolvedores");
		JMenuItem item8 = new JMenuItem("Repositório do Github");
		JMenuItem item10 = new JMenuItem("Sobre");
		
		
		
		menu2.add(item5);
		menu2.add(item8);
		menu2.add(item10);
		
	
		menuBar.add(menuArquivo);
		menuBar.add(menuConfigs);
		menuBar.add(menu2);
		

		setJMenuBar(menuBar);
		
	
		
		
		tabPane.setBorder(BorderFactory.createEmptyBorder(10,10	, 10, 10));
		ImageIcon icon = new ImageIcon("assets/imgs/icone_folder.png");
		
		Color colors[] = {Color.WHITE,Color.BLUE
				,Color.DARK_GRAY,Color.YELLOW,Color.MAGENTA};
		
		
//////////////////////////////////////////////////////////////////////////////////////////

		painelMoeda = criarPanel(Color.decode("#ffffff"), "");	
		
		labelMoe.setText("De: ");
		
		String itensMoe [] = {"Real","Dollar","Euro"};
		comboBoxMoe = new JComboBox<String>(itensMoe);
		comboBoxMoe.setSelectedIndex(0);
		
		labelMoe2.setText("                    Para: ");
		
		String itensMoe2 [] = {"Dollar","Euro","Real"};
		comboBoxMoe2 = new JComboBox<String>(itensMoe2);
		

		jTextMoe.setPreferredSize(new Dimension(65, 25));
		jTextMoe.setText("0");
		jTextMoe2.setPreferredSize(new Dimension(65, 25));
		jTextMoe2.setText("0");

		botaoMoe.setPreferredSize(new Dimension(130, 25));
		botaoMoe.setText("Converter");
		botaoMoe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String moeDe = (String) comboBoxMoe.getSelectedItem();
				String moePara = (String) comboBoxMoe2.getSelectedItem();
				double valorDe = Double.parseDouble(jTextMoe.getText());
				double valorPara = 0;
				DecimalFormat df = new DecimalFormat("#.00");
				if(moeDe.equals("Real") && moePara.equals("Dollar")) {
					valorPara = valorDe * 0.25;
				}
				else if(moeDe.equals("Real") && moePara.equals("Euro")){
					 valorPara = valorDe * 0.22;
				}
				else if(moeDe.equals("Dollar") && moePara.equals("Real")){
					valorPara = valorDe * 3.99;
				}
				else if(moeDe.equals("Dollar") && moePara.equals("Euro")){
					valorPara = valorDe * 0.90;
				}
				else if(moeDe.equals("Euro") && moePara.equals("Real")){
					valorPara = valorDe * 4.45;
				}
				else if(moeDe.equals("Euro") && moePara.equals("Dollar")){
					valorPara = valorDe * 1.12;
				}
				else {
					JOptionPane mess = new JOptionPane();
					mess.showMessageDialog(null,"Conversão Impossível");
				}
				jTextMoe2.setText(df.format(valorPara));
			}
		});
		
		painelMoeda.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));
		painelMoeda.add(labelMoe);
		painelMoeda.add(comboBoxMoe);
		painelMoeda.add(jTextMoe);
		painelMoeda.add(labelMoe2);
		painelMoeda.add(comboBoxMoe2);
		painelMoeda.add(jTextMoe2);
		painelMoeda.add(botaoMoe);
		
			
			
			tabPane.addTab("moeda", icon,painelMoeda, "Hint do Tab ");
			
			painelTemperatura = criarPanel(Color.decode("#ffffff"), "");
			
			
			labelTemp.setText("De: ");
			
			String itensTemp [] = {"Celsius","Kelvin"};
			comboBoxTemp = new JComboBox<String>(itensTemp);
			comboBoxTemp.setSelectedIndex(0);
			
			labelTemp2.setText("                    Para: ");
			String itensTemp2 [] = {"Kelvin","Celsius"};
			comboBoxTemp2 = new JComboBox<String>(itensTemp2);
			comboBoxTemp2.setSelectedIndex(0);
			
		
			jTextTemp.setPreferredSize(new Dimension(65, 25));
			jTextTemp.setText("0");
			jTextTemp2.setPreferredSize(new Dimension(65, 25));
			jTextTemp2.setText("0");
		
			botaoTemp.setPreferredSize(new Dimension(130, 25));
			botaoTemp.setText("Converter");
			botaoTemp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String tempDe = (String) comboBoxTemp.getSelectedItem();
					String tempPara = (String) comboBoxTemp2.getSelectedItem();
					double valorDe = Double.parseDouble(jTextTemp.getText());
					double valorPara = 0;
					DecimalFormat df = new DecimalFormat("#.00");
					if(tempDe.equals("Celsius") && tempPara.equals("Kelvin")) {
						valorPara = valorDe + 273.15;
					}
					else if(tempDe.equals("Kelvin") && tempPara.equals("Celsius")){
						 valorPara = valorDe - 273.15;
					}
					else {
						JOptionPane mess = new JOptionPane();
						mess.showMessageDialog(null,"Conversão Impossível");
					}
					jTextTemp2.setText(df.format(valorPara));
				}
			});
			

			painelTemperatura.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));
			painelTemperatura.add(labelTemp);
			painelTemperatura.add(comboBoxTemp);
			painelTemperatura.add(jTextTemp);
			painelTemperatura.add(labelTemp2);
			painelTemperatura.add(comboBoxTemp2);
			painelTemperatura.add(jTextTemp2);
			painelTemperatura.add(botaoTemp);
			
			tabPane.addTab("temperatura", icon, painelTemperatura, "Hint do Tab ");
			
			
			painelComprimento = criarPanel(Color.decode("#ffffff"), "");
			
			
			tabPane.addTab("Comprimento", icon, painelComprimento, "Hint do Tab ");
			labelCompr.setText("De: ");
			
			String itensCompr [] = {"Metro","Milimetro"};	
			comboBoxCompr = new JComboBox<String>(itensCompr);
			comboBoxCompr.setSelectedIndex(0);
			
			labelCompr2.setText("                    Para: ");
			
			String itensCompr2 [] = {"Milimetro","Metro"};
			comboBoxCompr2 = new JComboBox<String>(itensCompr2);
			comboBoxCompr2.setSelectedIndex(0);
			
			
			jTextCompr.setPreferredSize(new Dimension(65, 25));
			jTextCompr.setText("0");
			jTextCompr2.setPreferredSize(new Dimension(65, 25));
			jTextCompr2.setText("0");
			
			botaoCompr.setPreferredSize(new Dimension(130, 25));
			botaoCompr.setText("Converter");
			botaoCompr.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String comprDe = (String) comboBoxCompr.getSelectedItem();
					String comprPara = (String) comboBoxCompr2.getSelectedItem();
					double valorDe = Double.parseDouble(jTextCompr.getText());
					double valorPara = 0;
			
					if(comprDe.equals("Metro") && comprPara.equals("Milimetro")) {
						valorPara = valorDe * 1000;
						
					}
					else if(comprDe.equals("Milimetro") && comprPara.equals("Metro")){
						 valorPara = valorDe / 1000;
					}
					else {
						JOptionPane mess = new JOptionPane();
						mess.showMessageDialog(null,"Conversão Impossível");
					}
					jTextCompr2.setText(String.valueOf(valorPara));
				}
			});
					
			
			painelComprimento.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));
			painelComprimento.add(labelCompr);
			painelComprimento.add(comboBoxCompr);
			painelComprimento.add(jTextCompr);
			painelComprimento.add(labelCompr2);
			painelComprimento.add(comboBoxCompr2);
			painelComprimento.add(jTextCompr2);
			painelComprimento.add(botaoCompr);
			
		add(tabPane);
		pack();
		show();
	}
	
	public static void main(String[] args) {
		Main frame = new Main();
		frame.setTitle("Nova Janela");
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	

    private static JPanel criarPanel(Color color, String texto) {
    	JPanel panel = new JPanel();
    	panel.setToolTipText(texto);
    	panel.setBackground(color);
    	panel.add(new JLabel(texto));
    	panel.setPreferredSize(new Dimension(500, 200));
    	return panel;
    }
		

	}