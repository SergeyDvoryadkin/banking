package by.dvoryadkin.banking.mvc.validation;

import by.dvoryadkin.banking.domain.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        if (account.getName() == null || "".equals(account.getName())) {
            errors.rejectValue("name", "error.account.name.required");
        }

        if (account.getMoneyAmount() == 0) {
            errors.rejectValue("moneyAmount", "error.account.money.required");
        } else {
            if (account.getMoneyAmount() < 0) {
                errors.rejectValue("moneyAmount", "error.account.money.invalid");
            }
        }
    }
}
