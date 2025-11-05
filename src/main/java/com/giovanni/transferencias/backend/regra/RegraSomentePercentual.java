package com.giovanni.transferencias.backend.regra;

import java.math.BigDecimal;
import java.util.Optional;

import com.giovanni.transferencias.backend.model.Taxa;

public class RegraSomentePercentual implements RegraTaxa {
    private final int de;
    private final int ate;
    private final BigDecimal percentual;

    public RegraSomentePercentual(int de, int ate, BigDecimal percentual) {
        this.de = de;
        this.ate = ate;
        this.percentual = percentual;
    }

    public Optional<Taxa> aplicar(int dias, BigDecimal valor) {
        if (dias >= de && dias <= ate) {
            return Optional.of(new Taxa(BigDecimal.ZERO, percentual));
        }
        return Optional.empty();
    }
}
