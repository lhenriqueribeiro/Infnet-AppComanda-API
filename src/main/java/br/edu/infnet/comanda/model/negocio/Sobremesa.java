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
@Table(name = "TSobremesa")
@PrimaryKeyJoinColumn(name = "idCardapio")
public class Sobremesa extends Cardapio {

	private String fornecedor;
	private boolean gelado;
	private boolean fruta;
	
	@OneToOne(fetch = FetchType.EAGER,
			  cascade = CascadeType.ALL)
	@JoinColumn(name = "idCardapio", nullable = false)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cardapio cardapio;
	
	public Sobremesa() {
	}
		
	public Sobremesa(String fornecedor,boolean gelado, boolean fruta) {
		this();
		setFornecedor(fornecedor);
		setGelado(gelado);
		setFruta(fruta);
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", 
				super.toString(), 
				this.getFornecedor(),
				this.isGelado() ? "Gelado" : "Não Gelado",
				this.isFruta() ? "fruta" : "Não Fruta"
				);
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public boolean isGelado() {
		return gelado;
	}
	public void setGelado(boolean gelado) {
		this.gelado = gelado;
	}
	public boolean isFruta() {
		return fruta;
	}
	public void setFruta(boolean fruta) {
		this.fruta = fruta;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
}