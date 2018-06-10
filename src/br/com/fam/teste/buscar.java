package br.com.fam.teste;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class buscar {
	public static void main(String[] args) {

		// buscar ok!! 
		
		DAOCliente bdCliente = new DAOCliente();
		
		Cliente p = bdCliente.buscar(1);
		System.out.println(p.getCodigo() + ":" + p.getNome() + " estado " + p.getEstado() + " CEP " + p.getCep());
		
		
		
	}
}
