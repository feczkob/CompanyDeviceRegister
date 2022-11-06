package com.fecbo.companydeviceregister.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<RestApiError> handleNoSuchElement(NoSuchElementException ex) {
        log.error(ex.getLocalizedMessage(), ex);
        RestApiError restApiError = new RestApiError(ex.getMessage());
        return new ResponseEntity<RestApiError>(restApiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestApiError> handleOthers(RuntimeException ex) {
        log.error(ex.getLocalizedMessage(), ex);
        RestApiError restApiError = new RestApiError(ex.getMessage());
        return new ResponseEntity<RestApiError>(restApiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
