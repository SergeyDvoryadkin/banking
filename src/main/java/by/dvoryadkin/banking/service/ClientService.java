package by.dvoryadkin.banking.service;

import java.util.List;

import by.dvoryadkin.banking.domain.Account;
import by.dvoryadkin.banking.domain.Client;

public interface ClientService
{
    public List<Client> getAllClients(); 
    
    public Client getClientById(long id);
    
    public void addClient(Client client);
    
    public void addClientAccount(Client client, Account account);

    public double getTotalAmountOfMoney(Client client);

    public List<Account> getAllAccounts();
}
