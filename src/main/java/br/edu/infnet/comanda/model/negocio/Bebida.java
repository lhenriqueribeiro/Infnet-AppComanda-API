package br.edu.infnet.comanda.model.negocio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TBebida")
@PrimaryKeyJoinColumn(name = "idCardapio")
public class Bebida extends Cardapio {

	private String nivel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCardapio", nullable = false)
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cardapio cardapio;
	
	public Bebida() {
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), this.getNivel());
	}
	
	public Bebida(String nivel) {
		this();
		this.nivel = nivel;
	}

	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
}