package com.bank.seguros.core.vida.usecases;

import java.time.LocalDate;
import java.util.UUID;

import com.bank.common_web.exceptions.BusinessException;
import com.bank.common_web.exceptions.NotFoundException;
import com.bank.seguros.adapters.gateways.IClienteGateway;
import com.bank.seguros.adapters.gateways.ISeguroVidaGateway;
import com.bank.seguros.adapters.usecases.ISeguroVidaUseCase;
import com.bank.seguros.core.commons.entities.Cliente;
import com.bank.seguros.core.vida.entities.SeguroVidaContratacao;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoContratacao;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;

public class SeguroVidaUseCase implements ISeguroVidaUseCase {

    private ISeguroVidaGateway seguroVidaGateway;
    private IClienteGateway clienteGateway;

    public SeguroVidaUseCase(ISeguroVidaGateway seguroVidaGateway, IClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
        this.seguroVidaGateway = seguroVidaGateway;
    }

    public SeguroVidaSimulacao simular(SeguroVidaPedidoSimulacao pedidoSimulacao) {
        return seguroVidaGateway.salvarSimulacao(new SeguroVidaSimulacao.Builder()
                .tipoPlano(pedidoSimulacao.getTipoPlano())
                .build());
    }

    @Override
    public SeguroVidaContratacao contratar(SeguroVidaPedidoContratacao pedidoContratacao) {
        Cliente cliente = clienteGateway.buscarPorCpf(pedidoContratacao.getCpfCliente());
        SeguroVidaSimulacao simulacao = seguroVidaGateway.buscarSimulacaoPorId(pedidoContratacao.getIdSimulacao())
                .orElseThrow(() -> new NotFoundException("Simulação não encontrada para o ID: " + pedidoContratacao.getIdSimulacao()));
        validarVencimentoSimulacao(simulacao);
        SeguroVidaContratacao contratacao = new SeguroVidaContratacao.Builder()
                .tipoPlano(simulacao.getTipoPlano())
                .dataHoraSimulacao(simulacao.getDataHoraSimulacao())
                .idSimulacao(simulacao.getIdSimulacao())
                .apolice(UUID.randomUUID())
                .cliente(cliente)
                .build();        
        return seguroVidaGateway.salvarContratacao(contratacao);
    }

    private void validarVencimentoSimulacao(SeguroVidaSimulacao simulacao) {
        if (LocalDate.now().isAfter(simulacao.getDataValidadeSimulacao())) {
            throw new BusinessException("Simulação vencida para o ID: " + simulacao.getIdSimulacao());
        }
    }

    
}
