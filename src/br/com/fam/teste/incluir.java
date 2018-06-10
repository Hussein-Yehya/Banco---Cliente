package br.com.fam.teste;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class incluir {

	public static void main(String[] args) {
		
		Cliente p = new Cliente();
		
		p.setNome("Teste8");
		p.setTelefone("1231-9555");
		p.setNumero(3231);
		p.setEndereco("Ouchi");
		p.setEmail("ANA@outlook.com");
		p.setRenda(45.25);
		p.setCivil("1");
		p.setNascimento( new Date());
		p.setRg("231231");
		p.setCpf("43798775803");
		p.setCep("02211-010");
		p.setComplemento("Casa");
		p.setCelular("11 252151");
		p.setSexo(false);
		p.setBairro("Luz Paulista");
		p.setEstado("SP");
		p.setSerasa(true);
		p.setSpc(true);
		p.setDocumentos(false);
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat f = new SimpleDateFormat("hh:mm");
        System.out.println(p + " :" +f.format(date));
        
		
		DAOCliente bdCliente = new DAOCliente();
		
		bdCliente.incluir(p);
		
		
		

		
	}
}
