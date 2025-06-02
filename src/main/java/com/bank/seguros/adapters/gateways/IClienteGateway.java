package com.bank.seguros.adapters.gateways;

import com.bank.seguros.core.commons.entities.Cliente;

public interface IClienteGateway {

    Cliente buscarPorCpf(String cpf);

}
