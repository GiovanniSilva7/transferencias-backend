package com.giovanni.transferencias.backend.regra;

import java.math.BigDecimal;
import java.util.Optional;

import com.giovanni.transferencias.backend.model.Taxa;

public class RegraSomenteFixa implements RegraTaxa {
    private final int de;
    private final int ate;
    private final BigDecimal fixa;

    public RegraSomenteFixa(int de, int ate, BigDecimal fixa) {
        this.de = de;
        this.ate = ate;
        this.fixa = fixa;
    }

    public Optional<Taxa> aplicar(int dias, BigDecimal valor) {
        if (dias >= de && dias <= ate) {
            return Optional.of(new Taxa(fixa, BigDecimal.ZERO));
        }
        return Optional.empty();
    }
}
