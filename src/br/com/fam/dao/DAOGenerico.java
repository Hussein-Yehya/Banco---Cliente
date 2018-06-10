package br.com.fam.dao;

import java.util.List;

public interface DAOGenerico<T> {

	public void incluir(T t);
	public void excluir (T t);
	public void excluir (long codigo);
	public void alterar(T t);
	public List<T> listar();
	public T buscar(long codigo);

}
