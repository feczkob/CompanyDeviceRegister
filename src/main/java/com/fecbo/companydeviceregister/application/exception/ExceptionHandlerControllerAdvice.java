package com.fecbo.companydeviceregister.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler({NoSuchElementException.class, MissingEntityException.class})
    public ResponseEntity<RestApiError> handleNoSuchElement(NoSuchElementException ex) {
        log.error(ex.getLocalizedMessage(), ex);
        RestApiError restApiError = new RestApiError(ex.getMessage());
        return new ResponseEntity<>(restApiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<RestApiError> handleNoSuchFieldException(NoSuchFieldException ex) {
        log.error(ex.getLocalizedMessage(), ex);
        RestApiError restApiError = new RestApiError(ex.getMessage());
        return new ResponseEntity<>(restApiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<RestApiError> handleAccessDeniedException(AccessDeniedException ex) {
        log.error(ex.getLocalizedMessage(), ex);
        RestApiError restApiError = new RestApiError(ex.getMessage());
        return new ResponseEntity<>(restApiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestApiError> handleOthers(RuntimeException ex) {
        log.error(ex.getLocalizedMessage(), ex);
        RestApiError restApiError = new RestApiError(ex.getMessage());
        return new ResponseEntity<>(restApiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
