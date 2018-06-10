package br.com.fam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fam.model.Cliente;

public class DAOCliente implements DAOGenerico<Cliente> {

	private final String SQL_INCLUIR = "INSERT INTO cliente (nome, numero, telefone, endereco, email, renda, civil, nascimento, rg, cpf, cep, complemento, celular, sexo, bairro, estado, cidade, senha, saldo) Values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)";

	private final String SQL_LISTAR = "SELECT * FROM cliente";

	private final String SQL_EXCLUIR = "DELETE FROM cliente WHERE codigo=?";

	private final String SQL_ALTERAR = "UPDATE cliente SET nome=?, numero=?, telefone=?, endereco=?, email=?, renda=?, civil=?, nascimento=?, rg=?, cpf=?, cep=?, complemento=?, celular=?, sexo=?, bairro=?, estado=?,  serasa=?, spc=?, documentos=?, limite=?, cidade=?, senha=?, saldo=?  WHERE codigo=?";

	private final String SQL_BUSCAR = "SELECT * FROM cliente WHERE codigo=?";

	private final String SQL_BUSCAR_LOGIN = "SELECT * FROM cliente WHERE email=? and senha=?";

	private Connection conexao;

	public DAOCliente() {
		conexao = FabricaDeConexao.solicitarConexao();
	}

	@Override
	public void incluir(Cliente t) {

		try {
			PreparedStatement comando = conexao.prepareStatement(SQL_INCLUIR);

			// TROCAR AS INTERROGAÇÕES PELOS VALORES

			comando.setString(1, t.getNome());
			comando.setInt(2, t.getNumero());
			comando.setString(3, t.getTelefone());
			comando.setString(4, t.getEndereco());
			comando.setString(5, t.getEmail());
			comando.setDouble(6, t.getRenda());
			comando.setString(7, t.getCivil());
			comando.setDate(8, new java.sql.Date(t.getNascimento().getTime()));
			comando.setString(9, t.getRg());
			comando.setString(10, t.getCpf());
			comando.setString(11, t.getCep());
			comando.setString(12, t.getComplemento());
			comando.setString(13, t.getCelular());
			comando.setBoolean(14, t.isSexo());
			comando.setString(15, t.getBairro());
			comando.setString(16, t.getEstado());
			comando.setString(17, t.getCidade());
			comando.setInt(18, t.getSenha());
			comando.setDouble(19, t.getSaldo());

			comando.executeUpdate();
			comando.close();
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
	}

	@Override
	public void excluir(Cliente t) {
		// TODO Auto-generated method stub
		excluir(t.getCodigo());
	}

	@Override
	public void excluir(long codigo) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement comando = conexao.prepareStatement(SQL_EXCLUIR);
			comando.setLong(1, codigo);
			comando.executeUpdate();
			comando.close();

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	@Override
	public void alterar(Cliente t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement comando = conexao.prepareStatement(SQL_ALTERAR);

			// TROCAR AS INTERROGAÇÕES PELOS VALORES

			comando.setString(1, t.getNome());
			comando.setInt(2, t.getNumero());
			comando.setString(3, t.getTelefone());
			comando.setString(4, t.getEndereco());
			comando.setString(5, t.getEmail());
			comando.setDouble(6, t.getRenda());
			comando.setString(7, t.getCivil());
			comando.setDate(8, new java.sql.Date(t.getNascimento().getTime()));
			comando.setString(9, t.getRg());
			comando.setString(10, t.getCpf());
			comando.setString(11, t.getCep());
			comando.setString(12, t.getComplemento());
			comando.setString(13, t.getCelular());
			comando.setBoolean(14, t.isSexo());
			comando.setString(15, t.getBairro());
			comando.setString(16, t.getEstado());
			comando.setBoolean(17, t.isSerasa());
			comando.setBoolean(18, t.isSpc());
			comando.setBoolean(19, t.isDocumentos());
			comando.setDouble(20, t.getLimite());
			comando.setString(21, t.getCidade());
			comando.setInt(22, t.getSenha());
			comando.setDouble(23, t.getSaldo());
			comando.setLong(24, t.getCodigo());

			comando.executeUpdate();
			comando.close();
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}

	}

