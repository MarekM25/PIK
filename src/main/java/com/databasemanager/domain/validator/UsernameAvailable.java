package com.databasemanager.domain.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameAvailableValidator.class)
@Documented
public @interface UsernameAvailable {
    String message() default "Podany login jest już zajęty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
