package br.com.soften.crud.config.validation;

import br.com.soften.crud.exceptions.ArgNullFoundException;
import br.com.soften.crud.models.Dto.StandardErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class NullFieldException{
    @ExceptionHandler(ArgNullFoundException.class)
    public ResponseEntity<StandardErrorMessage> NullFieldError( ArgNullFoundException e, HttpServletRequest request ){
        HttpStatus status = HttpStatus.PARTIAL_CONTENT;
        String errorMessage = "Um dos campos preenchidos foram verificados como nulo, ou com tipagem diferente da esperada";

        StandardErrorMessage err = StandardErrorMessage.builder()
                .error(e.getMessage())
                .path(request.getServletPath())
                .message(errorMessage)
                .timestamp(Instant.now())
                .status(status.value())
                .build();
        return ResponseEntity.status(status).body(err);

    }
}
