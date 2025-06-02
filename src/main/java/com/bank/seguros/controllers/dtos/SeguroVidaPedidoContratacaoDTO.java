package com.bank.seguros.controllers.dtos;

import java.util.UUID;

public class SeguroVidaPedidoContratacaoDTO {

    private UUID idSimulacao;
    private String cpfCliente;

    public SeguroVidaPedidoContratacaoDTO() {
        // default constructor
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder()
                .idSimulacao(idSimulacao)
                .cpfCliente(cpfCliente);
    }

    public static class Builder {
        SeguroVidaPedidoContratacaoDTO dto = new SeguroVidaPedidoContratacaoDTO();

        public Builder idSimulacao(UUID idSimulacao) {
            this.dto.idSimulacao = idSimulacao;
            return this;
        }

        public Builder cpfCliente(String cpfCliente) {
            this.dto.cpfCliente = cpfCliente;
            return this;
        }

        public SeguroVidaPedidoContratacaoDTO build() {
            return this.dto;
        }
    }

    public UUID getIdSimulacao() {
        return idSimulacao;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

}
