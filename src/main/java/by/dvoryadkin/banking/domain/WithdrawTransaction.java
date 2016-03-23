package by.dvoryadkin.banking.domain;


public class WithdrawTransaction extends AbstractTransaction {

    private Account sourceAccount;

    public WithdrawTransaction() {
    }

    public WithdrawTransaction(double moneyAmount, Account sourceAccount) {
        setSourceAccount(sourceAccount);
        setMoneyAmount(moneyAmount);
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @Override
    public TransactionType getType() {
        return TransactionType.WITHDRAW;
    }
}
