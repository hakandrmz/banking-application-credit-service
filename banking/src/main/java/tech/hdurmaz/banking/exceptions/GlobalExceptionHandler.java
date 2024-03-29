package tech.hdurmaz.banking.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  //Handle specific exceptions
  @ExceptionHandler(CustomerAlreadyExistException.class)
  public ResponseEntity<ErrorDetails> handleCustomerAlreadyExistException(
      CustomerAlreadyExistException exception,
      WebRequest webRequest) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
        webRequest.getDescription(false)
    );
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  //global exceptions
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleGlobalExceptions(Exception exception,
      WebRequest webRequest) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
        webRequest.getDescription(false)
    );
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
