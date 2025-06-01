package com.bank.seguros.core.commons.enums;

import com.bank.common_web.exceptions.NotFoundException;

public enum TipoPlano {
    BRONZE(1, "Plano Bronze"),
    PRATA(2, "Plano Prata"),
    OURO(3, "Plano Ouro");

    private final int id;
    private final String descricao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    TipoPlano(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static TipoPlano fromId(int id) {
        for (TipoPlano plano : TipoPlano.values()) {
            if (plano.getId() == id) {
                return plano;
            }
        }
        throw new NotFoundException("Plano com id " + id + " não encontrado.");
    }

}
