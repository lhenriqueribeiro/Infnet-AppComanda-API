package br.edu.infnet.comanda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.comanda.model.negocio.Usuario;
import br.edu.infnet.comanda.model.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@PostMapping(value = "/isvalid")
	public boolean isValid(@RequestBody Usuario usuario) {
		return service.isValid(usuario);
	}
	
	@GetMapping
	public List<Usuario> obterLista() {
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Usuario> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public void incluir (@RequestBody Usuario usuario) {
		service.incluir(usuario);
	}
	
	@DeleteMapping("{id}")
	public void excluir (@PathVariable Integer id) {
		service.excluir(id);
	}
}
