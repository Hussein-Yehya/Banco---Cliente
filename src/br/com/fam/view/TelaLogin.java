package br.com.fam.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class TelaLogin {
	private JFrame frmTela;
	private JPanel pnlPrincipal, pnlBotoes, pnlEditor, pnlLogin, pnlNotificacoes;
	private JButton btnCadastrar, btnSair, btnAcessar, btnAcessarNovamente;
	private JLabel  lblUsuario, lblTitulo, lblSubtitulo, lblFoto, lblLogin, lblSenha, lblNotificacao;
	private Font fonteTitulo, fonteSubTitulo, fontePadrao;
	private JMenuBar menuBarra;
	private JTextField txtLogin, txtSenha;
	private JMenu fileMenu;
	private JMenuItem menuSair;
	private DAOCliente bdCliente;

	private String regExSenha = "[0-9]{4,8}";

	public TelaLogin() {
		bdCliente = new DAOCliente();
		iniciarComponentes();
		iniciarAcoes();
	}

	private void iniciarComponentes() {

		menuBarra = new JMenuBar();

		 // Define e adiciona dois menus drop down na barra de menus
        fileMenu = new JMenu("File");
  
       
        menuBarra.add(fileMenu);
      
        
        // Cria e adiciona um item simples para o menu
 
        
        ImageIcon imgSair = new ImageIcon("imagens/menuSair.png");
         menuSair = new JMenuItem(imgSair);
         menuSair.setToolTipText("Sair");
        fileMenu.add(menuSair);

		//
		// JFONT
		//
		fonteTitulo = new Font("ARIAL", Font.PLAIN, 80);
		fonteSubTitulo = new Font("ARIAL", Font.ITALIC, 40);
		fontePadrao = new Font("Calibri", Font.PLAIN, 20);
		//
		// JLABEL TITULO
		//

		ImageIcon img05 = new ImageIcon("imagens/banco.png");
		lblFoto = new JLabel(img05);
		lblFoto.setBounds(425, 50, 250, 190);

		lblTitulo = new JLabel("BANCO IMPERIAL");
		lblTitulo.setBounds(230, 239, 900, 200);
		lblTitulo.setFont(fonteTitulo);
		lblTitulo.setForeground(Color.WHITE);

		lblSubtitulo = new JLabel("Sistema Bancário");
		lblSubtitulo.setBounds(390, 339, 900, 200);
		lblSubtitulo.setFont(fonteSubTitulo);
		lblSubtitulo.setForeground(Color.WHITE);

		lblNotificacao = new JLabel("Usuário: ");
		lblNotificacao.setBounds(10, 10, 110, 50);
		lblNotificacao.setFont(fontePadrao);
		lblNotificacao.setForeground(Color.WHITE);

		//
		// JPanel, pnlEditor
		//
		pnlEditor = new JPanel();
		pnlEditor.setBounds(200, 10, 50, 50);
		pnlEditor.setBackground(Color.decode("#172D3A"));

		//
		// JBUTTON btnSair
		//
		ImageIcon img02 = new ImageIcon("imagens/sair.png");
		btnSair = new JButton(img02);
		btnSair.setBounds(25, 670, 130, 130);
		btnSair.setToolTipText("SAIR");
		btnSair.setContentAreaFilled(false);
		btnSair.setBorderPainted(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(Color.decode("#698495"));

		//
		// JButton btnEntrar
		//
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setLocation(200, 10);
		btnCadastrar.setSize(48, 150);
		//
		// JLabels
		//
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(20, 10, 150, 30);
		lblLogin.setFont(fontePadrao);
		lblLogin.setForeground(Color.white);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(20, 50, 70, 30);
		lblSenha.setFont(fontePadrao);
		lblSenha.setForeground(Color.white);

		//
		// JTextFields
		//
		txtLogin = new JTextField();
		txtLogin.setBounds(80, 10, 250, 30);
		txtLogin.setFont(fontePadrao);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(80, 50, 250, 30);
		txtSenha.setFont(fontePadrao);

		lblUsuario = new JLabel();
		lblUsuario.setBounds(90, 20, 140, 30);
		lblUsuario.setBackground(Color.decode("#172D3A"));
		lblUsuario.setForeground(Color.white);
		lblUsuario.setFont(fontePadrao);

		//
		// JButtons
		//
		btnAcessar = new JButton("Acessar");
		btnAcessar.setLocation(205, 100);
		btnAcessar.setSize(125, 30);

		//
		// JButtons
		//
		btnAcessarNovamente = new JButton("Cadastrar");
		btnAcessarNovamente.setLocation(80, 100);
		btnAcessarNovamente.setSize(120, 30);

		// lbl DATA
		Date horas = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("hh:mm");
		JLabel lblData = new JLabel(df.format(horas));
		lblData.setBounds(1020, 20, 100, 25);
		lblData.setFont(fontePadrao);
		lblData.setForeground(Color.WHITE);

		// lbl dias
		Date dia = new Date();
		SimpleDateFormat dataDia;
		dataDia = new SimpleDateFormat("dd/MM/yyyy");
		JLabel lblDia = new JLabel(dataDia.format(dia));
		lblDia.setBounds(900, 20, 100, 25);
		lblDia.setFont(fontePadrao);
		lblDia.setForeground(Color.WHITE);

		//
		// JPanel pnlLogin
		//
		pnlLogin = new JPanel();
		pnlLogin.setLayout(null);
		pnlLogin.setLocation(375, 500);
		pnlLogin.setSize(400, 200);
		pnlLogin.setBackground(Color.decode("#172D3A"));
		pnlLogin.add(btnAcessar);
		pnlLogin.add(btnAcessarNovamente);
		pnlLogin.add(txtLogin);
		pnlLogin.add(txtSenha);
		pnlLogin.add(lblLogin);
		pnlLogin.add(lblSenha);

		//
		// JPanel pnlNotificacoes
		//
		pnlNotificacoes = new JPanel();
		pnlNotificacoes.setLayout(null);
		pnlNotificacoes.setLocation(200, 770);
		pnlNotificacoes.setSize(1085, 60);
		pnlNotificacoes.add(lblNotificacao);
		pnlNotificacoes.add(lblUsuario);
		pnlNotificacoes.add(lblDia);
		pnlNotificacoes.add(lblData);

		pnlNotificacoes.setBackground(Color.decode("#172D3A"));

		//
		// JPanel pnlBotoes
		//
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(null);
		pnlBotoes.setLocation(10, 10);
		pnlBotoes.setSize(180, 820);
		pnlBotoes.setBackground(Color.decode("#698495"));
		pnlBotoes.add(btnSair);

		//
		// JPanel pnlPricipal
		//
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(null);
		pnlPrincipal.setLocation(200, 10);
		pnlPrincipal.setSize(1085, 750);
		pnlPrincipal.add(lblFoto);
		pnlPrincipal.add(lblTitulo);
		pnlPrincipal.add(lblSubtitulo);
		pnlPrincipal.add(pnlLogin);
		pnlPrincipal.setBackground(Color.decode("#172D3A"));
		//
		// JFrame frmTela
		//
		frmTela = new JFrame();
		frmTela.setTitle("Sistema Bancário - Login");
		frmTela.setSize(1300, 900);
		frmTela.setLocationRelativeTo(null);
		frmTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTela.setResizable(false);
		frmTela.setLayout(null);
		frmTela.setJMenuBar(menuBarra);
		frmTela.getContentPane().add(pnlPrincipal);
		frmTela.getContentPane().add(pnlBotoes);
		frmTela.getContentPane().add(pnlNotificacoes);

		frmTela.setVisible(true);

	}

	public void iniciarAcoes() {

		menuSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frmTela, "Confirma saída?", "SAIR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(frmTela, "Confirma saída?", "SAIR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		btnAcessarNovamente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnlPrincipal.setVisible(false);
				pnlPrincipal = new PainelUsuario();
				frmTela.add(pnlPrincipal);
				pnlPrincipal.setVisible(true);

			}
		});

		btnAcessar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente t = null;

				if (txtSenha.getText().isEmpty() && txtLogin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else {
				
					t = bdCliente.buscarLogin(txtLogin.getText(), Integer.parseInt(txtSenha.getText()));

					
						if (t != null) {
							pnlPrincipal.setVisible(false);
							pnlPrincipal = new PainelUsuario(t);
							frmTela.add(pnlPrincipal);
							lblUsuario.setText(t.getNome());
							pnlPrincipal.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Email ou senha inválidos", "Aviso",
									JOptionPane.WARNING_MESSAGE);
						}
				}
				

			}
		});

		txtLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		

				if (txtLogin.getText().equals("admin")) {
					lblUsuario.setText("Administrador");
				} else {
					lblUsuario.setText("Cliente");
				}

				txtSenha.requestFocus();

			}
		});

		txtLogin.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (txtLogin.getText().equals("admin")) {
					lblUsuario.setText("Administrador");
				} else {
					lblUsuario.setText("Cliente");
				}

				txtSenha.requestFocus();

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		txtSenha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!txtSenha.getText().matches(regExSenha)) {
					JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
					txtSenha.requestFocus();
				}
				
			
				
			}
		});
		
		txtSenha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAcessar.doClick();
			}
		});


	}
}
