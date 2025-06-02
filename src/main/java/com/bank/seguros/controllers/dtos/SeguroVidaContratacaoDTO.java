package com.bank.seguros.controllers.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.bank.seguros.core.commons.enums.TipoPlano;

public class SeguroVidaContratacaoDTO {

    private UUID apolice;
    private Long idCliente;
    private UUID idSimulacao;
    private TipoPlano tipoPlano;
    private String descricaoSeguro;
    private Set<CoberturaDTO> coberturas;
    private double valorPremioMensal;
    private LocalDateTime dataHoraContratacao;
    private LocalDateTime dataHoraSimulacao;

    public SeguroVidaContratacaoDTO() {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .apolice(this.apolice)
                .idCliente(this.idCliente)
                .idSimulacao(this.idSimulacao)
                .tipoPlano(this.tipoPlano)
                .descricaoSeguro(this.descricaoSeguro)
                .coberturas(this.coberturas)
                .valorPremioMensal(this.valorPremioMensal)
                .dataHoraSimulacao(this.dataHoraSimulacao)
                .dataHoraContratacao(this.dataHoraContratacao);
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private SeguroVidaContratacaoDTO seguroPedidoVidaContratacaoDTO;

        public Builder() {
            seguroPedidoVidaContratacaoDTO = new SeguroVidaContratacaoDTO();
        }

        public Builder apolice(UUID apolice) {
            this.seguroPedidoVidaContratacaoDTO.apolice = apolice;
            return this;
        }

        public Builder idCliente(Long idCliente) {
            this.seguroPedidoVidaContratacaoDTO.idCliente = idCliente;
            return this;
        }

        public Builder idSimulacao(UUID idSimulacao) {
            this.seguroPedidoVidaContratacaoDTO.idSimulacao = idSimulacao;
            return this;
        }

        public Builder tipoPlano(TipoPlano tipoPlano) {
            this.seguroPedidoVidaContratacaoDTO.tipoPlano = tipoPlano;
            return this;
        }

        public Builder descricaoSeguro(String descricaoSeguro) {
            this.seguroPedidoVidaContratacaoDTO.descricaoSeguro = descricaoSeguro;
            return this;
        }

        public Builder coberturas(Set<CoberturaDTO> coberturas) {
            this.seguroPedidoVidaContratacaoDTO.coberturas = coberturas;
            return this;
        }

        public Builder valorPremioMensal(double valorPremioMensal) {
            this.seguroPedidoVidaContratacaoDTO.valorPremioMensal = valorPremioMensal;
            return this;
        }

        public Builder dataHoraSimulacao(LocalDateTime dataHoraSimulacao) {
            this.seguroPedidoVidaContratacaoDTO.dataHoraSimulacao = dataHoraSimulacao;
            return this;
        }

        public Builder dataHoraContratacao(LocalDateTime dataHoraContratacao) {
            this.seguroPedidoVidaContratacaoDTO.dataHoraContratacao = dataHoraContratacao;
            return this;
        }

        public SeguroVidaContratacaoDTO build() {
            return seguroPedidoVidaContratacaoDTO;
        }
    }
    public UUID getApolice() {
        return apolice;
    }
    public Set<CoberturaDTO> getCoberturas() {
        return coberturas;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public UUID getIdSimulacao() {
        return idSimulacao;
    }
    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }
    public String getDescricaoSeguro() {
        return descricaoSeguro;
    }
    public double getValorPremioMensal() {
        return valorPremioMensal;
    }
    public LocalDateTime getDataHoraContratacao() {
        return dataHoraContratacao;
    }
    public LocalDateTime getDataHoraSimulacao() {
        return dataHoraSimulacao;
    }

}
