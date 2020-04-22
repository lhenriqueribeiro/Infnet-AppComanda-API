package br.edu.infnet.comanda.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.comanda.model.negocio.Petisco;
import br.edu.infnet.comanda.model.repository.IPetiscoRepository;

@Service
public class PetiscoService {
	
	@Autowired
	private IPetiscoRepository repository;

	public List<Petisco> obterLista(){
		return (List<Petisco>)repository.findAll();
	}
	
	public Optional<Petisco> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Petisco petisco) {
		repository.save(petisco);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public IPetiscoRepository getRepository() {
		return repository;
	}
	public void setRepository(IPetiscoRepository repository) {
		this.repository = repository;
	}
}