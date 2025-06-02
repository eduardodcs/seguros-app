package com.bank.seguros.core;

import java.math.BigDecimal;

public interface ICobertura {
    int getId();
    String getDescricao();
    BigDecimal getValorPremio();
    BigDecimal getValorCapitalSegurado();
}
