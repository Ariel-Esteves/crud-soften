package br.com.soften.crud.config.validation;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.Dto.StandardErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorMessage> ResourceNotFound( ResourceNotFoundException e, HttpServletRequest request ){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String ErrorMessage = "Content not found";
        StandardErrorMessage err =
                StandardErrorMessage.builder()
                        .path(request.getServletPath())
                        .error(e.getMessage())
                        .timestamp(Instant.now())
                        .status(status.value())
                        .message(ErrorMessage)
                        .build();

        return ResponseEntity.status(status).body(err);
    }

}
