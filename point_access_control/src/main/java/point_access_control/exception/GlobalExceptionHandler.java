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
        String message = "O recurso solicitado não foi encontrado";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullException.class)
    public ResponseEntity<String> handleNullException(NullException nullException){
        String message = "Verifique se os campos estão corretamente preenchidos";
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundElementsException.class)
    public ResponseEntity<String> handleNotFoundElementsException(NotFoundElementsException notFoundElementsException){
       String message = "Os recursos solicitados não foram encontrado";
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException){
//        String message = "Erro inesperado do servidor";
//        LOGGER.error(message, unexpectedException);
//        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
