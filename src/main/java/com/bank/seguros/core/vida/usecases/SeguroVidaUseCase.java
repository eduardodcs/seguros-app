package com.bank.seguros.core.vida.usecases;

import com.bank.seguros.adapters.gateways.ISeguroVidaGateway;
import com.bank.seguros.adapters.usecases.ISeguroVidaUseCase;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;

public class SeguroVidaUseCase implements ISeguroVidaUseCase {

    private ISeguroVidaGateway seguroVidaGateway;

    public SeguroVidaUseCase(ISeguroVidaGateway seguroVidaGateway) {
        this.seguroVidaGateway = seguroVidaGateway;
    }

    public SeguroVidaSimulacao simular(SeguroVidaPedidoSimulacao pedidoSimulacao) {
        return seguroVidaGateway.salvarSimulacao(new SeguroVidaSimulacao.Builder()
                .tipoPlano(pedidoSimulacao.getTipoPlano())
                .build());
    }
}
