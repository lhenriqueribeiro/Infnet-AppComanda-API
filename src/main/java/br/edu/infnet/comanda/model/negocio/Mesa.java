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
	private Integer idMesa;
	private String descricao;
	
	public Mesa() {
	}
	public Mesa(Integer idMesa, String descricao) {
		this();
		this.idMesa = idMesa;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s", this.getIdMesa(), this.getDescricao());
	}
	

	public Integer getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}