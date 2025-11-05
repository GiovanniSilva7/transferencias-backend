package com.giovanni.transferencias.backend.regra;

import java.math.BigDecimal;
import java.util.Optional;

import com.giovanni.transferencias.backend.model.Taxa;

public class RegraFixaPercentual implements RegraTaxa {
    private final int de;
    private final int ate;
    private final BigDecimal fixa;
    private final BigDecimal percentual;

    public RegraFixaPercentual(int de, int ate, BigDecimal fixa, BigDecimal percentual) {
        this.de = de;
        this.ate = ate;
        this.fixa = fixa;
        this.percentual = percentual;
    }

    public Optional<Taxa> aplicar(int dias, BigDecimal valor) {
        if (dias >= de && dias <= ate) {
            return Optional.of(new Taxa(fixa, percentual));
        }
        return Optional.empty();
    }

}
