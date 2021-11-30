package ws.synopsis.trainingevaljhonatanarones.errorhandling.exception;

import lombok.NoArgsConstructor;

public class InvalidFieldException extends Exception{


    public InvalidFieldException(String content){
        super(content);
    }
}
