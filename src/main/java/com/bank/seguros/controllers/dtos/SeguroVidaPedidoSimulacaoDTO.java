package com.bank.seguros.controllers.dtos;

import java.time.LocalDate;

import com.bank.seguros.core.commons.enums.TipoPlano;

import jakarta.validation.constraints.NotNull;

public class SeguroVidaPedidoSimulacaoDTO {

    @NotNull
    private TipoPlano tipoPlano;
    private LocalDate dataNascimento;

    public SeguroVidaPedidoSimulacaoDTO() {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .tipoPlano(this.tipoPlano)
                .dataNascimento(this.dataNascimento);
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private SeguroVidaPedidoSimulacaoDTO seguroVidaPedidoSimulacaoDTO;

        public Builder() {
            seguroVidaPedidoSimulacaoDTO = new SeguroVidaPedidoSimulacaoDTO();
        }

        public Builder tipoPlano(TipoPlano tipoPlano) {
            this.seguroVidaPedidoSimulacaoDTO.tipoPlano = tipoPlano;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento) {
            this.seguroVidaPedidoSimulacaoDTO.dataNascimento = dataNascimento;
            return this;
        }

        public SeguroVidaPedidoSimulacaoDTO build() {
            return seguroVidaPedidoSimulacaoDTO;
        }
    }
    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