	@Override
	public List<Cliente> listar() {

		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		try {
			PreparedStatement comando = conexao.prepareStatement(SQL_LISTAR);

			ResultSet dados = comando.executeQuery();

			while (dados.next()) {

				Cliente t = new Cliente();
				t.setCodigo(dados.getLong("codigo"));
				t.setNome(dados.getString("nome"));
				t.setNumero(dados.getInt("numero"));
				t.setTelefone(dados.getString("telefone"));
				t.setEndereco(dados.getString("endereco"));
				t.setEmail(dados.getString("email"));
				t.setRenda(dados.getDouble("renda"));
				t.setCivil(dados.getString("civil"));
				t.setNascimento(dados.getDate("nascimento"));
				t.setRg(dados.getString("rg"));
				t.setCpf(dados.getString("cpf"));
				t.setCep(dados.getString("cep"));
				t.setComplemento(dados.getString("complemento"));
				t.setCelular(dados.getString("celular"));
				t.setSexo(dados.getBoolean("sexo"));
				t.setBairro(dados.getString("bairro"));
				t.setEstado(dados.getString("estado"));
				t.setSerasa(dados.getBoolean("serasa"));
				t.setSpc(dados.getBoolean("spc"));
				t.setDocumentos(dados.getBoolean("documentos"));
				t.setLimite(dados.getDouble("limite"));
				t.setSerasa(dados.getBoolean("serasa"));
				t.setSpc(dados.getBoolean("Spc"));
				t.setDocumentos(dados.getBoolean("documentos"));
				t.setLimite(dados.getDouble("limite"));
				t.setCidade(dados.getString("cidade"));
				t.setSaldo(dados.getDouble("saldo"));
				cliente.add(t);
			}

			dados.close();
			comando.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro lendo o arquivo");
		}
		return cliente;
	}

	@Override
	public Cliente buscar(long codigo) {
		Cliente t = null;
		try {
			PreparedStatement comando = conexao.prepareStatement(SQL_BUSCAR);
			comando.setLong(1, codigo);
			ResultSet dados = comando.executeQuery();
			if (dados.next()) {
				t = new Cliente();
				t.setCodigo(dados.getLong("codigo"));
				t.setNome(dados.getString("nome"));
				t.setNumero(dados.getInt("numero"));
				t.setTelefone(dados.getString("telefone"));
				t.setEndereco(dados.getString("endereco"));
				t.setEmail(dados.getString("email"));
				t.setRenda(dados.getDouble("renda"));
				t.setCivil(dados.getString("civil"));
				t.setNascimento(dados.getDate("nascimento"));
				t.setRg(dados.getString("rg"));
				t.setCpf(dados.getString("cpf"));
				t.setCep(dados.getString("cep"));
				t.setComplemento(dados.getString("complemento"));
				t.setCelular(dados.getString("celular"));
				t.setSexo(dados.getBoolean("sexo"));
				t.setBairro(dados.getString("bairro"));
				t.setEstado(dados.getString("estado"));
				t.setSerasa(dados.getBoolean("serasa"));
				t.setSpc(dados.getBoolean("spc"));
				t.setDocumentos(dados.getBoolean("documentos"));
				t.setLimite(dados.getDouble("limite"));
				t.setCidade(dados.getString("cidade"));
				t.setSaldo(dados.getDouble("saldo"));
			}
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
		return t;
	}

	public Cliente buscarLogin(String email, int senha) {
		Cliente t = null;
		try {
			PreparedStatement comando = conexao.prepareStatement(SQL_BUSCAR_LOGIN);
			comando.setString(1, email);
			comando.setInt(2, senha);
			ResultSet dados = comando.executeQuery();
			if (dados.next()) {
				t = new Cliente();
				t.setCodigo(dados.getLong("codigo"));
				t.setNome(dados.getString("nome"));
				t.setNumero(dados.getInt("numero"));
				t.setTelefone(dados.getString("telefone"));
				t.setEndereco(dados.getString("endereco"));
				t.setEmail(dados.getString("email"));
				t.setRenda(dados.getDouble("renda"));
				t.setCivil(dados.getString("civil"));
				t.setNascimento(dados.getDate("nascimento"));
				t.setRg(dados.getString("rg"));
				t.setCpf(dados.getString("cpf"));
				t.setCep(dados.getString("cep"));
				t.setComplemento(dados.getString("complemento"));
				t.setCelular(dados.getString("celular"));
				t.setSexo(dados.getBoolean("sexo"));
				t.setBairro(dados.getString("bairro"));
				t.setEstado(dados.getString("estado"));
				t.setSerasa(dados.getBoolean("serasa"));
				t.setSpc(dados.getBoolean("spc"));
				t.setDocumentos(dados.getBoolean("documentos"));
				t.setLimite(dados.getDouble("limite"));
				t.setCidade(dados.getString("cidade"));
				t.setSenha(dados.getInt("senha"));
				t.setSaldo(dados.getDouble("saldo"));

			}
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
		return t;
	}

}
