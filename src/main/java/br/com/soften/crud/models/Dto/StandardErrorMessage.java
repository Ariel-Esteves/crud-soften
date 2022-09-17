package br.com.soften.crud.models.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class StandardErrorMessage{
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
