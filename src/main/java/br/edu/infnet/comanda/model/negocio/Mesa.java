package br.edu.infnet.comanda.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TMesa")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMesa;
	private int numero;
	private String localizacao;
	private int qtPessoas;
	
	public Mesa() {
	}
	
	public Mesa(int numero, String localizacao, int qtPessoas) {
		this();
		setNumero(numero);
		setLocalizacao(localizacao);
		setQtPessoas(qtPessoas);
	}
	
	@Override
	public String toString() {
		return String.format("%d - %d - %s - %d", 
				this.getIdMesa(), 
				this.getNumero(),
				this.getLocalizacao(),
				this.getQtPessoas()
				);
	}
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getQtPessoas() {
		return qtPessoas;
	}
	public void setQtPessoas(int qtPessoas) {
		this.qtPessoas = qtPessoas;
	}
}