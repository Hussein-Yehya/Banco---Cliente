package br.com.fam.teste;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class testarListaPostal {
	public static void main(String[] args) {

	
	DAOCliente bdCliente = new DAOCliente();
	
		
		
		System.out.println("inicio");

		for (Cliente p : bdCliente.listar()) {
			System.out.println("Cod: " + p.getCodigo() + " Nome " +p.getNome() + " numero " + 
		p.getNumero() + " telefone " + p.getTelefone() + " endereco " 
		+ p.getEndereco() + " email " + p.getEmail() + " renda " + p.getRenda() + " civil "
		+ p.getCivil() + " nascimento " + p.getNascimento() + " rg " + p.getRg() + " cpf " +
		p.getCpf() + " cep " + p.getCep() + " complemento " + p.getComplemento() + " celular " 
		+ p.getCelular() + " sexo " + p.isSexo() + " bairro " + p.getBairro() + " estado " + p.getEstado());
		}
		
		
	
		
		
		
		
		
	}
}
