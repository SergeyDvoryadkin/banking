package by.dvoryadkin.banking.mvc.validation;

import by.dvoryadkin.banking.domain.Client;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClientValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Client client = (Client) object;
        if (client.getName() == null || "".equals(client.getName())) {
            errors.rejectValue("name", "error.client.name.required");
        }

        if (client.getAge() == 0) {
            errors.rejectValue("age", "error.client.age.required");
        } else {
            if (client.getAge() < 18) {
                errors.rejectValue("age", "error.client.age.underage");
            }
        }

    }
}
