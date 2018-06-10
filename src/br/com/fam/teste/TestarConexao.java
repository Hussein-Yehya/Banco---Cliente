package br.com.fam.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fam.dao.FabricaDeConexao;

public class TestarConexao {
	public static void main(String[] args) {
		Connection conexao = FabricaDeConexao.solicitarConexao();

		System.out.println("Conectado!");

		try {
			conexao.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
