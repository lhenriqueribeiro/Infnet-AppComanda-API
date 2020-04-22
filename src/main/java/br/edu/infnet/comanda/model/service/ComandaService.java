package br.edu.infnet.comanda.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.comanda.model.negocio.Comanda;
import br.edu.infnet.comanda.model.repository.IComandaRepository;

@Service
public class ComandaService {
	
	@Autowired
	private IComandaRepository repository;

	public List<Comanda> obterLista(){
		return (List<Comanda>)repository.findAll();
	}
	
	public Optional<Comanda> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Comanda comanda) {
		repository.save(comanda);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public IComandaRepository getRepository() {
		return repository;
	}
	public void setRepository(IComandaRepository repository) {
		this.repository = repository;
	}
}