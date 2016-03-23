package by.dvoryadkin.banking.service;

import by.dvoryadkin.banking.domain.AbstractTransaction;
import by.dvoryadkin.banking.domain.DepositTransaction;
import by.dvoryadkin.banking.domain.TransferTransaction;
import by.dvoryadkin.banking.mvc.forms.TransactionFilterForm;
import by.dvoryadkin.banking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<AbstractTransaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    @Override
    public List<AbstractTransaction> getFilteredTransactions(TransactionFilterForm filter) {
        List<AbstractTransaction> allTransactions = getAllTransactions();
        
        return allTransactions;
    }

    @Override
    public List<DepositTransaction> getAllDepositTransactions() {
        return transactionRepository.getAllDepositTransactions();
    }

    @Override
    public List<TransferTransaction> getAllTransferTransactions() {
        return transactionRepository.getAllTransferTransactions();
    }

    @Override
    public void addDepositTransaction(DepositTransaction depositTransaction) {
        transactionRepository.addDepositTransaction(depositTransaction);
    }

    @Override
    public void addTransferTransaction(TransferTransaction transferTransaction) {
        transactionRepository.addTransferTransaction(transferTransaction);
    }
}
