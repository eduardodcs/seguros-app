package com.bank.seguros.core.vida.entities.cobertura;

import java.math.BigDecimal;

import com.bank.seguros.core.vida.entities.ICoberturaVida;

public class CoberturaInvalidez implements ICoberturaVida {

    @Override
    public String getDescricao() {
        return "Cobertura por Morte";
    }

    @Override
    public BigDecimal getValorPremio() {
        return new BigDecimal("50.00");
    }

    @Override
    public BigDecimal getValorCapitalSegurado() {
        return new BigDecimal("150000.00");
    }

}
