package com.giovanni.transferencias.backend.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class TaxaCalculator {
    public static class ResultadoTaxa {
        public final BigDecimal fixa;
        public final BigDecimal percentual;
        public final BigDecimal total;

        ResultadoTaxa(BigDecimal fixa, BigDecimal percentual, BigDecimal total) {
            this.fixa = fixa;
            this.percentual = percentual;
            this.total = total;
        }
    }

    public Optional<ResultadoTaxa> calcular(int dias, BigDecimal valor) {
        BigDecimal fixa = BigDecimal.ZERO;
        BigDecimal perc = BigDecimal.ZERO;
        if (dias == 0) {
            fixa = bd("3.00");
            perc = bd("0.025");
        } else if (dias >= 1 && dias <= 10) {
            fixa = bd("12.00");
        } else if (dias >= 11 && dias <= 20) {
            perc = bd("0.082");
        } else if (dias >= 21 && dias <= 30) {
            perc = bd("0.069");
        } else if (dias >= 31 && dias <= 40) {
            perc = bd("0.047");
        } else if (dias >= 41 && dias <= 50) {
            perc = bd("0.017");
        } else {
            return Optional.empty();
        }
        BigDecimal total = fixa.add(valor.multiply(perc)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return Optional.of(new ResultadoTaxa(fixa, perc, total));
    }

    private BigDecimal bd(String v) {
        return new BigDecimal(v);
    }
}
