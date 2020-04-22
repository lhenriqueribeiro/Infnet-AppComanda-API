package br.edu.infnet.comanda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.comanda.model.negocio.Sobremesa;

@Repository
public interface ISobremesaRepository extends CrudRepository<Sobremesa, Integer> {

}
