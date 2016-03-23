package by.dvoryadkin.banking.mvc.controllers;

import by.dvoryadkin.banking.mvc.validation.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.dvoryadkin.banking.domain.Client;
import by.dvoryadkin.banking.service.ClientService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientsController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listAllClients(Model model) {

		model.addAttribute("clients", clientService.getAllClients());
		return "clients";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String addClient(
			@Valid
			@ModelAttribute("newClient")
			Client newClient,
			Errors errors,
			Model model)
	{
		if (!errors.hasErrors()) {
			clientService.addClient(newClient);
		}
		model.addAttribute("clients", clientService.getAllClients());
		return "clients";

	}

	@Scope("session")
	@ModelAttribute("newClient")
	public Client getNewClient() {
		return new Client();
	}

	@InitBinder("newClient")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ClientValidator());
	}
}
