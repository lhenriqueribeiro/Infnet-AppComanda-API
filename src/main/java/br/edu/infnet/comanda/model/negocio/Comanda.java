package br.edu.infnet.comanda.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TComanda")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idComanda;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToOne(fetch = FetchType.EAGER,
			  cascade = CascadeType.ALL,
			  orphanRemoval = true)
	@JoinColumn(name = "idMesa")
	private Mesa mesa;

	@JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="TComandaCardapio", 
    	joinColumns={@JoinColumn(name="idComanda")},
    	inverseJoinColumns={@JoinColumn(name="idCardapio")})
	private List<Cardapio> cardapios;
    
	public Comanda() {
	}
	
	public Comanda(Integer id, String descricao) {
		this();
		this.idComanda = id;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s", 
				this.getIdComanda(), 
				this.getDescricao());
	}

	public Integer getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public List<Cardapio> getCardapios() {
		return cardapios;
	}
	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}
}
