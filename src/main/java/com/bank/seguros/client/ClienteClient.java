package com.bank.seguros.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.bank.common_web.dtos.ErrorResponseDTO;
import com.bank.common_web.exceptions.BusinessException;
import com.bank.common_web.exceptions.NotFoundException;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @CircuitBreaker(name = "clienteService", fallbackMethod = "fallbackBuscarCliente")
    public Cliente buscarPorCpf(String cpf) {
        String url = String.format("%s/cliente/%s", clienteUrl, cpf);
        try {
            ResponseEntity<ClienteDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    ClienteDTO.class
            );
            return clienteMapper.toCliente(response.getBody());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                ErrorResponseDTO erro;
                try {
                    erro = objectMapper.readValue(e.getResponseBodyAsString(), ErrorResponseDTO.class);
                    throw new NotFoundException(erro.getMessage());
                } catch (JsonProcessingException e1) {
                    throw new BusinessException("Erro ao buscar cliente", e);
                }
            }
            throw new BusinessException("Erro ao buscar cliente", e);
           
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar cliente", e);
        }
    }

    

    public Cliente fallbackBuscarCliente(String cpf, BusinessException be) {
        throw new BusinessException("Serviço de cliente indisponível. Por favor, tente novamente mais tarde.", be);
    }

}
