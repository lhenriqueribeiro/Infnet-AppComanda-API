package br.edu.infnet.comanda.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
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
	private int idComanda;
	private int dia;
	private int mes;
	private int ano;
	private boolean happyHour;
	private String garcom;
	
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
	
	public Comanda(int idComanda, 
				   int dia, int mes, int ano, boolean happyHour, String garcom, 
				   Mesa mesa, List<Cardapio> cardapios) {
		this();
		this.setIdComanda(idComanda);
		this.setDia(dia);
		this.setMes(mes);
		this.setAno(ano);
		this.setHappyHour(happyHour);
		this.setGarcom(garcom);
		this.setMesa(mesa);
		this.setCardapios(cardapios);
	}
	
	@Override
	public String toString() {
		return String.format("%d - %d/%d/%d - %s - %s - %s - %s", 
				this.getIdComanda(),
				this.getDia(),
				this.getMes(),
				this.getAno(),
				this.isHappyHour() ? "HappyHour" : "Não",
				this.getGarcom(),
				this.getMesa(),
				this.getCardapios()
			);
	}

	public int getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public boolean isHappyHour() {
		return happyHour;
	}
	public void setHappyHour(boolean happyHour) {
		this.happyHour = happyHour;
	}
	public String getGarcom() {
		return garcom;
	}
	public void setGarcom(String garcom) {
		this.garcom = garcom;
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
