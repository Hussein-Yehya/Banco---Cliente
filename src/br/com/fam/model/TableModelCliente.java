package br.com.fam.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.fam.dao.DAOCliente;

@SuppressWarnings("serial")
public class TableModelCliente extends AbstractTableModel {
	
	
	private DAOCliente bdCliente;
	private List<Cliente> dados;
	private String[] colunas = {"Nome","CPF"};
	public TableModelCliente() {
		bdCliente = new DAOCliente();
		dados = bdCliente.listar();
	}

	public Cliente getCliente(int linhaSelecionada) {
		if (linhaSelecionada >= 0) {
			return dados.get(linhaSelecionada);
		} else {
			return null;
		}
	}
	
	public void atualizarModelo() {
		dados = bdCliente.listar();
		fireTableDataChanged();
	}

	public String getColumnName(int idxColuna) {
		return colunas[idxColuna];
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return dados.get(rowIndex).getNome();

		case 1:
			return dados.get(rowIndex).getCpf();
	

		}
		return null;
	}

	
}
