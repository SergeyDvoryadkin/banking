package by.dvoryadkin.banking.repository;

import by.dvoryadkin.banking.domain.Account;
import by.dvoryadkin.banking.domain.Client;

import java.util.List;

public interface ClientRepository {

    public List<Client> getAllClients();

    public Client getClientById(long id);

    public void addClient(Client client);

    public void addClientAccount(Client client, Account account);

    public List<Account> getAllAccounts();

}
