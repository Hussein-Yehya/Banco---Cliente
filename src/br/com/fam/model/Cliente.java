package br.com.fam.model;

import java.util.Date;

public class Cliente {

	private long codigo;
	private String nome;
	private String telefone;
	private String endereco;
	private int numero;
	private String email;
	private double renda;
	private String civil;
	private String rg;
	private String cpf;
	private Date nascimento;
	private String cep;
	private String complemento;
	private String celular;
	private boolean sexo;
	private String bairro;
	private String estado;
	private boolean serasa;
	private boolean spc;
	private boolean documentos;
	private double limite;
	private String cidade;
	private int senha;
	private double saldo;
	
	
	
	

	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isSerasa() {
		return serasa;
	}

	public void setSerasa(boolean serasa) {
		this.serasa = serasa;
	}

	public boolean isSpc() {
		return spc;
	}

	public void setSpc(boolean spc) {
		this.spc = spc;
	}

	public boolean isDocumentos() {
		return documentos;
	}

	public void setDocumentos(boolean documentos) {
		this.documentos = documentos;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String getCivil() {
		return civil;
	}

	public void setCivil(String civil) {
		this.civil = civil;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", numero=" + numero + ", email=" + email + ", renda=" + renda + ", civil=" + civil + ", rg=" + rg
				+ ", cpf=" + cpf + ", nascimento=" + nascimento + ", cep=" + cep + ", complemento=" + complemento
				+ ", celular=" + celular + ", sexo=" + sexo + ", bairro=" + bairro + ", estado=" + estado + ", serasa="
				+ serasa + ", spc=" + spc + ", documentos=" + documentos + ", limite=" + limite + ", cidade=" + cidade
				+ ", senha=" + senha + ", saldo=" + saldo + "]";
	}



	
	
	

}
