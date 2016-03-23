package by.dvoryadkin.banking.domain;

public class TransferTransaction extends AbstractTransaction {

    private Account sourceAccount;

    private Account targetAccount;

    public TransferTransaction() {

    }

    public TransferTransaction(double moneyAmount, Account sourceAccount, Account targetAccount) {
        setMoneyAmount(moneyAmount);
        setSourceAccount(sourceAccount);
        setTargetAccount(targetAccount);
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    @Override
    public TransactionType getType() {
        return TransactionType.TRANSFER;
    }
}
