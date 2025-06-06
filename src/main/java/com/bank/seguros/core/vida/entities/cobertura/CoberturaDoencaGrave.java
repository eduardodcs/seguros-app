package com.bank.seguros.core.vida.entities.cobertura;

import java.math.BigDecimal;

import com.bank.seguros.core.commons.constants.CoberturaId;
import com.bank.seguros.core.vida.entities.ICoberturaVida;

public class CoberturaDoencaGrave implements ICoberturaVida {

    @Override
    public int getId() {
        return CoberturaId.VIDA_COBERTURA_DOENCA_GRAVE.getId();
    }

    @Override
    public String getDescricao() {
        return "Cobertura por Morte";
    }

    @Override
    public BigDecimal getValorPremio() {
        return new BigDecimal("30.00");
    }

    @Override
    public BigDecimal getValorCapitalSegurado() {
        return new BigDecimal("120000.00");
    }

}
