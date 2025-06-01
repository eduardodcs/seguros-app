package com.bank.seguros.controllers.dtos;

public class CoberturaDTO {

    private String descricao;
    private double valorPremio;
    private double valorCapitalSegurado;

    public CoberturaDTO() {
        // Default constructor
    }

    public Builder toBuilder() {
        return new Builder()
                .descricao(this.descricao)
                .valorPremio(this.valorPremio)
                .valorCapitalSegurado(this.valorCapitalSegurado);
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private CoberturaDTO coberturaDTO;

        public Builder() {
            coberturaDTO = new CoberturaDTO();
        }

        public Builder descricao(String descricao) {
            this.coberturaDTO.descricao = descricao;
            return this;
        }

        public Builder valorPremio(double valorPremio) {
            this.coberturaDTO.valorPremio = valorPremio;
            return this;
        }

        public Builder valorCapitalSegurado(double valorCapitalSegurado) {
            this.coberturaDTO.valorCapitalSegurado = valorCapitalSegurado;
            return this;
        }

        public CoberturaDTO build() {
            return coberturaDTO;
        }
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
