package qrcodeapi.service;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QrCodeErrorHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorMessage> handleBadType() {
        return ResponseEntity.badRequest().body(ErrorMessage.ERROR_TYPE);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleBadSize() {
        return ResponseEntity.badRequest().body(ErrorMessage.ERROR_SIZE);
    }
}
