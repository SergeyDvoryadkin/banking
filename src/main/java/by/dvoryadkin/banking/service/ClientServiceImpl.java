package by.dvoryadkin.banking.service;

import by.dvoryadkin.banking.domain.Account;
import by.dvoryadkin.banking.domain.Client;
import by.dvoryadkin.banking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.getClientById(id);
    }

    @Override
    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    @Override
    public void addClientAccount(Client client, Account account) {
        clientRepository.addClientAccount(client, account);
    }

    @Override
    public double getTotalAmountOfMoney(Client client) {
        double total = 0;
        for (Account account : client.getAccounts()) {
            total += account.getMoneyAmount();
        }
        return total;
    }

    @Override
    public List<Account> getAllAccounts() {
        return clientRepository.getAllAccounts();
    }
}
