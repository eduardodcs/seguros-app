package com.bank.seguros.client.dtos;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;

    public ClienteDTO() {
        // Default constructor
    }

    public static class Builder {
        private ClienteDTO clienteDTO;
        public Builder() {
            clienteDTO = new ClienteDTO();
        }
        public Builder id(Long id) {
            clienteDTO.id = id;
            return this;
        }
        public Builder nome(String nome) {
            clienteDTO.nome = nome;
            return this;
        }
        public Builder cpf(String cpf) {
            clienteDTO.cpf = cpf;
            return this;
        }
        public ClienteDTO build() {
            return clienteDTO;
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
