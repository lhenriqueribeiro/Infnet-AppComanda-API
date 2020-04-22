package br.edu.infnet.comanda.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.comanda.model.negocio.Cardapio;
import br.edu.infnet.comanda.model.repository.ICardapioRepository;

@Service
public class CardapioService {
	
	@Autowired
	private ICardapioRepository repository;

	public List<Cardapio> obterLista(){
		return (List<Cardapio>)repository.findAll();
	}
	
	public Optional<Cardapio> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Cardapio cardapio) {
		repository.save(cardapio);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public ICardapioRepository getRepository() {
		return repository;
	}
	public void setRepository(ICardapioRepository repository) {
		this.repository = repository;
	}
}