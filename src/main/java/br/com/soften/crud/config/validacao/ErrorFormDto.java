package br.com.soften.crud.config.validacao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorFormDto {
    String field;

    String ErrorMessage;
}
