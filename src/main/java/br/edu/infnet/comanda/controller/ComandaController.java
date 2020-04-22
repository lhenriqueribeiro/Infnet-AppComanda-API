package br.edu.infnet.comanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.comanda.model.negocio.Cardapio;
import br.edu.infnet.comanda.model.negocio.Comanda;
import br.edu.infnet.comanda.model.service.CardapioService;
import br.edu.infnet.comanda.model.service.ComandaService;
import br.edu.infnet.comanda.pes.CardapioPes;

@Controller
public class ComandaController {

	@Autowired
	private ComandaService service;
	@Autowired
	private CardapioService cardapioService;
	
	@RequestMapping(value = "/comandas", method = RequestMethod.GET)
	public String showLista(Model model) {
		model.addAttribute("comandas", service.obterLista());
		return "comanda/lista";
	}
	
	@RequestMapping(value = "/comanda", method = RequestMethod.GET)
	public String showDetalhe(Model model) {
		model.addAttribute("cardapios", cardapioService.obterLista());
		return "comanda/detalhe";
	}
	
	@RequestMapping(value = "/comanda", method = RequestMethod.POST)
	public String incluir(Model model, Comanda comanda) {
		service.incluir(comanda);
		return this.showLista(model);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Cardapio.class, new CardapioPes());
	}
	@RequestMapping(value = "/comanda/{id}", method = RequestMethod.GET)
	public String excluir(Model model,@PathVariable Integer id) {
		service.excluir(id);
		return this.showLista(model);
	}

	public ComandaService getService() {
		return service;
	}
	public void setService(ComandaService service) {
		this.service = service;
	}
}