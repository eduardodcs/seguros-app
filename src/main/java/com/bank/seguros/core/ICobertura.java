package com.bank.seguros.core;

import java.math.BigDecimal;

public interface ICobertura {
    String getDescricao();
    BigDecimal getValorPremio();
    BigDecimal getValorCapitalSegurado();
}
