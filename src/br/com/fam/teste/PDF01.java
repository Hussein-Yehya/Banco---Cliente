package br.com.fam.teste;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import br.com.fam.dao.DAOCliente;
import br.com.fam.model.Cliente;

public class PDF01 {

	public static final String DEST = "impressora//exemplo01.pdf";
	public static final String DOG = "imagens/cachorro.bmp";
	public static final String FOX = "imagens/raposa.bmp";

	public static void main(String arg[]) throws IOException {

		File dest = new File(DEST);
		dest.getParentFile().mkdirs();

		// Cria o escritor de PDF
		FileOutputStream fos = new FileOutputStream(dest);
		PdfWriter writer = new PdfWriter(fos);

		// Cria o documento PDF
		PdfDocument pdf = new PdfDocument(writer);

		// Inicializa o documento
		Document document = new Document(pdf);

		// Adiciona um parágrafo ao documento
		

	
		Paragraph p = new Paragraph("Imanges");
	
		
		DAOCliente bdCliente = new DAOCliente();
		new Cliente();
	

		int resposta;

		resposta = JOptionPane.showConfirmDialog(null, "Deseja relatar os negativados também?");
		if (resposta == JOptionPane.YES_OPTION) {

			for (Cliente c : bdCliente.listar()) {
				p.add(String.valueOf(c.getNome() + "\n"));
				p.add(String.valueOf(c.getCpf() + "\n"));
				p.add(String.valueOf(c.getRenda() + "\n"));
			}

		} else {

			for (Cliente c : bdCliente.listar()) {
				if (c.isDocumentos() == true && c.isSerasa() == true && c.isSpc() == true) {
					p.add(String.valueOf(c.getNome() + "\n"));
					p.add(String.valueOf(c.getCpf() + "\n"));
					p.add(String.valueOf(c.getRenda() + "\n"));
				}

			}

		}


	document.add(p);
	

		

		// Fecha o documento
		document.close();
	}
}
