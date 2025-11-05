package com.giovanni.transferencias.backend.regra;

import java.math.BigDecimal;
import java.util.Optional;

import com.giovanni.transferencias.backend.model.Taxa;

public interface RegraTaxa {
    Optional<Taxa>aplicar(int dias, BigDecimal valor);
} 
