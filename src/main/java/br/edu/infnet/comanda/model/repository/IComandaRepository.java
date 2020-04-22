package br.edu.infnet.comanda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.comanda.model.negocio.Comanda;

@Repository
public interface IComandaRepository extends CrudRepository<Comanda, Integer> {

}
