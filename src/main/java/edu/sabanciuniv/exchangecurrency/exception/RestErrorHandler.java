package edu.sabanciuniv.exchangecurrency.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ExchangeApiExceptionTemplate> handleException(UnauthorizedException e) {
        ExchangeApiExceptionTemplate template = getExchangeApiExceptionTemplate(e.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(template, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExchangeApiExceptionTemplate> handleException(IllegalArgumentException e) {
        ExchangeApiExceptionTemplate template = getExchangeApiExceptionTemplate(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(template, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchPairException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExchangeApiExceptionTemplate> handleException(NoSuchPairException e) {
        ExchangeApiExceptionTemplate template = getExchangeApiExceptionTemplate(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(template, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoSuchTransactionException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExchangeApiExceptionTemplate> handleException(NoSuchTransactionException e) {
        ExchangeApiExceptionTemplate template = getExchangeApiExceptionTemplate(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(template, HttpStatus.NOT_FOUND);
    }

    private ExchangeApiExceptionTemplate getExchangeApiExceptionTemplate(String message, HttpStatus status) {
        ExchangeApiExceptionTemplate template = new ExchangeApiExceptionTemplate();
        template.setExceptionMessage(message);
        template.setStatusCode(status.value());
        template.setExceptionDate(LocalDateTime.now());
        return template;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ExchangeApiExceptionTemplate {
        private int statusCode;
        private String exceptionMessage;
        private LocalDateTime exceptionDate;
    }
}
