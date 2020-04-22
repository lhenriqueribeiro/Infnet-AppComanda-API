package br.edu.infnet.comanda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.comanda.model.negocio.Cardapio;

@Repository
public interface ICardapioRepository extends CrudRepository<Cardapio, Integer> {

}
