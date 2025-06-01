package com.bank.seguros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.seguros.adapters.interfaces.usecases.ISeguroVidaUseCase;
import com.bank.seguros.controllers.dtos.SeguroVidaPedidoSimulacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaSimulacaoDTO;
import com.bank.seguros.core.vida.entities.SeguroVidaPedidoSimulacao;
import com.bank.seguros.core.vida.entities.SeguroVidaSimulacao;
import com.bank.seguros.mappers.ISeguroVidaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/seguros/vida")
public class SeguroVidaController {

    @Autowired
    private ISeguroVidaMapper seguroVidaMapper;

    @Autowired
    private ISeguroVidaUseCase seguroVidaUseCase;


    @PostMapping("/simular")
    public ResponseEntity<SeguroVidaSimulacaoDTO> simularSeguro(
        @RequestBody SeguroVidaPedidoSimulacaoDTO seguroVidaPedidoSimulacaoDTO) {
        SeguroVidaPedidoSimulacao pedido = seguroVidaMapper.toSeguroVidaPedidoSimulacao(seguroVidaPedidoSimulacaoDTO);
        SeguroVidaSimulacao simulacao = seguroVidaUseCase.simular(pedido);
        return ResponseEntity.ok(
            seguroVidaMapper.toSeguroVidaSimulacaoDTO(simulacao));
    }
    
}
