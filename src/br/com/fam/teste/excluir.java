package br.com.fam.teste;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class excluir {
	public static void main(String[] args) {

		// EXCLUIR OK !!! 
		
	Cliente p = new Cliente();
		
		p.setCodigo(1);
		
		DAOCliente bdCliente = new DAOCliente();
		
		bdCliente.excluir(p);
		
		System.out.println(bdCliente);
	}
}
