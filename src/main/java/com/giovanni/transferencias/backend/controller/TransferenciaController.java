package com.giovanni.transferencias.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.giovanni.transferencias.backend.infra.dto.RequisicaoTransferencia;
import com.giovanni.transferencias.backend.infra.dto.RespostaTransferencia;
import com.giovanni.transferencias.backend.service.TransferenciaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/transfers")
@RequiredArgsConstructor
public class TransferenciaController {

    private final TransferenciaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaTransferencia agendar(@Validated @RequestBody RequisicaoTransferencia req) {
        return service.agendar(req);
    }

    @GetMapping
    public Page<RespostaTransferencia> listar(Pageable pageable) {
        return service.listar(pageable);
    }
}
