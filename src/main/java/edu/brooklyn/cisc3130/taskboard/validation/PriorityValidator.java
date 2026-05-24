package edu.brooklyn.cisc3130.taskboard.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityValidator implements ConstraintValidator<ValidPriority, String> {

    @Override
    public boolean isValid(String priority, ConstraintValidatorContext context) {
        if (priority == null || priority.isBlank()) {
            return true;
        }

        return priority.equalsIgnoreCase("LOW")
                || priority.equalsIgnoreCase("MEDIUM")
                || priority.equalsIgnoreCase("HIGH");
    }
}