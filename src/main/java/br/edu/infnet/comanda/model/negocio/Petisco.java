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
@Table(name = "TPetisco")
@PrimaryKeyJoinColumn(name = "idCardapio")
public class Petisco extends Cardapio {

	private int qtPorcao;
	private boolean frito;
	private boolean vegano;
	
	@OneToOne(fetch = FetchType.EAGER,
			  cascade = CascadeType.ALL)
	@JoinColumn(name = "idCardapio", nullable = false)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cardapio cardapio;
	
	public Petisco() {
	}
	
	public Petisco(int qtPorcao,boolean frito, boolean vegano) {
		this();
		setQtPorcao(qtPorcao);
		setFrito(frito);
		setVegano(vegano);
	}
	
	@Override
	public String toString() {
		return String.format("%s - %d - %s - %s", 
				super.toString(), 
				this.getQtPorcao(),
				this.isFrito() ? "Frito" : "Não Frito",
				this.isVegano() ? "Vegano" : "Não Vegano"
				);
	}

	public int getQtPorcao() {
		return qtPorcao;
	}
	public void setQtPorcao(int qtPorcao) {
		this.qtPorcao = qtPorcao;
	}
	public boolean isFrito() {
		return frito;
	}
	public void setFrito(boolean frito) {
		this.frito = frito;
	}
	public boolean isVegano() {
		return vegano;
	}
	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
}