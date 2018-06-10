package br.com.fam.dao;

import java.sql.Connection;
import java.sql.DriverManager;




public class FabricaDeConexao {
	private static Connection conexao;
	// Driver do banco
		private final static String DRIVER = "com.mysql.jdbc.Driver";

		// endereço completo do banco 
		private final static String URL = "jdbc:mysql://127.0.0.1:3306/BD15218085";
		
		//private final static String URL = "jdbc:mysql://10.84.135.13:3306/ttgrupo05";

		// usuário de acesso ao banco
		private final static String USR = "root";

		// Senha do usuário
		private final static String PWD = "root";


	public static Connection solicitarConexao() {
		if (conexao == null) {
			// produzinod uma conexao
			try {
				Class.forName(DRIVER); // SERVE PARA REGISTRAR
				conexao = DriverManager.getConnection(URL, USR, PWD);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return conexao;
	}

}
