package com.bank.seguros.core;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.bank.seguros.core.commons.enums.TipoPlano;

public abstract class SeguroAbstract {

    protected TipoPlano tipoPlano;
    protected String descricaoSeguro;
    protected Set<ICobertura> coberturas = new HashSet<>();
    protected double valorPremioMensal;

    protected SeguroAbstract(Builder<?, ?> builder) {
        this.tipoPlano = builder.tipoPlano;
    }

    public abstract static class Builder<T extends SeguroAbstract, B extends Builder<T, B>> {
        protected TipoPlano tipoPlano;

        public B tipoPlano(TipoPlano tipoPlano) {
            this.tipoPlano = tipoPlano;
            return self();
        }

        protected abstract B self();

        public abstract SeguroAbstract build();
    }

    public abstract String getDescricaoSeguro();

    protected abstract void adicionarCoberturaPlano(ICobertura cobertura);

    protected abstract BigDecimal calcularValorMensalPremio();

    public Set<ICobertura> getCoberturas() {
        return coberturas;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }   
   
    
    public double getValorPremioMensal() {
        return valorPremioMensal;
    }


    
}
