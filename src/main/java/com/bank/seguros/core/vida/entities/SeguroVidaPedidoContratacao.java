package com.bank.seguros.core.vida.entities;

import java.util.UUID;

public class SeguroVidaPedidoContratacao {

    private UUID idSimulacao;
    private String cpfCliente;

    public SeguroVidaPedidoContratacao() {
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
        SeguroVidaPedidoContratacao contratacao;

        public Builder() {
            this.contratacao = new SeguroVidaPedidoContratacao();
        }

        public Builder idSimulacao(UUID idSimulacao) {
            this.contratacao.idSimulacao = idSimulacao;
            return this;
        }

        public Builder cpfCliente(String cpfCliente) {
            this.contratacao.cpfCliente = cpfCliente;
            return this;
        }

        public SeguroVidaPedidoContratacao build() {
            return this.contratacao;
        }
    }

    public UUID getIdSimulacao() {
        return idSimulacao;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

}
