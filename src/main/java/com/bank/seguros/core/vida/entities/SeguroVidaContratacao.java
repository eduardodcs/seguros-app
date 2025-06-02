package com.bank.seguros.core.vida.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.bank.seguros.core.commons.entities.Cliente;

public class SeguroVidaContratacao extends SeguroVidaAbstract {

    private UUID apolice;
    private Cliente cliente;
    private LocalDateTime dataHoraContratacao;

    public SeguroVidaContratacao(){
        super(null);
    }

    private SeguroVidaContratacao(Builder builder) {
        super(builder);
        this.apolice = builder.apolice;
        this.cliente = builder.cliente;
        this.dataHoraContratacao = obterDataHoraContratacao(builder);
        
        
    }

    private LocalDateTime obterDataHoraContratacao(Builder builder) {
        return builder.dataHoraContratacao != null ? builder.dataHoraContratacao : LocalDateTime.now();
    }

    public Builder toBuilder() {
        return new Builder()
                .tipoPlano(this.tipoPlano)
                .apolice(this.apolice)
                .cliente(this.cliente)
                .dataHoraContratacao(this.dataHoraContratacao);
    }

    public static class Builder extends SeguroVidaAbstract.Builder<SeguroVidaSimulacao, Builder> {
        private UUID apolice;
        private Cliente cliente;
        private LocalDateTime dataHoraContratacao;

        public Builder() {
            super();
        }

        public Builder apolice(UUID apolice) {
            this.apolice = apolice;
            return this;
        }

        public Builder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder dataHoraContratacao(LocalDateTime dataHoraContratacao) {
            this.dataHoraContratacao = dataHoraContratacao;
            return this;
        }

        @Override
        public SeguroVidaContratacao build() {
            return new SeguroVidaContratacao(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String getDescricaoSeguro() {
        return "Contrato de Seguro de Vida - " + getTipoPlano().getDescricao();
    }

    public UUID getApolice() {
        return apolice;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public LocalDateTime getDataHoraContratacao() {
        return dataHoraContratacao;
    }

}
