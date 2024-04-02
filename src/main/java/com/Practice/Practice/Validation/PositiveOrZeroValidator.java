package com.Practice.Practice.Validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositiveOrZeroValidator implements ConstraintValidator<PositiveOrZero, Integer> {

    @Override
    public void initialize(PositiveOrZero constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || value >= 0;
    }
}
