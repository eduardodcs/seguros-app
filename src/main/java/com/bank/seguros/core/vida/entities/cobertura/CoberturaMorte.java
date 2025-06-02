package com.bank.seguros.core.vida.entities.cobertura;

import java.math.BigDecimal;

import com.bank.seguros.core.commons.constants.CoberturaId;
import com.bank.seguros.core.vida.entities.ICoberturaVida;

public class CoberturaMorte implements ICoberturaVida {

    @Override
    public int getId() {
        return CoberturaId.VIDA_COBERTURA_MORTE.getId();
    }

    @Override
    public String getDescricao() {
        return "Cobertura por Morte";
    }

    @Override
    public BigDecimal getValorPremio() {
        return new BigDecimal("100.00");
    }

    @Override
    public BigDecimal getValorCapitalSegurado() {
        return new BigDecimal("100000.00");
    }

}
