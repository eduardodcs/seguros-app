package com.bank.seguros.core.vida;

import java.util.Set;

import com.bank.common_web.exceptions.BusinessException;
import com.bank.seguros.core.ICobertura;
import com.bank.seguros.core.commons.enums.TipoPlano;
import com.bank.seguros.core.vida.entities.cobertura.CoberturaMorte;
import com.bank.seguros.core.vida.entities.cobertura.CoberturaInvalidez;
import com.bank.seguros.core.vida.entities.cobertura.CoberturaDoencaGrave;

public class SeguroVidaCoberturas {

    private SeguroVidaCoberturas() {
        // Prevent instantiation
    }

    public static void atribuirCoberturas(TipoPlano tipoPlano, Set<ICobertura> coberturas) {
        switch (tipoPlano) {
            case BRONZE:
                coberturas.add(new CoberturaMorte());
                break;
            case PRATA:
                coberturas.add(new CoberturaMorte());
                coberturas.add(new CoberturaInvalidez());
                break;
            case OURO:
                coberturas.add(new CoberturaMorte());
                coberturas.add(new CoberturaInvalidez());
                coberturas.add(new CoberturaDoencaGrave());
                break;
            default:
                throw new BusinessException("Tipo de plano inválido: " + tipoPlano);

        }
    }

}
