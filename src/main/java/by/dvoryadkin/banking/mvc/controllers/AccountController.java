package by.dvoryadkin.banking.mvc.controllers;

import by.dvoryadkin.banking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listAccounts(Model model)
	{
		model.addAttribute("accounts", clientService.getAllAccounts());
		return "accounts";
	}
}
