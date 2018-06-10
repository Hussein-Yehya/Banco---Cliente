package br.com.fam.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.DoubleUnaryOperator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.lavieri.modelutil.cep.WebServiceCep;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;
import br.com.fam.model.TableModelCliente;

@SuppressWarnings("serial")
public class PainelUsuario extends JPanel {
	private JLabel lblSenha, lblConfirmarSenha, lblNome, lblRG, lblCPF, lblEmail, lblConfirmeEmail, lblCidade,
			lblEndereco, lblTelefone, lblSexo, lblNumero, lblEstadoCivil, lblNascimento, lblRenda, lblCep,
			lblComplemento, lblCelular, lblConfirmeCelular, lblBairro, lblEstado, lblLimite, lblSaldo;
	private JPanel pnlDadosPessoais, pnlEndereco, pnlContato, pnlAutenticar, pnlNotificacoes, pnlSaldo;
	private JRadioButton rbtMasculino, rbtFeminino;
	private JTextField txtSenha, txtConfirmarSenha, txtNome, txtRG, txtCPF, txtTelefone, txtNascimento, txtBairro,
			txtCidade, txtNumero, txtEmail, txtConfirmarEmail, txtRenda, txtCep, txtComplemento, txtCelular,
			txtConfirmarCelular, txtEndereco, txtEstado, txtLimite, txtSaldo;

	private JButton btnSalvar, btnAlterar;
	private Font fontePadrao;
	private JComboBox<String> cbxEstadoCivil;
	private JTable tblCliente;
	private TableModelCliente modelCliente;
	private DAOCliente bdCliente;
	private JScrollPane pnlRolagem3;
	private Cliente clienteSelecionado;
	private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private JMenuBar menuBarra;
	private JMenu fileMenu, editMenu, searchMenu;
	private JMenuItem menuNovo, menuAbrir, menuAlterar, menuSalvar, menuSair, menuProcurar;

	private String regExCep = "[0-9]{5}-[0-9]{3}";
	private String regExEmail = "[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]";
	private String regExData = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
	private String regExCpf = "[1-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";
	private String regExRg = "[1-9]{2}.[0-9]{3}.[0-9]{3}-[0-9]{1}";

	public PainelUsuario() {
		bdCliente = new DAOCliente();
		iniciarComponentes();
		iniciarAcoes();
	}

	public PainelUsuario(Cliente t) {
		bdCliente = new DAOCliente();
		iniciarComponentes();
		iniciarAcoes();
		clienteSelecionado = t;
		preeencherFormulario();
	}

