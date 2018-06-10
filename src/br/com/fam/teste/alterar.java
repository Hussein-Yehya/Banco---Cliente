package br.com.fam.teste;

import java.util.Date;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class alterar {
	public static void main(String[] args) {

		
		Cliente p = new Cliente();		
		p.setCodigo(5);
		p.setNome("ANA");
		p.setNascimento(new Date());
	
		DAOCliente bdCliente = new DAOCliente();
		
		bdCliente.alterar(p);
		
		System.out.println(bdCliente);
		
		
	
	}
}
