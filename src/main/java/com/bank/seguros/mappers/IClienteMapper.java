package com.bank.seguros.mappers;

import org.mapstruct.Mapper;

import com.bank.seguros.client.dtos.ClienteDTO;
import com.bank.seguros.core.commons.entities.Cliente;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    Cliente toCliente(ClienteDTO clienteDTO);
    ClienteDTO toClienteDTO(Cliente cliente);

}
