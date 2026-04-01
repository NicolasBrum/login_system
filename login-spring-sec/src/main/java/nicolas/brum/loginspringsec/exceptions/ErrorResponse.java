package nicolas.brum.loginspringsec.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class ErrorResponse {
    private int statusCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;

    public ErrorResponse(int status, BindingResult bindingResult) {
        this.statusCode = status;
        setErrors(bindingResult);
    }

    public ErrorResponse(int status, String field,  String message) {
        this.statusCode = status;
        setErrors(field, message);
    }

    private void setErrors(BindingResult result){
        this.errors = new HashMap<>();

        result.getFieldErrors().forEach((fieldError) -> {
            this.errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
    }

    private void setErrors(String field, String errorMessage) {
        this.errors = new HashMap<>();
        errors.put(field, errorMessage);
    }
}
