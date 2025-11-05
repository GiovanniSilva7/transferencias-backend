package com.giovanni.transferencias.backend.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Taxa {
    private BigDecimal fixa;        
    private BigDecimal percentual;  

    public BigDecimal total(BigDecimal valor){
        if (valor == null) return BigDecimal.ZERO;
        BigDecimal p = (percentual == null ? BigDecimal.ZERO : percentual);
        BigDecimal f = (fixa == null ? BigDecimal.ZERO : fixa);
        return f.add(valor.multiply(p)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
