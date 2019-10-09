package com.mavha.mavhachallengetodobespring.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
public @interface StatusValid {
    String message() default "{status.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