	private void iniciarComponentes() {

		menuBarra = new JMenuBar();

		// Define e adiciona dois menus drop down na barra de menus
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		searchMenu = new JMenu("Search");

		menuBarra.add(fileMenu);
		menuBarra.add(editMenu);
		menuBarra.add(searchMenu);

		// Cria e adiciona um item simples para o menu
		ImageIcon imgNovo = new ImageIcon("imagens/menuNovo.png");
		menuNovo = new JMenuItem(imgNovo);
		menuNovo.setToolTipText("Novo arquivo");
		fileMenu.add(menuNovo);

		ImageIcon imgAbrir = new ImageIcon("imagens/menuAbrir.png");
		menuAbrir = new JMenuItem(imgAbrir);
		menuAbrir.setToolTipText("Abrir arquivo");
		fileMenu.add(menuAbrir);

		ImageIcon imgSalvar = new ImageIcon("imagens/menuSalvar.png");
		menuSalvar = new JMenuItem(imgSalvar);
		menuSalvar.setToolTipText("Salvar arquivo");
		fileMenu.add(menuSalvar);

		ImageIcon imgSair = new ImageIcon("imagens/menuSair.png");
		menuSair = new JMenuItem(imgSair);
		menuSair.setToolTipText("Sair");
		fileMenu.add(menuSair);

		ImageIcon imgEditar = new ImageIcon("imagens/menuEditar.png");
		menuAlterar = new JMenuItem(imgEditar);
		menuAlterar.setToolTipText("Editar arquivo");
		editMenu.add(menuAlterar);

		ImageIcon imgProcurar = new ImageIcon("imagens/menuProcurar.png");
		menuProcurar = new JMenuItem(imgProcurar);
		menuProcurar.setToolTipText("Procurar");
		searchMenu.add(menuProcurar);

		//
		// JFONT
		//
		fontePadrao = new Font("Calibri", Font.PLAIN, 20);

		//
		// JLabel lblNome, lblRG, lblCPF, lblPerecivel
		//
		lblNome = new JLabel("Nome completo:");
		lblNome.setBounds(10, 30, 145, 50);
		lblNome.setFont(fontePadrao);
		lblNome.setForeground(Color.black);

		txtNome = new JTextField();
		txtNome.setBounds(155, 35, 330, 30);
		txtNome.setFont(fontePadrao);

		lblRG = new JLabel("RG:");
		lblRG.setLocation(845, 30);
		lblRG.setSize(100, 50);
		lblRG.setFont(fontePadrao);
		lblRG.setForeground(Color.black);

		txtRG = new JTextField();
		txtRG.setBounds(880, 35, 150, 30);
		txtRG.setFont(fontePadrao);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setLocation(10, 80);
		lblSexo.setSize(100, 50);
		lblSexo.setFont(fontePadrao);
		lblSexo.setForeground(Color.black);

		lblRenda = new JLabel("Renda:");
		lblRenda.setBounds(520, 80, 100, 50);
		lblRenda.setFont(fontePadrao);
		lblRenda.setForeground(Color.black);

		txtRenda = new JTextField();
		txtRenda.setBounds(585, 85, 150, 30);
		txtRenda.setFont(fontePadrao);

		lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(770, 80, 120, 50);
		lblNascimento.setFont(fontePadrao);
		lblNascimento.setForeground(Color.black);

		txtNascimento = new JTextField();
		txtNascimento.setBounds(880, 85, 150, 30);
		txtNascimento.setFont(fontePadrao);

		lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setLocation(225, 80);
		lblEstadoCivil.setSize(110, 50);
		lblEstadoCivil.setFont(fontePadrao);
		lblEstadoCivil.setForeground(Color.black);

		lblCPF = new JLabel("CPF:");
		lblCPF.setLocation(545, 30);
		lblCPF.setSize(100, 50);
		lblCPF.setFont(fontePadrao);
		lblCPF.setForeground(Color.black);

		txtCPF = new JTextField();
		txtCPF.setBounds(585, 35, 150, 30);
		txtCPF.setFont(fontePadrao);

		lblEstado = new JLabel("Estado:");
		lblEstado.setLocation(450, 90);
		lblEstado.setSize(150, 50);
		lblEstado.setFont(fontePadrao);
		lblEstado.setForeground(Color.black);

		txtEstado = new JTextField();
		txtEstado.setBounds(520, 100, 80, 30);
		txtEstado.setFont(fontePadrao);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setLocation(10, 90);
		lblCidade.setSize(100, 50);
		lblCidade.setFont(fontePadrao);
		lblCidade.setForeground(Color.black);

		txtCidade = new JTextField();
		txtCidade.setBounds(80, 100, 200, 30);
		txtCidade.setFont(fontePadrao);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setLocation(15, 30);
		lblEmail.setSize(100, 50);
		lblEmail.setFont(fontePadrao);
		lblEmail.setForeground(Color.black);

		txtEmail = new JTextField();
		txtEmail.setBounds(80, 40, 270, 30);
		txtEmail.setFont(fontePadrao);

		lblConfirmeEmail = new JLabel("Confirmar E-mail:");
		lblConfirmeEmail.setLocation(365, 30);
		lblConfirmeEmail.setSize(170, 50);
		lblConfirmeEmail.setFont(fontePadrao);
		lblConfirmeEmail.setForeground(Color.black);

		txtConfirmarEmail = new JTextField();
		txtConfirmarEmail.setBounds(520, 40, 270, 30);
		txtConfirmarEmail.setFont(fontePadrao);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setLocation(820, 30);
		lblTelefone.setSize(100, 50);
		lblTelefone.setFont(fontePadrao);
		lblTelefone.setForeground(Color.black);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(910, 40, 120, 30);
		txtTelefone.setFont(fontePadrao);

		lblCelular = new JLabel("Celular:");
		lblCelular.setLocation(10, 75);
		lblCelular.setSize(100, 50);
		lblCelular.setFont(fontePadrao);
		lblCelular.setForeground(Color.black);

		txtCelular = new JTextField();
		txtCelular.setBounds(80, 84, 135, 30);
		txtCelular.setFont(fontePadrao);

		lblConfirmeCelular = new JLabel("Confirmar Celular:");
		lblConfirmeCelular.setLocation(360, 75);
		lblConfirmeCelular.setSize(170, 50);
		lblConfirmeCelular.setFont(fontePadrao);
		lblConfirmeCelular.setForeground(Color.black);

		txtConfirmarCelular = new JTextField();
		txtConfirmarCelular.setBounds(520, 84, 135, 30);
		txtConfirmarCelular.setFont(fontePadrao);

		lblCep = new JLabel("CEP:");
		lblCep.setLocation(35, 10);
		lblCep.setSize(100, 50);
		lblCep.setFont(fontePadrao);
		lblCep.setForeground(Color.black);

		txtCep = new JTextField();
		txtCep.setBounds(80, 20, 200, 30);
		txtCep.setFont(fontePadrao);

		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setLocation(430, 10);
		lblEndereco.setSize(100, 50);
		lblEndereco.setFont(fontePadrao);
		lblEndereco.setForeground(Color.black);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(520, 20, 510, 30);
		txtEndereco.setFont(fontePadrao);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setLocation(15, 50);
		lblBairro.setSize(100, 50);
		lblBairro.setFont(fontePadrao);
		lblBairro.setForeground(Color.black);

		txtBairro = new JTextField();
		txtBairro.setBounds(80, 60, 200, 30);
		txtBairro.setFont(fontePadrao);

		lblNumero = new JLabel("Número:");
		lblNumero.setLocation(440, 50);
		lblNumero.setSize(100, 50);
		lblNumero.setFont(fontePadrao);
		lblNumero.setForeground(Color.black);

		txtNumero = new JTextField();
		txtNumero.setBounds(520, 60, 80, 30);
		txtNumero.setFont(fontePadrao);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setLocation(630, 50);
		lblComplemento.setSize(150, 50);
		lblComplemento.setFont(fontePadrao);
		lblComplemento.setForeground(Color.black);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(760, 60, 270, 30);
		txtComplemento.setFont(fontePadrao);

		lblSenha = new JLabel("Senha:");
		lblSenha.setLocation(10, 15);
		lblSenha.setSize(100, 50);
		lblSenha.setFont(fontePadrao);
		lblSenha.setForeground(Color.black);

		lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setLocation(300, 15);
		lblConfirmarSenha.setSize(170, 50);
		lblConfirmarSenha.setFont(fontePadrao);
		lblConfirmarSenha.setForeground(Color.black);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(80, 25, 200, 30);

		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(460, 25, 200, 30);
		
		lblLimite = new JLabel("Limite:");
		lblLimite.setBounds(10, 15, 100, 50);
		lblLimite.setFont(fontePadrao);
		lblLimite.setForeground(Color.black);
		
		
		txtLimite = new JTextField();
		txtLimite.setBounds(80, 20, 200, 30);
		txtLimite.setEnabled(false);
		txtLimite.setFont(fontePadrao);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(400, 15, 100, 50);
		lblSaldo.setFont(fontePadrao);
		lblSaldo.setForeground(Color.black);
		
		
		
		txtSaldo = new JTextField();
		txtSaldo.setBounds(460, 20, 200, 30);
		txtSaldo.setEnabled(false);
		txtSaldo.setFont(fontePadrao);
		

		//
		// cbxEstadoCivil
		//
		cbxEstadoCivil = new JComboBox<String>();
		cbxEstadoCivil.setLocation(335, 85);
		cbxEstadoCivil.setSize(150, 30);
		cbxEstadoCivil.addItem("Casado(a)");
		cbxEstadoCivil.addItem("Solteiro(a)");
		cbxEstadoCivil.addItem("Divorciado(a)");
		cbxEstadoCivil.addItem("Viúvo(a)");
		cbxEstadoCivil.setForeground(Color.black);

		//
		// rbtMasculino
		//
		rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setBounds(60, 80, 130, 25);
		rbtMasculino.setFont(fontePadrao);
		rbtMasculino.setBackground(Color.decode("#698495"));
		rbtMasculino.setForeground(Color.black);
		rbtMasculino.setSelected(true);

		//
		// rbtFeminino
		//
		rbtFeminino = new JRadioButton("Feminino");
		rbtFeminino.setBounds(60, 105, 130, 25);
		rbtFeminino.setFont(fontePadrao);
		rbtFeminino.setBackground(Color.decode("#698495"));
		rbtFeminino.setForeground(Color.black);

		//
		// ButtonGroup Opções
		//
		ButtonGroup grpOpcao = new ButtonGroup();
		grpOpcao.add(rbtMasculino);
		grpOpcao.add(rbtFeminino);

		ImageIcon img03 = new ImageIcon("imagens/salvar.png");
		btnSalvar = new JButton(img03);
		btnSalvar.setLocation(920, 490);
		btnSalvar.setSize(140, 90);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setBorderPainted(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(Color.decode("#172D3A"));
		btnSalvar.setToolTipText("SALVAR");

		ImageIcon img05 = new ImageIcon("imagens/alterar.png");
		btnAlterar = new JButton(img05);
		btnAlterar.setLocation(920, 580);
		btnAlterar.setSize(140, 90);
		btnAlterar.setBackground(Color.decode("#172D3A"));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setFocusPainted(false);
		btnAlterar.setToolTipText("ALTERAR");

		//
		// JTable tblCliente
		//
		modelCliente = new TableModelCliente();

		modelCliente.atualizarModelo();
		tblCliente = new JTable(modelCliente);
		tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		pnlRolagem3 = new JScrollPane(tblCliente);
		pnlRolagem3.setBounds(10, 530, 900, 200);
		pnlRolagem3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		Border linhaAutenticar = BorderFactory.createLineBorder(Color.BLACK);
		pnlAutenticar = new JPanel();
		pnlAutenticar.setBounds(10, 490, 900, 90);
		pnlAutenticar.setLayout(null);
		pnlAutenticar.setBorder(new TitledBorder(linhaAutenticar, "Dados de segurança"));
		pnlAutenticar.add(lblSenha);
		pnlAutenticar.add(lblConfirmarSenha);
		pnlAutenticar.add(txtSenha);
		pnlAutenticar.add(txtConfirmarSenha);
		pnlAutenticar.setBackground(Color.decode("#698495"));
		
		Border linhaSaldo = BorderFactory.createLineBorder(Color.BLACK);
		pnlSaldo = new JPanel();
		pnlSaldo.setBounds(10, 590, 900, 90);
		pnlSaldo.setLayout(null);
		pnlSaldo.setBorder(new TitledBorder(linhaSaldo, "Saldo"));
		pnlSaldo.add(lblLimite);
		pnlSaldo.add(txtLimite);
		pnlSaldo.add(lblSaldo);
		pnlSaldo.add(txtSaldo);
		pnlSaldo.setBackground(Color.decode("#698495"));

		Border linhaDados = BorderFactory.createLineBorder(Color.BLACK);
		pnlDadosPessoais = new JPanel();
		pnlDadosPessoais.setLocation(10, 10);
		pnlDadosPessoais.setLayout(null);
		pnlDadosPessoais.setBorder(new TitledBorder(linhaDados, "Dados pessoais"));
		pnlDadosPessoais.setSize(1050, 150);
		pnlDadosPessoais.add(lblNome);
		pnlDadosPessoais.add(txtNome);
		pnlDadosPessoais.add(lblRG);
		pnlDadosPessoais.add(txtRG);
		pnlDadosPessoais.add(lblCPF);
		pnlDadosPessoais.add(txtCPF);
		pnlDadosPessoais.add(lblSexo);
		pnlDadosPessoais.add(lblRenda);
		pnlDadosPessoais.add(txtRenda);
		pnlDadosPessoais.add(lblEstadoCivil);
		pnlDadosPessoais.add(rbtMasculino);
		pnlDadosPessoais.add(lblNascimento);
		pnlDadosPessoais.add(cbxEstadoCivil);
		pnlDadosPessoais.add(rbtFeminino);
		pnlDadosPessoais.add(lblNascimento);
		pnlDadosPessoais.add(txtNascimento);

		pnlDadosPessoais.setBackground(Color.decode("#698495"));

		Border linhaDados1 = BorderFactory.createLineBorder(Color.BLACK);
		pnlEndereco = new JPanel();
		pnlEndereco.setLocation(10, 170);
		pnlEndereco.setLayout(null);
		pnlEndereco.setBorder(new TitledBorder(linhaDados1, "Endereço"));
		pnlEndereco.setSize(1050, 150);
		pnlEndereco.add(lblCep);
		pnlEndereco.add(txtCep);
		pnlEndereco.add(lblEndereco);
		pnlEndereco.add(txtEndereco);
		pnlEndereco.add(lblBairro);
		pnlEndereco.add(txtBairro);
		pnlEndereco.add(lblNumero);
		pnlEndereco.add(txtNumero);
		pnlEndereco.add(lblComplemento);
		pnlEndereco.add(txtComplemento);
		pnlEndereco.add(lblEstado);
		pnlEndereco.add(txtEstado);
		pnlEndereco.add(lblCidade);
		pnlEndereco.add(txtCidade);
		pnlEndereco.setBackground(Color.decode("#698495"));

		Border linhaDados2 = BorderFactory.createLineBorder(Color.BLACK);
		pnlContato = new JPanel();
		pnlContato.setLocation(10, 330);
		pnlContato.setLayout(null);
		pnlContato.setBorder(new TitledBorder(linhaDados2, "Contato"));
		pnlContato.setSize(1050, 150);
		pnlContato.add(lblEmail);
		pnlContato.add(txtEmail);
		pnlContato.add(lblConfirmeEmail);
		pnlContato.add(txtConfirmarEmail);
		pnlContato.add(lblTelefone);
		pnlContato.add(txtTelefone);
		pnlContato.add(lblCelular);
		pnlContato.add(txtCelular);
		pnlContato.add(lblConfirmeCelular);
		pnlContato.add(txtConfirmarCelular);
		pnlContato.setBackground(Color.decode("#698495"));
		//
		// JPanel pnlNotificacoes
		//
		pnlNotificacoes = new JPanel();
		pnlNotificacoes.setLayout(null);
		pnlNotificacoes.setLocation(200, 770);
		pnlNotificacoes.setSize(1085, 70);

		pnlNotificacoes.setBackground(Color.decode("#172D3A"));

		//
		// JPanel this
		//

		this.setLayout(null);
		this.setLocation(200, 10);
		this.setSize(1085, 750);
		this.setBackground(Color.decode("#172D3A"));
		this.add(pnlDadosPessoais);
		this.add(pnlEndereco);
		this.add(pnlContato);
		this.add(btnSalvar);
		this.add(btnAlterar);
		this.add(pnlSaldo);
		this.add(pnlAutenticar);
		this.add(menuBarra);
		this.add(pnlNotificacoes);

	}

	public void iniciarAcoes() {

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtNome.getText().isEmpty() || txtNumero.getText().isEmpty() || txtTelefone.getText().isEmpty()
						|| txtEndereco.getText().isEmpty() || txtEmail.getText().isEmpty()
						|| txtRenda.getText().isEmpty() || txtRG.getText().isEmpty() || txtCPF.getText().isEmpty()
						|| txtCep.getText().isEmpty() || txtComplemento.getText().isEmpty()
						|| txtCelular.getText().isEmpty() || txtConfirmarCelular.getText().isEmpty()
						|| txtBairro.getText().isEmpty() || txtEstado.getText().isEmpty()
						|| !txtNascimento.getText().matches(regExData) || !txtEmail.getText().matches(regExEmail)
						|| !txtCep.getText().matches(regExCep)
						|| !txtEmail.getText().equals(txtConfirmarEmail.getText())
						|| !txtCelular.getText().equals(txtConfirmarCelular.getText())
						|| !txtSenha.getText().equals(txtConfirmarSenha.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				} else {
					
					Cliente p = new Cliente();

					// data
					try {
						Date date = (Date) formatter.parse(txtNascimento.getText());
						p.setNascimento(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					p.setNome(txtNome.getText());
					p.setRenda(Double.parseDouble(txtRenda.getText().replace(",", ".")));
					p.setNumero(Integer.parseInt(txtNumero.getText()));
					p.setTelefone(txtTelefone.getText());
					p.setEndereco(txtEndereco.getText());
					p.setEmail(txtEmail.getText());
					p.setRg(txtRG.getText());
					p.setCpf(txtCPF.getText());
					p.setCep(txtCep.getText());
					p.setComplemento(txtComplemento.getText());
					p.setCelular(txtCelular.getText());
					p.setBairro(txtBairro.getText());
					p.setEstado(txtEstado.getText());
					p.setSexo(rbtMasculino.isSelected());
					p.setCivil(String.valueOf(cbxEstadoCivil.getSelectedItem()));
					p.setCidade(txtCidade.getText());
					p.setSenha(Integer.parseInt(txtSenha.getText()));
					p.setSaldo(Double.parseDouble(txtSaldo.getText()));
					p.setLimite(Double.parseDouble(txtLimite.getText()));

					// Salvar o Cliente
					DAOCliente bdCliente = new DAOCliente();
					bdCliente.incluir(p);
					modelCliente.atualizarModelo();

					limparFormulario();
				}
			}

		});

		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// criar um objeto com os dados da tela

				try {
					Date date = (Date) formatter.parse(txtNascimento.getText());
					clienteSelecionado.setNascimento(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clienteSelecionado.setNome(txtNome.getText());
				clienteSelecionado.setRenda(Double.parseDouble(txtRenda.getText()));
				clienteSelecionado.setNumero(Integer.parseInt(txtNumero.getText()));
				clienteSelecionado.setTelefone(txtTelefone.getText());
				clienteSelecionado.setEndereco(txtEndereco.getText());
				clienteSelecionado.setEmail(txtEmail.getText());
				clienteSelecionado.setRg(txtRG.getText());
				clienteSelecionado.setCpf(txtCPF.getText());
				clienteSelecionado.setCep(txtCep.getText());
				clienteSelecionado.setComplemento(txtComplemento.getText());
				clienteSelecionado.setCelular(txtCelular.getText());
				clienteSelecionado.setBairro(txtBairro.getText());
				clienteSelecionado.setEstado(txtEstado.getText());
				clienteSelecionado.setSexo(rbtMasculino.isSelected());
				clienteSelecionado.setCidade(txtCidade.getText());
				clienteSelecionado.setSaldo(Double.parseDouble(txtSaldo.getText()));
				clienteSelecionado.setLimite(Double.parseDouble(txtLimite.getText()));

				clienteSelecionado.setCivil(String.valueOf(cbxEstadoCivil.getSelectedItem()));
				clienteSelecionado.setCivil(String.valueOf(cbxEstadoCivil.getItemCount()));

				switch (clienteSelecionado.getCivil()) {
				case "0":
					cbxEstadoCivil.setSelectedIndex(0);
					break;

				case "1":
					cbxEstadoCivil.setSelectedIndex(1);
					break;
				case "2":
					cbxEstadoCivil.setSelectedIndex(2);
					break;

				case "3":
					cbxEstadoCivil.setSelectedIndex(3);
				}

				// Salvar o Cliente
				bdCliente.alterar(clienteSelecionado);
				clienteSelecionado = null;
				limparFormulario();
				modelCliente.atualizarModelo();
			}
		});

