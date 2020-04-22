package br.edu.infnet.comanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.comanda.model.negocio.Bebida;
import br.edu.infnet.comanda.model.service.BebidaService;

@Controller
public class BebidaController {

	@Autowired
	private BebidaService service;
	
	@RequestMapping(value = "/bebidas", method = RequestMethod.GET)
	public String showLista(Model model) {
		model.addAttribute("bebidas", service.obterLista());
		return "bebida/lista";
	}
	
	@RequestMapping(value = "/bebida", method = RequestMethod.GET)
	public String showDetalhe() {
		return "bebida/detalhe";
	}
	
	@RequestMapping(value = "/bebida", method = RequestMethod.POST)
	public String incluir(Model model,Bebida bebida) {
		service.incluir(bebida);
		return this.showLista(model);
	}
	
	@RequestMapping(value = "/bebida/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		service.excluir(id);
		return this.showLista(model);
	}

	public BebidaService getService() {
		return service;
	}
	public void setService(BebidaService service) {
		this.service = service;
	}
}