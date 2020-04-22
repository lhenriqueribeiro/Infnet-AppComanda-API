package br.edu.infnet.comanda.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name = "TCardapio")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoCardapio")
@JsonSubTypes({
    @JsonSubTypes.Type(value=Bebida.class, name = "Bebida"),
    @JsonSubTypes.Type(value=Petisco.class, name = "Petisco"),
    @JsonSubTypes.Type(value=Sobremesa.class, name = "Sobremesa")
})
public abstract class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCardapio;
	private String nome;
	private boolean disponivel;
	private float valor;
	
    @ManyToMany(mappedBy = "cardapios", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Comanda> Comandas;
    
	public Cardapio() {
	}
	
	public Cardapio(String nome, boolean disponivel, float valor) {
		this();
		this.setNome(nome);
		this.setDisponivel(disponivel);
		this.setValor(valor);
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %.2f", 
				this.getIdCardapio(), 
				this.getNome(),
				this.isDisponivel() ? "Sim" : "Não",
				this.getValor()
				);
	}
	
	public int getIdCardapio() {
		return idCardapio;
	}
	public void setIdCardapio(int idCardapio) {
		this.idCardapio = idCardapio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public List<Comanda> getComandas() {
		return Comandas;
	}
	public void setComandas(List<Comanda> comandas) {
		Comandas = comandas;
	}
}