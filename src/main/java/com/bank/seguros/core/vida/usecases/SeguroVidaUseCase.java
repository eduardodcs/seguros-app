package com.bank.seguros.core.vida.usecases;

import com.bank.seguros.adapters.interfaces.usecases.ISeguroVidaUseCase;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;

public class SeguroVidaUseCase implements ISeguroVidaUseCase {

    @Override
    public SeguroVidaSimulacao simular(SeguroVidaPedidoSimulacao pedidoSimulacao) {
        return new SeguroVidaSimulacao.Builder()
                .tipoPlano(pedidoSimulacao.getTipoPlano())
                .build();
    }
}
