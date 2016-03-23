package by.dvoryadkin.banking.repository;

import by.dvoryadkin.banking.domain.AbstractTransaction;
import by.dvoryadkin.banking.domain.DepositTransaction;
import by.dvoryadkin.banking.domain.TransferTransaction;
import by.dvoryadkin.banking.domain.WithdrawTransaction;

import java.util.List;

public interface TransactionRepository {

    List<AbstractTransaction> getAllTransactions();

    List<DepositTransaction> getAllDepositTransactions();

    List<TransferTransaction> getAllTransferTransactions();

    List<WithdrawTransaction> getAllWithdrawTransactions();

    void addDepositTransaction(DepositTransaction depositTransaction);

    void addTransferTransaction(TransferTransaction transferTransaction);

    void addWithdrawTransaction(WithdrawTransaction withdrawTransaction);
}
