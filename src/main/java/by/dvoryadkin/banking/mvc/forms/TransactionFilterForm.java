package by.dvoryadkin.banking.mvc.forms;

import by.dvoryadkin.banking.domain.TransactionType;

import java.util.Arrays;
import java.util.Date;

public class TransactionFilterForm {

    private TransactionType[] types = new TransactionType[TransactionType.values().length];

    private Date minDate;

    private Date maxDate;

    private long sourceAccountId;

    private long targetAccountId;

    public TransactionType[] getTypes() {
        return types;
    }

    public void setType(TransactionType[] types) {
        this.types = types;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    @Override
    public String toString() {
        return "TransactionFilterForm{" +
                "types=" + Arrays.toString(types) +
                ", minDate=" + minDate +
                ", maxDate=" + maxDate +
                ", sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                '}';
    }
}
