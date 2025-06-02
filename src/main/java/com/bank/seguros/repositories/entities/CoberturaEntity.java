package com.bank.seguros.repositories.entities;

public class CoberturaEntity {

    private int id;
    private String descricao;
    private double valorPremio;
    private double valorCapitalSegurado;

    public CoberturaEntity() {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .id(this.id)
                .descricao(this.descricao)
                .valorPremio(this.valorPremio)
                .valorCapitalSegurado(this.valorCapitalSegurado);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CoberturaEntity coberturaEntity;

        public Builder() {
            coberturaEntity = new CoberturaEntity();
        }

        public Builder id(int id) {
            this.coberturaEntity.id = id;
            return this;
        }

        public Builder descricao(String descricao) {
            this.coberturaEntity.descricao = descricao;
            return this;
        }

        public Builder valorPremio(double valorPremio) {
            this.coberturaEntity.valorPremio = valorPremio;
            return this;
        }

        public Builder valorCapitalSegurado(double valorCapitalSegurado) {
            this.coberturaEntity.valorCapitalSegurado = valorCapitalSegurado;
            return this;
        }

        public CoberturaEntity build() {
            return coberturaEntity;
        }
    }
    public int getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getValorPremio() {
        return valorPremio;
    }
    public double getValorCapitalSegurado() {
        return valorCapitalSegurado;
    }
}
