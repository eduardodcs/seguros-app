package com.bank.seguros.adapters.usecases;

import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;

public interface ISeguroVidaUseCase {

    SeguroVidaSimulacao simular(SeguroVidaPedidoSimulacao pedidoSimulacao);

}
