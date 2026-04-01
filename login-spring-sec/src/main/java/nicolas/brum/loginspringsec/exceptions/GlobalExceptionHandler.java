package nicolas.brum.loginspringsec.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UsernameNotFoundException ex) {
        var errors = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),"Nome de usuário" ,ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
    }

    @ExceptionHandler(EmailDuplicatedException.class)
    public ResponseEntity<ErrorResponse> emailDuplicatedException(EmailDuplicatedException e) {
        var errors = new ErrorResponse(HttpStatus.CONFLICT.value(),"Email" ,e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getBindingResult());
        return ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<ErrorResponse> passwordException(PasswordException ex) {
        var errors = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),"Password",ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errors);
    }
}
