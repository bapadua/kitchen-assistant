package io.github.bapadua.fooder.core.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValuesAllowed.Validator.class })
public @interface ValuesAllowed {

    String message() default "Field value should be from list of ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();

    String[] values();
    class Validator implements ConstraintValidator<ValuesAllowed, String> {

        private String propName;
        private String message;
        private List<String> allowed;

        @Override
        public void initialize(ValuesAllowed required) {
            this.propName = required.propName();
            this.message = required.message();
            this.allowed = Arrays.asList(required.values());
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            boolean valid = this.allowed.contains(value);
            if(Boolean.FALSE.equals(valid)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message.concat(this.allowed.toString()))
                        .addPropertyNode(this.propName).addConstraintViolation();
            }
            return valid;
        }
    }
}
