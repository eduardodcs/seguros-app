package com.bank.seguros.repositories.entities;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bank.seguros.core.commons.enums.TipoPlano; 

@Document(collection = "seguro_vida_contratacao")
public class SeguroVidaContratacaoEntity {

    @Id
    private UUID apolice;
    private Long idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private UUID idSimulacao;
    private TipoPlano tipoPlano;
    private String descricaoSeguro;
    private Set<CoberturaEntity> coberturas;
    private double valorPremioMensal;
    private LocalDateTime dataHoraContratacao;
    private LocalDateTime dataHoraSimulacao;


    public SeguroVidaContratacaoEntity() {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .apolice(this.apolice)
                .idCliente(this.idCliente)
                .nomeCliente(this.nomeCliente)
                .cpfCliente(this.cpfCliente)  
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
        private SeguroVidaContratacaoEntity seguroVidaContratacaoEntity;

        public Builder() {
            seguroVidaContratacaoEntity = new SeguroVidaContratacaoEntity();
        }

        public Builder apolice(UUID apolice) {
            this.seguroVidaContratacaoEntity.apolice = apolice;
            return this;
        }

        public Builder idCliente(Long idCliente) {
            this.seguroVidaContratacaoEntity.idCliente = idCliente;
            return this;
        }

        public Builder nomeCliente(String nomeCliente) {
            this.seguroVidaContratacaoEntity.nomeCliente = nomeCliente;
            return this;
        }

        public Builder cpfCliente(String cpfCliente) {
            this.seguroVidaContratacaoEntity.cpfCliente = cpfCliente;
            return this;
        }

        public Builder idSimulacao(UUID idSimulacao) {
            this.seguroVidaContratacaoEntity.idSimulacao = idSimulacao;
            return this;
        }

        public Builder tipoPlano(TipoPlano tipoPlano) {
            this.seguroVidaContratacaoEntity.tipoPlano = tipoPlano;
            return this;
        }

        public Builder descricaoSeguro(String descricaoSeguro) {
            this.seguroVidaContratacaoEntity.descricaoSeguro = descricaoSeguro;
            return this;
        }

        public Builder coberturas(Set<CoberturaEntity> coberturas) {
            this.seguroVidaContratacaoEntity.coberturas = coberturas;
            return this;
        }

        public Builder valorPremioMensal(double valorPremioMensal) {
            this.seguroVidaContratacaoEntity.valorPremioMensal = valorPremioMensal;
            return this;
        }

        public Builder dataHoraSimulacao(LocalDateTime dataHoraSimulacao) {
            this.seguroVidaContratacaoEntity.dataHoraSimulacao = dataHoraSimulacao;
            return this;
        }

        public Builder dataHoraContratacao(LocalDateTime dataHoraContratacao) {
            this.seguroVidaContratacaoEntity.dataHoraContratacao = dataHoraContratacao;
            return this;
        }
        
        public SeguroVidaContratacaoEntity build() {
            return seguroVidaContratacaoEntity;
        }
    }
    public UUID getApolice() {
        return apolice;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public String getCpfCliente() {
        return cpfCliente;
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
    public LocalDateTime getDataHoraContratacao() {
        return dataHoraContratacao;
    }
    

}