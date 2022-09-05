package br.com.soften.crud.models.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorFormDto {
    String field;

    String ErrorMessage;
}
