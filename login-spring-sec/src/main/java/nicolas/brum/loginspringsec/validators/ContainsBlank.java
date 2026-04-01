package nicolas.brum.loginspringsec.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringBlankValidator.class)
public @interface ContainsBlank {

    String message() default "Campo contém caracteres vazios!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
