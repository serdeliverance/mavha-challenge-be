package com.mavha.mavhachallengetodobespring.validator;

import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mavha.mavhachallengetodobespring.domain.StatusEnum;

public class StatusValidator implements ConstraintValidator<StatusValid, String> {
 
    public void initialize(StatusValid constraint) {
    }
 
    public boolean isValid(String status, ConstraintValidatorContext context) {
    	return Stream.of(StatusEnum.values()) //
    			.map(StatusEnum::name) //
    			.anyMatch(s -> s.toLowerCase().equals(status));
    }
}