package com.bank.seguros.core.commons.constants;

import com.bank.common_web.exceptions.NotFoundException;

public enum CoberturaId {

    VIDA_COBERTURA_MORTE(1),
    VIDA_COBERTURA_INVALIDEZ(2),
    VIDA_COBERTURA_DOENCA_GRAVE(3);

    private final int id;

    CoberturaId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public static CoberturaId fromId(int id) {
        for (CoberturaId cobertura : values()) {
            if (cobertura.getId() == id) {
                return cobertura;
            }
        }
        throw new NotFoundException("CoberturaId not found for id: " + id);
    }

}
