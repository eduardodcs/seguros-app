package com.bank.seguros.controllers.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.bank.seguros.core.commons.enums.TipoPlano;

public class SeguroVidaSimulacaoDTO {

    private TipoPlano tipoPlano;
    private String descricaoSeguro;
    private Set<CoberturaDTO> coberturas;
    private double valorPremioMensal;
    private UUID idSimulacao;
    private LocalDateTime dataHoraSimulacao;
    private LocalDate dataValidadeSimulacao;

    public SeguroVidaSimulacaoDTO () {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .tipoPlano(tipoPlano)
                .descricaoSeguro(descricaoSeguro)
                .coberturas(coberturas)
                .valorPremioMensal(valorPremioMensal)
                .idSimulacao(idSimulacao)
                .dataHoraSimulacao(dataHoraSimulacao)
                .dataValidadeSimulacao(dataValidadeSimulacao);
    }

    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private SeguroVidaSimulacaoDTO seguroVidaSimulacaoDTO;
        public Builder() {
            seguroVidaSimulacaoDTO = new SeguroVidaSimulacaoDTO();
        }
        public Builder tipoPlano(TipoPlano tipoPlano) {
            seguroVidaSimulacaoDTO.tipoPlano = tipoPlano;
            return this;
        }
        public Builder descricaoSeguro(String descricaoSeguro) {
            seguroVidaSimulacaoDTO.descricaoSeguro = descricaoSeguro;
            return this;
        }
        public Builder coberturas(Set<CoberturaDTO> coberturas) {
            seguroVidaSimulacaoDTO.coberturas = coberturas;
            return this;
        }
        public Builder valorPremioMensal(double valorPremioMensal) {
            seguroVidaSimulacaoDTO.valorPremioMensal = valorPremioMensal;
            return this;
        }
        public Builder idSimulacao(UUID idSimulacao) {
            seguroVidaSimulacaoDTO.idSimulacao = idSimulacao;
            return this;
        }
        public Builder dataHoraSimulacao(LocalDateTime dataHoraSimulacao) {
            seguroVidaSimulacaoDTO.dataHoraSimulacao = dataHoraSimulacao;
            return this;
        }
        public Builder dataValidadeSimulacao(LocalDate dataValidadeSimulacao) {
            seguroVidaSimulacaoDTO.dataValidadeSimulacao = dataValidadeSimulacao;
            return this;
        }
        public SeguroVidaSimulacaoDTO build() {
            return seguroVidaSimulacaoDTO;
        }   
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }
    public String getDescricaoSeguro() {
        return descricaoSeguro;
    }
    public Set<CoberturaDTO> getCoberturas() {
        return coberturas;
    }
    public double getValorPremioMensal() {
        return valorPremioMensal;
    }
    public UUID getIdSimulacao() {
        return idSimulacao;
    }
    public LocalDateTime getDataHoraSimulacao() {
        return dataHoraSimulacao;
    }
    public LocalDate getDataValidadeSimulacao() {
        return dataValidadeSimulacao;
    }
    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }
  
    
    
}
