package com.bank.seguros.repositories.entities;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bank.seguros.core.commons.enums.TipoPlano; 

@Document(collection = "seguro_vida_simulacao")
public class SeguroVidaSimulacaoEntity {

    @Id
    private UUID idSimulacao;
    private TipoPlano tipoPlano;
    private String descricaoSeguro;
    private Set<CoberturaEntity> coberturas;
    private double valorPremioMensal;
    private LocalDateTime dataHoraSimulacao;
    private LocalDate dataValidadeSimulacao;

    public SeguroVidaSimulacaoEntity() {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .idSimulacao(this.idSimulacao)
                .tipoPlano(this.tipoPlano)
                .descricaoSeguro(this.descricaoSeguro)
                .coberturas(this.coberturas)
                .valorPremioMensal(this.valorPremioMensal)
                .dataHoraSimulacao(this.dataHoraSimulacao)
                .dataValidadeSimulacao(this.dataValidadeSimulacao);
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private SeguroVidaSimulacaoEntity seguroVidaSimulacaoEntity;

        public Builder() {
            seguroVidaSimulacaoEntity = new SeguroVidaSimulacaoEntity();
        }

        public Builder idSimulacao(UUID idSimulacao) {
            this.seguroVidaSimulacaoEntity.idSimulacao = idSimulacao;
            return this;
        }

        public Builder tipoPlano(TipoPlano tipoPlano) {
            this.seguroVidaSimulacaoEntity.tipoPlano = tipoPlano;
            return this;
        }

        public Builder descricaoSeguro(String descricaoSeguro) {
            this.seguroVidaSimulacaoEntity.descricaoSeguro = descricaoSeguro;
            return this;
        }

        public Builder coberturas(Set<CoberturaEntity> coberturas) {
            this.seguroVidaSimulacaoEntity.coberturas = coberturas;
            return this;
        }

        public Builder valorPremioMensal(double valorPremioMensal) {
            this.seguroVidaSimulacaoEntity.valorPremioMensal = valorPremioMensal;
            return this;
        }

        public Builder dataHoraSimulacao(LocalDateTime dataHoraSimulacao) {
            this.seguroVidaSimulacaoEntity.dataHoraSimulacao = dataHoraSimulacao;
            return this;
        }

        public Builder dataValidadeSimulacao(LocalDate dataValidadeSimulacao) {
            this.seguroVidaSimulacaoEntity.dataValidadeSimulacao = dataValidadeSimulacao;
            return this;
        }

        public SeguroVidaSimulacaoEntity build() {
            return seguroVidaSimulacaoEntity;
        }
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
    public Set<CoberturaEntity> getCoberturas() {
        return coberturas;
    }
    public double getValorPremioMensal() {
        return valorPremioMensal;
    }
    public LocalDateTime getDataHoraSimulacao() {
        return dataHoraSimulacao;
    }
    public LocalDate getDataValidadeSimulacao() {
        return dataValidadeSimulacao;
    }

}