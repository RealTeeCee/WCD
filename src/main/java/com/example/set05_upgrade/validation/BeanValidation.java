package com.example.set05_upgrade.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidation<T> {
    public String validProduct(T product){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validation = validator.validate(product);
        StringBuilder error = new StringBuilder();
        for (ConstraintViolation<T> violation:validation) {
            error.append(violation.getMessageTemplate()).append("\n");
        }

        return error.toString();
    }
}
