package br.edu.infnet.comanda.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.comanda.model.negocio.Usuario;
import br.edu.infnet.comanda.model.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repository;
	
	public boolean isValid(Usuario usuario) {
		Usuario usuarioDaBase = findByLogin(usuario.getEmail());
		
		if (usuarioDaBase == null) {
			return false;	
		}
		
		if (usuarioDaBase.getEmail().equals(usuario.getEmail()) && 
			usuarioDaBase.getSenha().equals(usuario.getSenha())) {
			return true;
		}
		
		return false;
	}
	
	public Usuario findByLogin(String email) {
		return repository.findByEmail(email);
	}
	
	public List<Usuario> obterLista() {
		return (List<Usuario>) repository.findAll();
	}
	
	public Optional<Usuario> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Usuario usuario) {
		repository.save(usuario);
	}

	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
