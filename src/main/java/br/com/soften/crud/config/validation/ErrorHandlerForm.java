package br.com.soften.crud.config.validation;

import br.com.soften.crud.models.Dto.ErrorFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandlerForm {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public List<ErrorFormDto> handle(MethodArgumentNotValidException exception) {
        List<ErrorFormDto> errorList = new ArrayList<>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        errors.forEach(err -> {
            ErrorFormDto temp =
                    ErrorFormDto.builder()
                            .field(err.getField())
                            .ErrorMessage(messageSource.getMessage(err, LocaleContextHolder.getLocale()))
                            .build();
            errorList.add(temp);
        });
        return errorList;
    }
}
