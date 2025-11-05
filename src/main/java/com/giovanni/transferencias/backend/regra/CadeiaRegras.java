package com.giovanni.transferencias.backend.regra;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.giovanni.transferencias.backend.model.Taxa;

public class CadeiaRegras {
    private final List<RegraTaxa> regras;

    public CadeiaRegras(RegraTaxa regras, RegraSomenteFixa regraSomenteFixa, RegraSomentePercentual regraSomentePercentual, RegraSomentePercentual regraSomentePercentual2, RegraSomentePercentual regraSomentePercentual3, RegraSomentePercentual regraSomentePercentual4) {
        this.regras = Arrays.asList(regras);
    }

    public Optional<Taxa> resolver(int dias, BigDecimal valor) {
        for (RegraTaxa r : regras) {
            Optional<Taxa> t = r.aplicar(dias, valor);
            if (t.isPresent())
                return t;
        }
        return Optional.empty();
    }
}
