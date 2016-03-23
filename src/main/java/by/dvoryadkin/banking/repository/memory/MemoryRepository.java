package by.dvoryadkin.banking.repository.memory;

import by.dvoryadkin.banking.domain.*;
import by.dvoryadkin.banking.repository.ClientRepository;
import by.dvoryadkin.banking.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemoryRepository implements ClientRepository, TransactionRepository {

    private List<Client> clients = new ArrayList<>();

    private List<Account> accounts = new ArrayList<>();

    private List<DepositTransaction> depositTransactions = new ArrayList<>();

    private List<TransferTransaction> transferTransactions = new ArrayList<>();

    private List<WithdrawTransaction> withdrawTransactions = new ArrayList<>();

    private long id = 0;

    private static MemoryRepository instance = new MemoryRepository();

    public static MemoryRepository getInstance() {
        return instance;
    }

    private MemoryRepository() {

        Client client = null;
        Account account = null;

        client = new Client();
        client.setName("Client 1");
        client.setAddress("Address 1");
        client.setAge(11);
        account = new Account(client, 264, "Some account");

        addClientAccount(client, account);
        addClient(client);

        client = new Client();
        client.setName("Client 2");
        client.setAddress("Address 2");
        client.setAge(12);
        account = new Account(client, 333, "Another account");
        addClientAccount(client, account);
        account = new Account(client, 465, "One more account");
        addClientAccount(client, account);
        addClient(client);

        client = new Client();
        client.setName("Client 3");
        client.setAddress("Address 3");
        account = new Account(client, 823, "Yet another account");
        addClientAccount(client, account);
        account = new Account(client, 111, "Account number 5");
        addClientAccount(client, account);
        account = new Account(client, 56, "Sixth account");
        addClientAccount(client, account);
        addClient(client);

        addTransferTransaction(new TransferTransaction(5, accounts.get(0), accounts.get(1)));
        addTransferTransaction(new TransferTransaction(185, accounts.get(3), accounts.get(4)));
        addDepositTransaction(new DepositTransaction(122, accounts.get(3)));
        addDepositTransaction(new DepositTransaction(14, accounts.get(2)));
        addWithdrawTransaction(new WithdrawTransaction(10, accounts.get(5)));
        addWithdrawTransaction(new WithdrawTransaction(88, accounts.get(5)));
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
        client.setId(clients.size());
    }

    @Override
    public Client getClientById(long id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void addClientAccount(Client client, Account account) {
        client.getAccounts().add(account);
        account.setClient(client);
        accounts.add(account);
        account.setId(accounts.size());
    }

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public List<AbstractTransaction> getAllTransactions() {
        List<AbstractTransaction> list = new ArrayList<>();
        list.addAll(getAllTransferTransactions());
        list.addAll(getAllDepositTransactions());
        list.addAll(getAllWithdrawTransactions());
        return list;
    }

    @Override
    public List<DepositTransaction> getAllDepositTransactions() {
        return depositTransactions;
    }

    @Override
    public List<TransferTransaction> getAllTransferTransactions() {
        return transferTransactions;
    }

    @Override
    public List<WithdrawTransaction> getAllWithdrawTransactions() {
        return withdrawTransactions;
    }

    @Override
    public void addDepositTransaction(DepositTransaction depositTransaction) {
        depositTransaction.setId(generateTransactionId());
        depositTransaction.setDate(new Date());
        depositTransactions.add(depositTransaction);
    }

    @Override
    public void addTransferTransaction(TransferTransaction transferTransaction) {
        transferTransaction.setId(generateTransactionId());
        transferTransaction.setDate(new Date());
        transferTransactions.add(transferTransaction);
    }

    @Override
    public void addWithdrawTransaction(WithdrawTransaction withdrawTransaction) {
        withdrawTransaction.setId(generateTransactionId());
        withdrawTransaction.setDate(new Date());
        withdrawTransactions.add(withdrawTransaction);
    }

    private long generateTransactionId() {
        return ++id;
    }
}
