package com.bank.seguros.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.seguros.adapters.gateways.ISeguroVidaGateway;
import com.bank.seguros.core.vida.entities.SeguroVidaContratacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;
import com.bank.seguros.mappers.ISeguroVidaMapper;
import com.bank.seguros.repositories.mongo.ISeguroVidaContratacaoRepository;
import com.bank.seguros.repositories.mongo.ISeguroVidaSimulacaoRepository;

@Component
public class SeguroVidaGatewayImpl implements ISeguroVidaGateway {

    @Autowired
    private ISeguroVidaSimulacaoRepository seguroVidaSimulacaoRepository;

    @Autowired
    private ISeguroVidaContratacaoRepository seguroVidaContratacaoRepository;

    @Autowired
    private ISeguroVidaMapper seguroVidaMapper;

    @Override
    public SeguroVidaSimulacao salvarSimulacao(SeguroVidaSimulacao seguroVidaSimulacao) {
        return seguroVidaMapper.toSeguroVidaSimulacao(seguroVidaSimulacaoRepository
                .save(seguroVidaMapper.toSeguroVidaSimulacaoEntity(seguroVidaSimulacao)));
    }

    @Override
    public Optional<SeguroVidaSimulacao> buscarSimulacaoPorId(UUID idSimulacao) {
        return seguroVidaSimulacaoRepository.findById(idSimulacao).map(entity -> 
            seguroVidaMapper.toSeguroVidaSimulacao(entity));
    }

    @Override
    public SeguroVidaContratacao salvarContratacao(SeguroVidaContratacao seguroVidaContratacao) {
        return seguroVidaMapper.toSeguroVidaContratacao(seguroVidaContratacaoRepository
                .save(seguroVidaMapper.toSeguroVidaContratacaoEntity(seguroVidaContratacao)));
    }

    

 
}
