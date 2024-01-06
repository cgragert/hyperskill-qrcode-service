package qrcodeapi.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QrCodeErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleBadSize(ConstraintViolationException e) {
        MessageRank messageRank = MessageRank.getMinRank();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            final MessageRank newMessageRank = MessageRank.getByMessage(constraintViolation.getMessage());
            if (newMessageRank.getRank() > messageRank.getRank()) {
                messageRank = newMessageRank;
                if (newMessageRank.isMax()) {
                    break;
                }
            }
        }
        return ResponseEntity.badRequest().body(new ErrorMessage(messageRank.getMessage()));
    }
}
