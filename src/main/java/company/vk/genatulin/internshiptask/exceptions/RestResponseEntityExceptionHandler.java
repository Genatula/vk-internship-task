package company.vk.genatulin.internshiptask.exceptions;

import company.vk.genatulin.internshiptask.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleBadRequest(IllegalArgumentException exception, WebRequest request) {
        String bodyOfResponse = "Invalid request body and/or parameters provided";
        return handleExceptionInternal(exception, new ErrorMessage(bodyOfResponse), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
