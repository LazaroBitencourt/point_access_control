package point_access_control.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullField.class)
    public ResponseEntity<String> handleNullField(NullField nullField){
        return new ResponseEntity<>(nullField.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ElementsNotFound.class)
    public ResponseEntity<String> handleElementsNotFound(ElementsNotFound elementsNotFound){
        return new ResponseEntity<>(elementsNotFound.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException){
        String message = "Erro inesperado do servidor.";
        LOGGER.error(message, unexpectedException);
        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
