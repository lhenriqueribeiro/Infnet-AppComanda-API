package br.edu.infnet.comanda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.comanda.model.negocio.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
}
