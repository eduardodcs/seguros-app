package com.bank.seguros.adapters.interfaces.gateways;

import com.bank.seguros.core.commons.entities.Cliente;

public interface IClienteGateway {

    Cliente buscarPorCpf(String cpf);

}
