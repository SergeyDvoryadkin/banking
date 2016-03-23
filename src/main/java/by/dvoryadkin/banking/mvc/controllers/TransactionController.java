package by.dvoryadkin.banking.mvc.controllers;

import by.dvoryadkin.banking.domain.AbstractTransaction;
import by.dvoryadkin.banking.domain.Account;
import by.dvoryadkin.banking.domain.DepositTransaction;
import by.dvoryadkin.banking.mvc.forms.TransactionFilterForm;
import by.dvoryadkin.banking.domain.TransactionType;
import by.dvoryadkin.banking.service.ClientService;
import by.dvoryadkin.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public String listAllTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "transactions";
    }

    @RequestMapping(value = "/filter")
    public String listFilteredTransactions
            (
                    @Valid
                    @ModelAttribute("filter")
                    TransactionFilterForm filter,
                    Errors errors,
                    Model model
            ) {
        model.addAttribute("transactions", transactionService.getFilteredTransactions(filter));
        return "transactions";
    }

    @ModelAttribute("transactionTypes")
    @Scope(value = "session")
    public Map<TransactionType, String> getTransactionTypes() {
        TreeMap<TransactionType, String> transactionTypes = new TreeMap<>();
        transactionTypes.put(TransactionType.WITHDRAW, "Withdraw");
        transactionTypes.put(TransactionType.DEPOSIT, "Deposit");
        transactionTypes.put(TransactionType.TRANSFER, "Transfer");
        return transactionTypes;
    }

    @ModelAttribute("filter")
    @Scope("session")
    TransactionFilterForm getFilter() {
        return new TransactionFilterForm();
    }

    @ModelAttribute("selectOptions")
    @Scope("session")
    public Map<Long, String> getSelectOptions() {
        List<Account> accounts = clientService.getAllAccounts();
        Map<Long, String> selectOptions = new TreeMap<>();
        for (Account account : accounts) {
            Long id = account.getId();
            selectOptions.put(id, account.getId() + ": " + account.getName());
        }
        selectOptions.put(0L, "--- SELECT ---");
        return selectOptions;
    }
}
