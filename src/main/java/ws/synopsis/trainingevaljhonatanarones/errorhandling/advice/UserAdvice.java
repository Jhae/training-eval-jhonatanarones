package ws.synopsis.trainingevaljhonatanarones.errorhandling.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.synopsis.trainingevaljhonatanarones.bean.response.SimpleResponse;
import ws.synopsis.trainingevaljhonatanarones.errorhandling.exception.DuplicatedCellPhoneException;
import ws.synopsis.trainingevaljhonatanarones.errorhandling.exception.InvalidFieldException;

@ControllerAdvice
public class UserAdvice {

    @ExceptionHandler({InvalidFieldException.class, DuplicatedCellPhoneException.class})
    public ResponseEntity<?> adviceFieldException(Exception e){
        return ResponseEntity.internalServerError().body(SimpleResponse.builder().message(e.getMessage()).build());
    }

}
