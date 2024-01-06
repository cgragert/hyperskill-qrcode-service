package qrcodeapi.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Comparator;

@ControllerAdvice
public class QrCodeErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleBadSize(ConstraintViolationException e) {
        ErrorMessage errorMessage = e.getConstraintViolations()
                .stream()
                .sorted(Comparator.comparing(v -> v.getPropertyPath().toString()))
                .map(ConstraintViolation::getMessage)
                .map(ErrorMessage::new)
                .findFirst()
                .orElse(null);
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
