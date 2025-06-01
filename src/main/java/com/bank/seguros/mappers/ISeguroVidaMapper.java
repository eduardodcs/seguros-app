package com.bank.seguros.mappers;

import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

import com.bank.seguros.controllers.dtos.CoberturaDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaPedidoSimulacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaSimulacaoDTO;
import com.bank.seguros.core.ICobertura;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;

@Mapper(componentModel = "spring")
public interface ISeguroVidaMapper {

    @ObjectFactory
    default SeguroVidaPedidoSimulacao toSeguroVidaPedidoSimulacao(SeguroVidaPedidoSimulacaoDTO dto) {
        return new SeguroVidaPedidoSimulacao.Builder()
                .tipoPlano(dto.getTipoPlano())
                .dataNascimento(dto.getDataNascimento())
                .build();
    }

    @ObjectFactory
    default CoberturaDTO toCoberturaDTO(ICobertura cobertura) {
        return new CoberturaDTO.Builder()
                .descricao(cobertura.getDescricao())
                .valorPremio(cobertura.getValorPremio().doubleValue())
                .valorCapitalSegurado(cobertura.getValorCapitalSegurado().doubleValue())
                .build();
    }

    @ObjectFactory
    default SeguroVidaSimulacaoDTO toSeguroVidaSimulacaoDTO(SeguroVidaSimulacao seguroVidaSimulacao) {
        return new SeguroVidaSimulacaoDTO.Builder()
                .tipoPlano(seguroVidaSimulacao.getTipoPlano())
                .dataHoraSimulacao(seguroVidaSimulacao.getDataHoraSimulacao())
                .valorPremioMensal(seguroVidaSimulacao.getValorPremioMensal())
                .dataValidadeSimulacao(seguroVidaSimulacao.getDataValidadeSimulacao())
                .descricaoSeguro(seguroVidaSimulacao.getDescricaoSeguro())
                .idSimulacao(seguroVidaSimulacao.getIdSimulacao())
                .coberturas(seguroVidaSimulacao.getCoberturas().stream()
                        .map(this::toCoberturaDTO)
                        .collect(Collectors.toSet()))
                .build();
    }

}
