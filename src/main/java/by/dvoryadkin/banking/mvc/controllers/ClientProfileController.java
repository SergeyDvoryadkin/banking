package by.dvoryadkin.banking.mvc.controllers;

import by.dvoryadkin.banking.mvc.validation.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import by.dvoryadkin.banking.domain.Account;
import by.dvoryadkin.banking.domain.Client;
import by.dvoryadkin.banking.mvc.exceptions.ResourceNotFoundException;
import by.dvoryadkin.banking.service.ClientService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients/profile")
public class ClientProfileController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public String viewClient(@PathVariable("clientId") long clientId, Model model) {

        Client client = clientService.getClientById(clientId);
        if (null == client) {
            throw new ResourceNotFoundException();
        }

        model.addAttribute("client", client);
        model.addAttribute("total", clientService.getTotalAmountOfMoney(client));

        return "client_profile";

    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
    public String addClientAccount(
            @PathVariable("clientId") long clientId,
            @Valid @ModelAttribute("newAccount") Account newAccount,
            Errors errors,
            Model model) {

        Client client = clientService.getClientById(clientId);
        if (null == client) {
            throw new ResourceNotFoundException();
        }

        if ( !errors.hasErrors() ) {
            clientService.addClientAccount(client, newAccount);
        }

        model.addAttribute("client", client);
        model.addAttribute("total", clientService.getTotalAmountOfMoney(client));

        return "client_profile";
    }

    @Scope("session")
    @ModelAttribute("newAccount")
    public Account getNewAccount() {
        return new Account();
    }

    @InitBinder("newAccount")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new AccountValidator());
    }
}
