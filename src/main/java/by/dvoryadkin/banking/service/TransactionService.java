package by.dvoryadkin.banking.service;

import by.dvoryadkin.banking.domain.AbstractTransaction;
import by.dvoryadkin.banking.domain.DepositTransaction;
import by.dvoryadkin.banking.domain.TransferTransaction;
import by.dvoryadkin.banking.mvc.forms.TransactionFilterForm;

import java.util.List;

public interface TransactionService {

    List<AbstractTransaction> getAllTransactions();

    List<AbstractTransaction> getFilteredTransactions(TransactionFilterForm filter);

    List<DepositTransaction> getAllDepositTransactions();

    List<TransferTransaction> getAllTransferTransactions();

    void addDepositTransaction(DepositTransaction depositTransaction);

    void addTransferTransaction(TransferTransaction transferTransaction);
}
