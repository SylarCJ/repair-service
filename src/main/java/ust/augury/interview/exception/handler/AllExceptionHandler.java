package ust.augury.interview.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ust.augury.interview.exception.ErrorResponse;
import ust.augury.interview.exception.RepairDetailsNotFoundException;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(RepairDetailsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRepairDetailsNotFoundException(RepairDetailsNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

