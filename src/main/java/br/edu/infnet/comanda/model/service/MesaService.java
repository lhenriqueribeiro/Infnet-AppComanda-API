package br.edu.infnet.comanda.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.comanda.model.negocio.Mesa;
import br.edu.infnet.comanda.model.repository.IMesaRepository;

@Service
public class MesaService {
	
	@Autowired
	private IMesaRepository repository;

	public List<Mesa> obterLista(){
		return (List<Mesa>)repository.findAll();
	}
	
	public Optional<Mesa> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Mesa mesa) {
		repository.save(mesa);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public IMesaRepository getRepository() {
		return repository;
	}
	public void setRepository(IMesaRepository repository) {
		this.repository = repository;
	}
}