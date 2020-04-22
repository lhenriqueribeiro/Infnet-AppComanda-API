package br.edu.infnet.comanda.pes;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.comanda.model.negocio.Cardapio;
import br.edu.infnet.comanda.model.service.CardapioService;

public class CardapioPes extends PropertyEditorSupport{

	@Autowired
	private CardapioService service;
	
	@Override
	public void setAsText(String text) {
		int id = new Integer(text);
		Optional<Cardapio> cardapio = service.obterPorId(id);
		super.setValue(cardapio);
	}
}
