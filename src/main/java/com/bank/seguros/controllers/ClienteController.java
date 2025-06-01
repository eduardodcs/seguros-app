package com.bank.seguros.controllers;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.seguros.adapters.interfaces.gateways.IClienteGateway;
import com.bank.seguros.client.dtos.ClienteDTO;
import com.bank.seguros.mappers.IClienteMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/clientes-seguros")
public class ClienteController {

    @Autowired
    private IClienteGateway clienteGateway;

    @Autowired
    private IClienteMapper clienteMapper;

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarClientePorCPF(@PathVariable @CPF(message = "CPF inválido") String cpf) {
        return ResponseEntity.ok(clienteMapper.toClienteDTO(clienteGateway.buscarPorCpf(cpf)));
    }
    

}
