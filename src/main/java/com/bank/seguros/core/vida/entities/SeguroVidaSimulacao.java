package com.bank.seguros.core.vida.entities;

import java.time.LocalDate;

public class SeguroVidaSimulacao extends SeguroVidaAbstract {

    private static final int PRAZO_VALIDADE_PROPOSTA = 5;

    private LocalDate dataValidadeSimulacao;

    public SeguroVidaSimulacao() {
        super(null);
    }

    private SeguroVidaSimulacao(Builder builder) {
        super(builder);
        this.dataValidadeSimulacao = super.getDataHoraSimulacao().toLocalDate().plusDays(PRAZO_VALIDADE_PROPOSTA);
    }

    public Builder toBuilder() {
        return new Builder()
                .tipoPlano(this.tipoPlano);
    }

    public static class Builder extends SeguroVidaAbstract.Builder<SeguroVidaSimulacao, Builder> {

        public Builder() {
            super();
        }

        @Override
        public SeguroVidaSimulacao build() {
            return new SeguroVidaSimulacao(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String getDescricaoSeguro() {
        return "Simulação de Seguro de Vida - Plano: " + getTipoPlano().getDescricao();

    }

    public LocalDate getDataValidadeSimulacao() {
        return dataValidadeSimulacao;
    }

    

}
