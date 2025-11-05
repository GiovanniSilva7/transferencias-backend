package com.giovanni.transferencias.backend.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.giovanni.transferencias.backend.model.AgendamentoTransferencia;

public interface CasoDeUsoConsultarTransferencias {
    Page<AgendamentoTransferencia> listar(Pageable pageable);
}
