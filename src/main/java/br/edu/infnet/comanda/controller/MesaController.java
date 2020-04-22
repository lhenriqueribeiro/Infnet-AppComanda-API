package br.edu.infnet.comanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.comanda.model.negocio.Mesa;
import br.edu.infnet.comanda.model.service.MesaService;

@Controller
public class MesaController {
	
	@Autowired
	private MesaService service;
	
	@RequestMapping(value = "/mesas", method = RequestMethod.GET)
	public String showLista(Model model) {
		model.addAttribute("mesas", service.obterLista());
		
		return "mesa/lista";
	}
	
	@RequestMapping(value = "/mesa", method = RequestMethod.GET)
	public String showDetalhe() {
		return "mesa/detalhe";
	}
	
	@RequestMapping(value = "/mesa", method = RequestMethod.POST)
	public String incluir(Model model, Mesa mesa) {
		service.incluir(mesa);
		return this.showLista(model);
	}
	
	@RequestMapping(value = "/mesa/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		service.excluir(id);
		return this.showLista(model);
	}
	
	public MesaService getService() {
		return service;
	}
	public void setService(MesaService service) {
		this.service = service;
	}
}