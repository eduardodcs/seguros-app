package com.bank.seguros.adapters.gateways;
import java.util.Optional;
import java.util.UUID;

import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;

public interface ISeguroVidaGateway {

    SeguroVidaSimulacao salvarSimulacao(SeguroVidaSimulacao seguroVidaSimulacao);
    Optional<SeguroVidaSimulacao> buscarSimulacaoPorId(UUID idSimulacao);

}
