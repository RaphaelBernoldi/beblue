package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.entity.Cliente;

public interface ClienteService {

	Cliente buscaClientePorCpf(String cpf);
	Cliente salva(Cliente cliente);
}
