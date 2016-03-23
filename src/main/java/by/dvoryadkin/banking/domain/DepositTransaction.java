package by.dvoryadkin.banking.domain;

public class DepositTransaction extends AbstractTransaction{

    private Account targetAccount;

    public DepositTransaction() {
    }
    public DepositTransaction(double moneyAmount, Account targetAccount) {
        setMoneyAmount(moneyAmount);
        setTargetAccount(targetAccount);
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    @Override
    public TransactionType getType() {
        return TransactionType.DEPOSIT;
    }
}
