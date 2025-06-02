package com.bank.seguros.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.common_web.exceptions.BusinessException;
import com.bank.seguros.adapters.gateways.IClienteGateway;
import com.bank.seguros.client.dtos.ClienteDTO;
import com.bank.seguros.core.commons.entities.Cliente;
import com.bank.seguros.mappers.IClienteMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ClienteClient implements IClienteGateway {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IClienteMapper clienteMapper;
    
    @Value("${cliente.url}")
    private String clienteUrl;

    @Override
    @CircuitBreaker(name = "clienteService", fallbackMethod = "fallbackBuscarCliente")
    public Cliente buscarPorCpf(String cpf) {
    String url = String.format("%s/cliente/%s", clienteUrl, cpf);
        ClienteDTO clienteDTO = restTemplate.getForObject(url, ClienteDTO.class);
        return clienteMapper.toCliente(clienteDTO);
    }

    public Cliente fallbackBuscarCliente(String cpf, Throwable throwable) {
        throw new BusinessException("Serviço de cliente indisponível. Por favor, tente novamente mais tarde.", throwable);
    }

}
