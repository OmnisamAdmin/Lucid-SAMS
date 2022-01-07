package za.co.sfy.lucid.sams.rest.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.co.sfy.lucid.sams.rest.errors.ApiError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex);

        ex.getBindingResult()
                .getAllErrors()
                .forEach((ObjectError objectError) -> {
                    FieldError fieldError = (FieldError) objectError;
                    apiError.addValidationError(fieldError);
                });

        apiError.setMessage("The information supplied is invalid.");
        apiError.setDebugMessage(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(apiError);
    }
}
