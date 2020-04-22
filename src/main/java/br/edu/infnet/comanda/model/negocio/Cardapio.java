package br.edu.infnet.comanda.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	private Integer idCardapio;
	
	@Column(name = "descricao")
	private String descricao;
	
    @ManyToMany(mappedBy = "cardapios", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Comanda> Comandas;
    
	public Cardapio() {
	}
	
	public Cardapio(Integer idCardapio, String descricao) {
		this();
		this.idCardapio = idCardapio;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s", this.getIdCardapio(), this.getDescricao());
	}
	
	public Integer getIdCardapio() {
		return idCardapio;
	}
	public void setIdCardapio(Integer idCardapio) {
		this.idCardapio = idCardapio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Comanda> getComandas() {
		return Comandas;
	}
	public void setComandas(List<Comanda> comandas) {
		Comandas = comandas;
	}

}