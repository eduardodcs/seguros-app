package com.bank.seguros.core.vida.entities;

import java.time.LocalDate;

import com.bank.seguros.core.commons.enums.TipoPlano;

public class SeguroVidaPedidoSimulacao {

    private TipoPlano tipoPlano;
    private LocalDate dataNascimento;

    public static Builder builder() {
        return new Builder();
    }

    public SeguroVidaPedidoSimulacao() {
        // Default constructor
    }

    public static class Builder {
        private SeguroVidaPedidoSimulacao seguroVidaPedidoSimulacao;

        public Builder() {
            seguroVidaPedidoSimulacao = new SeguroVidaPedidoSimulacao();
        }

        public Builder tipoPlano(TipoPlano tipoPlano) {
            this.seguroVidaPedidoSimulacao.tipoPlano = tipoPlano;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento) {
            this.seguroVidaPedidoSimulacao.dataNascimento = dataNascimento;
            return this;
        }

        public SeguroVidaPedidoSimulacao build() {
            return seguroVidaPedidoSimulacao;
        }
    }

    public Builder toBuilder() {
        return new Builder()
                .tipoPlano(this.tipoPlano)
                .dataNascimento(this.dataNascimento);
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
