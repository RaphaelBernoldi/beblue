package br.com.beblue.ecommerce.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.ClienteService;
import br.com.beblue.ecommerce.domain.entity.Cliente;
import br.com.beblue.ecommerce.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente buscaClientePorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente salva(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