		txtNome.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtNascimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtCep.requestFocus();
			}
		});

		txtNome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtCPF.requestFocus();
			}
		});

		txtCPF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtRG.requestFocus();
			}
		});

		txtCPF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (!txtCPF.getText().matches(regExCpf)) {
					JOptionPane.showMessageDialog(null, "Formato inválido de CPF. Ex: 000.000.000-00");
					txtRG.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		txtRG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtRenda.requestFocus();
			}
		});
		
		txtRG.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (!txtRG.getText().matches(regExRg)) {
					JOptionPane.showMessageDialog(null, "Formato inválido de RG. Ex: 00.000.000-0");
					txtRenda.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		txtRenda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNascimento.requestFocus();
			}
		});

		txtCep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtEndereco.requestFocus();
			}
		});

		txtEndereco.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtBairro.requestFocus();
			}
		});

		txtBairro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNumero.requestFocus();
			}
		});

		txtNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtComplemento.requestFocus();
			}
		});

		txtComplemento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtEstado.requestFocus();
			}
		});

		txtEstado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtCidade.requestFocus();
			}
		});

		txtCidade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtEmail.requestFocus();
			}
		});

		txtEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtConfirmarEmail.requestFocus();
			}
		});

		txtConfirmarEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtTelefone.requestFocus();
			}
		});

		txtTelefone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtCelular.requestFocus();
			}
		});

		txtCelular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtConfirmarCelular.requestFocus();
			}
		});

		txtNascimento.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

				try {
					if (!txtNascimento.getText().matches(regExData)) {
						JOptionPane.showMessageDialog(null, "Formato inválido para data.");
						txtNascimento.requestFocus();
					} else {
						Date nascimento = new Date();
						nascimento = formatador.parse(txtNascimento.getText());
						// Mostrart para o usuário como ficou a data depois de
						// convertida
						txtNascimento.setText(formatador.format(nascimento));
						txtCep.requestFocus();
					}
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Valor inválido para data.");
					txtNascimento.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		txtEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (!txtEmail.getText().matches(regExEmail)) {
					JOptionPane.showMessageDialog(null, "Formato inválido de email.");
					txtNascimento.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		txtCep.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (!txtCep.getText().matches(regExCep)) {
					JOptionPane.showMessageDialog(null, "Formato inválido de CEP.");
					txtNascimento.requestFocus();
				} else {
					// Faz a busca para o cep 58043-280
					WebServiceCep webServiceCep = WebServiceCep.searchCep(txtCep.getText());
					// A ferramenta de busca ignora qualquer caracter que não
					// seja número.

					// caso a busca ocorra bem, imprime os resultados.
					if (webServiceCep.wasSuccessful()) {
						txtEndereco.setText(webServiceCep.getLogradouroFull());
						txtBairro.setText(webServiceCep.getBairro());
						txtCidade.setText(webServiceCep.getCidade());
						txtEstado.setText(webServiceCep.getUf());
						// caso haja problemas imprime as exceções.
					} else {
						System.out.println("Erro número: " + webServiceCep.getResulCode());
						System.out.println("Descrição do erro: " + webServiceCep.getResultText());
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

	}

	private void limparFormulario() {
		txtNome.setText("");
		txtRG.setText("");
		txtCPF.setText("");
		txtCelular.setText("");
		txtConfirmarCelular.setText("");
		txtEmail.setText("");
		txtConfirmarEmail.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtBairro.setText("");
		txtComplemento.setText("");
		txtRenda.setText("");
		txtEstado.setText("");
		txtCep.setText("");
		txtNumero.setText("");
		txtNascimento.setText("");
		txtCidade.setText("");
		txtSenha.setText("");
		txtConfirmarSenha.setText("");

	}

	private void preeencherFormulario() {

		txtNome.setText(clienteSelecionado.getNome());
		txtCPF.setText(clienteSelecionado.getCpf());
		txtRG.setText(clienteSelecionado.getRg());
		txtRenda.setText(String.valueOf(clienteSelecionado.getRenda()));
		txtCep.setText(clienteSelecionado.getCep());
		txtEndereco.setText(clienteSelecionado.getEndereco());
		txtBairro.setText(clienteSelecionado.getBairro());
		txtNumero.setText(String.valueOf(clienteSelecionado.getNumero()));
		txtComplemento.setText(clienteSelecionado.getComplemento());
		txtEmail.setText(clienteSelecionado.getEmail());
		txtTelefone.setText(clienteSelecionado.getTelefone());
		txtCelular.setText(clienteSelecionado.getCelular());
		txtEstado.setText(clienteSelecionado.getEstado());
		txtNumero.setText(String.valueOf(clienteSelecionado.getNumero()));
		txtNascimento.setText(String.valueOf(formatter.format(clienteSelecionado.getNascimento())));
		cbxEstadoCivil.setSelectedItem(clienteSelecionado.getCivil());
		txtConfirmarEmail.setText(clienteSelecionado.getEmail());
		txtConfirmarCelular.setText(clienteSelecionado.getCelular());
		txtCidade.setText(clienteSelecionado.getCidade());
		
		txtSaldo.setText(String.valueOf(clienteSelecionado.getSaldo()));
		txtLimite.setText(String.valueOf(clienteSelecionado.getLimite()));

		if (clienteSelecionado.isSexo()) {
			rbtMasculino.setSelected(true);
			rbtFeminino.setSelected(false);
		} else {
			rbtMasculino.setSelected(false);
			rbtFeminino.setSelected(true);
		}
	}

}
