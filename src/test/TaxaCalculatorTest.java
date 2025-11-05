package com.giovanni.transferencias.backend.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

class TaxaCalculatorTest {
    @Test
    void limitesFuncionam(){
        TaxaCalculator c = new TaxaCalculator();
        assertTrue(c.calcular(0, new BigDecimal("1000"))).isPresent();
        assertTrue(c.calcular(10, new BigDecimal("1000"))).isPresent();
        assertTrue(c.calcular(11, new BigDecimal("1000"))).isPresent();
        assertTrue(c.calcular(50, new BigDecimal("1000"))).isPresent();
        assertFalse(c.calcular(51, new BigDecimal("1000"))).isPresent();
    }
}
