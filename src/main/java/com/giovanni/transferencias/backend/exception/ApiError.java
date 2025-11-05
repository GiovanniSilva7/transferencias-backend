package com.giovanni.transferencias.backend.exception;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    OffsetDateTime timestamp;
    int status;
    String erro;
    String mensagem;
    String caminho;
}
