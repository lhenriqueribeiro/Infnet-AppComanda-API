package br.edu.infnet.comanda.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
	}
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(int id, String nome, String email, String senha) {
		this(nome, email, senha);
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s", 
				this.getId(),
				this.getNome(),
				this.getEmail(), 
				this.getSenha()
			);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
