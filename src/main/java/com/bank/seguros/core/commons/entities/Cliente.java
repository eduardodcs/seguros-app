package com.bank.seguros.core.commons.entities;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;

    public Cliente() {
        // Default constructor
    }

    public static class Builder {
        private Cliente cliente;
        public Builder() {
            cliente = new Cliente();
        }
        public Builder id(Long id) {
            cliente.id = id;
            return this;
        }
        public Builder nome(String nome) {
            cliente.nome = nome;
            return this;
        }
        public Builder cpf(String cpf) {
            cliente.cpf = cpf;
            return this;
        }
        public Cliente build() {
            return cliente;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder()
                .id(this.id)
                .nome(this.nome)
                .cpf(this.cpf);
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
}
