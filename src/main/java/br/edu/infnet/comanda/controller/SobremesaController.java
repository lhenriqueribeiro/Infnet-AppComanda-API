package br.edu.infnet.comanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.comanda.model.negocio.Sobremesa;
import br.edu.infnet.comanda.model.service.SobremesaService;

@Controller
public class SobremesaController {

	@Autowired
	private SobremesaService service;
	
	@RequestMapping(value = "/sobremesas", method = RequestMethod.GET)
	public String showLista(Model model) {
		model.addAttribute("sobremesas", service.obterLista());
		return "sobremesa/lista";
	}
	
	@RequestMapping(value = "/sobremesa", method = RequestMethod.GET)
	public String showDetalhe() {
		return "sobremesa/detalhe";
	}
	
	@RequestMapping(value = "/sobremesa", method = RequestMethod.POST)
	public String incluir(Model model,Sobremesa sobremesa) {
		service.incluir(sobremesa);
		return this.showLista(model);
	}
	
	@RequestMapping(value = "/sobremesa/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		service.excluir(id);
		return this.showLista(model);
	}

	public SobremesaService getService() {
		return service;
	}
	public void setService(SobremesaService service) {
		this.service = service;
	}
}