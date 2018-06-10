package br.com.fam.teste;

import org.lavieri.modelutil.cep.WebServiceCep;

/**
 * Apenas um teste
 * 
 * @author Tomaz Lavieri
 */
public class TesteCep {

	public static void main(String[] args) {
		// Faz a busca para o cep 58043-280
		WebServiceCep webServiceCep = WebServiceCep.searchCep("02441-010");
		// A ferramenta de busca ignora qualquer caracter que não seja número.

		// caso a busca ocorra bem, imprime os resultados.
		if (webServiceCep.wasSuccessful()) {
			System.out.println("Cep: " + webServiceCep.getCep());
			System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
			System.out.println("Bairro: " + webServiceCep.getBairro());
			System.out.println("Cidade: " + webServiceCep.getCidade());
			System.out.println("Estado: " + webServiceCep.getUf());
			// caso haja problemas imprime as exceções.
		} else {
			System.out.println("Erro número: " + webServiceCep.getResulCode());
			System.out.println("Descrição do erro: " + webServiceCep.getResultText());
		}

	}
}
