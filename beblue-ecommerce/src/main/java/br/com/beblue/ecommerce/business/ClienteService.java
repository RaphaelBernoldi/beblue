package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.entity.Cliente;
import br.com.beblue.ecommerce.exception.BeblueErroException;

public interface ClienteService {

	Cliente buscaClientePorCpf(String cpf) throws BeblueErroException;
	Cliente salva(Cliente cliente) throws BeblueErroException;
}
