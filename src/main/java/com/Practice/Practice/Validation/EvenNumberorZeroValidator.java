package com.Practice.Practice.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenNumberorZeroValidator implements ConstraintValidator<EvenNumberorZero, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value%2==0 || value==0;
    }
}
