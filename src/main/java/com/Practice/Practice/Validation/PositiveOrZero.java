package com.Practice.Practice.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveOrZeroValidator.class)
public @interface PositiveOrZero {
    String message() default "Value must be a positive number or zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
