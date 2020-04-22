package br.edu.infnet.comanda.model.negocio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TBebida")
@PrimaryKeyJoinColumn(name = "idCardapio")
public class Bebida extends Cardapio {
	
	private String tipo;
	private int ml;
	private boolean gelada;

	@OneToOne(fetch = FetchType.EAGER,
			  cascade = CascadeType.ALL)
	@JoinColumn(name = "idCardapio", nullable = false)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cardapio cardapio;
	
	public Bebida() {
	}
	
	public Bebida(String tipo,int ml, boolean gelada) {
		this();
		setTipo(tipo);
		setMl(ml);
		setGelada(gelada);
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %d - %s", 
				super.toString(), 
				this.getTipo(),
				this.getMl(),
				this.isGelada() ? "Gelada" : "Não Gelada"
				);
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getMl() {
		return ml;
	}
	public void setMl(int ml) {
		this.ml = ml;
	}
	public boolean isGelada() {
		return gelada;
	}
	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
}