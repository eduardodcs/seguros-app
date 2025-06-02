package com.bank.seguros.mappers;

import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

import com.bank.common_web.exceptions.BusinessException;
import com.bank.seguros.controllers.dtos.CoberturaDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaContratacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaPedidoContratacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaPedidoSimulacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaSimulacaoDTO;
import com.bank.seguros.core.ICobertura;
import com.bank.seguros.core.commons.constants.CoberturaId;
import com.bank.seguros.core.commons.entities.Cliente;
import com.bank.seguros.core.vida.entities.SeguroVidaContratacao;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoContratacao;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;
import com.bank.seguros.core.vida.entities.cobertura.CoberturaDoencaGrave;
import com.bank.seguros.core.vida.entities.cobertura.CoberturaInvalidez;
import com.bank.seguros.core.vida.entities.cobertura.CoberturaMorte;
import com.bank.seguros.repositories.entities.CoberturaEntity;
import com.bank.seguros.repositories.entities.SeguroVidaContratacaoEntity;
import com.bank.seguros.repositories.entities.SeguroVidaSimulacaoEntity;

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
        default CoberturaEntity toCoberturaEntity(ICobertura cobertura) {
                return new CoberturaEntity.Builder()
                        .id(cobertura.getId())          
                        .descricao(cobertura.getDescricao())
                        .valorPremio(cobertura.getValorPremio().doubleValue())
                        .valorCapitalSegurado(cobertura.getValorCapitalSegurado().doubleValue())
                        .build();
        }

        @ObjectFactory
        default ICobertura toCobertura(CoberturaEntity coberturaEntity) {
                if(coberturaEntity.getId() == CoberturaId.VIDA_COBERTURA_DOENCA_GRAVE.getId()){
                        return new CoberturaDoencaGrave();
                } else if(coberturaEntity.getId() == CoberturaId.VIDA_COBERTURA_MORTE.getId()){
                        return new CoberturaMorte();
                } else if(coberturaEntity.getId() == CoberturaId.VIDA_COBERTURA_INVALIDEZ.getId()){
                        return new CoberturaInvalidez();
                } else {
                        throw new BusinessException("Cobertura desconhecida: " + coberturaEntity.getId());
                }
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

        

        @ObjectFactory
        default SeguroVidaSimulacao toSeguroVidaSimulacao(SeguroVidaSimulacaoEntity seguroVidaSimulacaoEntity) {
                return new SeguroVidaSimulacao.Builder()
                        .idSimulacao(seguroVidaSimulacaoEntity.getIdSimulacao())
                        .tipoPlano(seguroVidaSimulacaoEntity.getTipoPlano())
                        .dataHoraSimulacao(seguroVidaSimulacaoEntity.getDataHoraSimulacao())
                        .build();
        }


        @ObjectFactory
        default SeguroVidaSimulacaoEntity toSeguroVidaSimulacaoEntity(SeguroVidaSimulacao seguroVidaSimulacao) {
                return new SeguroVidaSimulacaoEntity.Builder()
                        .idSimulacao(seguroVidaSimulacao.getIdSimulacao())
                        .tipoPlano(seguroVidaSimulacao.getTipoPlano())
                        .descricaoSeguro(seguroVidaSimulacao.getDescricaoSeguro())
                        .coberturas(seguroVidaSimulacao.getCoberturas().stream()
                                .map(this::toCoberturaEntity)
                                .collect(Collectors.toSet()))
                        .valorPremioMensal(seguroVidaSimulacao.getValorPremioMensal())
                        .dataHoraSimulacao(seguroVidaSimulacao.getDataHoraSimulacao())
                        .dataValidadeSimulacao(seguroVidaSimulacao.getDataValidadeSimulacao())
                        .build();       
        }

        @ObjectFactory
        default SeguroVidaContratacaoEntity toSeguroVidaContratacaoEntity(SeguroVidaContratacao seguroVidaContratacao) {
                return new SeguroVidaContratacaoEntity.Builder()
                        .apolice(seguroVidaContratacao.getApolice())
                        .idCliente(seguroVidaContratacao.getCliente().getId())
                        .idSimulacao(seguroVidaContratacao.getIdSimulacao())
                        .tipoPlano(seguroVidaContratacao.getTipoPlano())
                        .descricaoSeguro(seguroVidaContratacao.getDescricaoSeguro())
                        .coberturas(seguroVidaContratacao.getCoberturas().stream()
                                .map(this::toCoberturaEntity)
                                .collect(Collectors.toSet()))
                        .valorPremioMensal(seguroVidaContratacao.getValorPremioMensal())
                        .dataHoraSimulacao(seguroVidaContratacao.getDataHoraSimulacao())
                        .dataHoraContratacao(seguroVidaContratacao.getDataHoraContratacao())
                        .build();
        }

        @ObjectFactory
        default SeguroVidaContratacao toSeguroVidaContratacao(SeguroVidaContratacaoEntity seguroVidaContratacaoEntity) {
                return new SeguroVidaContratacao.Builder()
                        .apolice(seguroVidaContratacaoEntity.getApolice())
                        .cliente(new Cliente.Builder()
                                .id(seguroVidaContratacaoEntity.getIdCliente())
                                .nome(seguroVidaContratacaoEntity.getNomeCliente())
                                .cpf(seguroVidaContratacaoEntity.getCpfCliente())
                                .build())
                        .idSimulacao(seguroVidaContratacaoEntity.getIdSimulacao())
                        .tipoPlano(seguroVidaContratacaoEntity.getTipoPlano())
                        .dataHoraSimulacao(seguroVidaContratacaoEntity.getDataHoraSimulacao())
                        .dataHoraContratacao(seguroVidaContratacaoEntity.getDataHoraContratacao())
                        .build();
        }

        @ObjectFactory
        default SeguroVidaContratacaoDTO toSeguroVidaPedidoContratacaoDTO(SeguroVidaContratacao seguroVidaContratacao) {
                return new SeguroVidaContratacaoDTO.Builder()
                        .apolice(seguroVidaContratacao.getApolice())
                        .idCliente(seguroVidaContratacao.getCliente().getId())
                        .idSimulacao(seguroVidaContratacao.getIdSimulacao())
                        .tipoPlano(seguroVidaContratacao.getTipoPlano())
                        .descricaoSeguro(seguroVidaContratacao.getDescricaoSeguro())
                        .coberturas(seguroVidaContratacao.getCoberturas().stream()
                                .map(this::toCoberturaDTO)
                                .collect(Collectors.toSet()))
                        .valorPremioMensal(seguroVidaContratacao.getValorPremioMensal())
                        .dataHoraSimulacao(seguroVidaContratacao.getDataHoraSimulacao())
                        .dataHoraContratacao(seguroVidaContratacao.getDataHoraContratacao())
                        .build();
        }

        @ObjectFactory
        default SeguroVidaPedidoContratacaoDTO toSeguroVidaPedidoContratacaoDTO(SeguroVidaPedidoContratacao seguroVidaPedidoContratacao) {
                return new SeguroVidaPedidoContratacaoDTO.Builder()
                        .idSimulacao(seguroVidaPedidoContratacao.getIdSimulacao())
                        .cpfCliente(seguroVidaPedidoContratacao.getCpfCliente())
                        .build();
        }

        @ObjectFactory
        default SeguroVidaPedidoContratacao toSeguroVidaPedidoContratacao(SeguroVidaPedidoContratacaoDTO seguroVidaPedidoContratacaoDTO) {
                return new SeguroVidaPedidoContratacao.Builder()
                        .idSimulacao(seguroVidaPedidoContratacaoDTO.getIdSimulacao())
                        .cpfCliente(seguroVidaPedidoContratacaoDTO.getCpfCliente())
                        .build();
        }

}
