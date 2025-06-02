package com.bank.seguros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.seguros.adapters.usecases.ISeguroVidaUseCase;
import com.bank.seguros.controllers.dtos.SeguroVidaContratacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaPedidoContratacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaPedidoSimulacaoDTO;
import com.bank.seguros.controllers.dtos.SeguroVidaSimulacaoDTO;
import com.bank.seguros.mappers.ISeguroVidaMapper;

import jakarta.validation.Valid;

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
        return ResponseEntity.ok(seguroVidaMapper
            .toSeguroVidaSimulacaoDTO(seguroVidaUseCase
                .simular(seguroVidaMapper.toSeguroVidaPedidoSimulacao(seguroVidaPedidoSimulacaoDTO))));
    }

    @PostMapping("/contratar")
    public ResponseEntity<SeguroVidaContratacaoDTO> contratarSeguro(@Valid
            @RequestBody SeguroVidaPedidoContratacaoDTO seguroVidaPedidoContratacaoDTO) {
        return ResponseEntity.ok(seguroVidaMapper
            .toSeguroVidaPedidoContratacaoDTO(seguroVidaUseCase
                .contratar(seguroVidaMapper.toSeguroVidaPedidoContratacao(seguroVidaPedidoContratacaoDTO))));
    }
    
}
