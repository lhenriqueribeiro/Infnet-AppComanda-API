package br.edu.infnet.comanda.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.comanda.model.negocio.Sobremesa;
import br.edu.infnet.comanda.model.repository.ISobremesaRepository;

@Service
public class SobremesaService {
	
	@Autowired
	private ISobremesaRepository repository;

	public List<Sobremesa> obterLista(){
		return (List<Sobremesa>)repository.findAll();
	}
	
	public Optional<Sobremesa> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Sobremesa sobremesa) {
		repository.save(sobremesa);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public ISobremesaRepository getRepository() {
		return repository;
	}
	public void setRepository(ISobremesaRepository repository) {
		this.repository = repository;
	}
}