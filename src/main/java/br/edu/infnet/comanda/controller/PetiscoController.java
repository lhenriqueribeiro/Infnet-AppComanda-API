package br.edu.infnet.comanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.comanda.model.negocio.Petisco;
import br.edu.infnet.comanda.model.service.PetiscoService;

@Controller
public class PetiscoController {

	@Autowired
	private PetiscoService service;
	
	@RequestMapping(value = "/petiscos", method = RequestMethod.GET)
	public String showLista(Model model) {
		model.addAttribute("petiscos", service.obterLista());
		return "petisco/lista";
	}
	
	@RequestMapping(value = "/petisco", method = RequestMethod.GET)
	public String showDetalhe() {
		return "petisco/detalhe";
	}
	
	@RequestMapping(value = "/petisco", method = RequestMethod.POST)
	public String incluir(Model model,Petisco petisco) {
		service.incluir(petisco);
		return this.showLista(model);
	}
	
	@RequestMapping(value = "/petisco/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		service.excluir(id);
		return this.showLista(model);
	}

	public PetiscoService getService() {
		return service;
	}
	public void setService(PetiscoService service) {
		this.service = service;
	}
}